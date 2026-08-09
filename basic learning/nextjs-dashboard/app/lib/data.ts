import postgres from 'postgres';
import {
  CustomerField,
  CustomersTableType,
  InvoiceForm,
  InvoicesTable,
  LatestInvoiceRaw,
  Revenue,
} from './definitions';
import { formatCurrency } from './utils';
import {
  customers as localCustomers,
  invoices as localInvoices,
  revenue as localRevenue,
} from './placeholder-data';

const sql = process.env.POSTGRES_URL
  ? postgres(process.env.POSTGRES_URL, {
      ssl: process.env.POSTGRES_SSL === 'false' ? false : 'require',
    })
  : null;

const localInvoicesWithIds = localInvoices.map((invoice, index) => ({
  ...invoice,
  id: `local-invoice-${index + 1}`,
  status: invoice.status as 'pending' | 'paid',
}));

function getLocalJoinedInvoices(): InvoicesTable[] {
  return localInvoicesWithIds
    .map((invoice) => {
      const customer = localCustomers.find((c) => c.id === invoice.customer_id);
      if (!customer) return null;
      return {
        id: invoice.id,
        customer_id: invoice.customer_id,
        name: customer.name,
        email: customer.email,
        image_url: customer.image_url,
        date: invoice.date,
        amount: invoice.amount,
        status: invoice.status,
      };
    })
    .filter((invoice): invoice is InvoicesTable => invoice !== null)
    .sort((a, b) => b.date.localeCompare(a.date));
}

function matchesQuery(value: string, query: string) {
  return value.toLowerCase().includes(query.toLowerCase());
}

export async function fetchRevenue() {
  try {
    if (!sql) throw new Error('No database configured');
    const data = await sql<Revenue[]>`SELECT * FROM revenue`;
    
    return data;
  } catch (error) {
    console.error('Database Error (using local revenue):', error);
    return localRevenue;
  }
}

export async function fetchLatestInvoices() {
  try {
    if (!sql) throw new Error('No database configured');
    const data = await sql<LatestInvoiceRaw[]>`
      SELECT invoices.amount, customers.name, customers.image_url, customers.email, invoices.id
      FROM invoices
      JOIN customers ON invoices.customer_id = customers.id
      ORDER BY invoices.date DESC
      LIMIT 5`;

    return data.map((invoice) => ({
      ...invoice,
      amount: formatCurrency(invoice.amount),
    }));
  } catch (error) {
    console.error('Database Error (using local latest invoices):', error);
    return getLocalJoinedInvoices()
      .slice(0, 5)
      .map((invoice) => ({
        id: invoice.id,
        name: invoice.name,
        image_url: invoice.image_url,
        email: invoice.email,
        amount: formatCurrency(invoice.amount),
      }));
  }
}

export async function fetchCardData() {
  try {
    if (!sql) throw new Error('No database configured');
    const invoiceCountPromise = sql`SELECT COUNT(*) FROM invoices`;
    const customerCountPromise = sql`SELECT COUNT(*) FROM customers`;
    const invoiceStatusPromise = sql`SELECT
         SUM(CASE WHEN status = 'paid' THEN amount ELSE 0 END) AS "paid",
         SUM(CASE WHEN status = 'pending' THEN amount ELSE 0 END) AS "pending"
         FROM invoices`;

    const data = await Promise.all([
      invoiceCountPromise,
      customerCountPromise,
      invoiceStatusPromise,
    ]);

    return {
      numberOfCustomers: Number(data[1][0].count ?? '0'),
      numberOfInvoices: Number(data[0][0].count ?? '0'),
      totalPaidInvoices: formatCurrency(data[2][0].paid ?? '0'),
      totalPendingInvoices: formatCurrency(data[2][0].pending ?? '0'),
    };
  } catch (error) {
    console.error('Database Error (using local card data):', error);
    const paid = localInvoicesWithIds
      .filter((invoice) => invoice.status === 'paid')
      .reduce((sum, invoice) => sum + invoice.amount, 0);
    const pending = localInvoicesWithIds
      .filter((invoice) => invoice.status === 'pending')
      .reduce((sum, invoice) => sum + invoice.amount, 0);

    return {
      numberOfCustomers: localCustomers.length,
      numberOfInvoices: localInvoicesWithIds.length,
      totalPaidInvoices: formatCurrency(paid),
      totalPendingInvoices: formatCurrency(pending),
    };
  }
}

const ITEMS_PER_PAGE = 6;

export async function fetchFilteredInvoices(
  query: string,
  currentPage: number,
) {
  const offset = (currentPage - 1) * ITEMS_PER_PAGE;

  try {
    if (!sql) throw new Error('No database configured');
    const invoices = await sql<InvoicesTable[]>`
      SELECT
        invoices.id,
        invoices.amount,
        invoices.date,
        invoices.status,
        customers.name,
        customers.email,
        customers.image_url
      FROM invoices
      JOIN customers ON invoices.customer_id = customers.id
      WHERE
        customers.name ILIKE ${`%${query}%`} OR
        customers.email ILIKE ${`%${query}%`} OR
        invoices.amount::text ILIKE ${`%${query}%`} OR
        invoices.date::text ILIKE ${`%${query}%`} OR
        invoices.status ILIKE ${`%${query}%`}
      ORDER BY invoices.date DESC
      LIMIT ${ITEMS_PER_PAGE} OFFSET ${offset}
    `;

    return invoices;
  } catch (error) {
    console.error('Database Error (using local invoices):', error);
    return getLocalJoinedInvoices()
      .filter(
        (invoice) =>
          matchesQuery(invoice.name, query) ||
          matchesQuery(invoice.email, query) ||
          matchesQuery(String(invoice.amount), query) ||
          matchesQuery(invoice.date, query) ||
          matchesQuery(invoice.status, query),
      )
      .slice(offset, offset + ITEMS_PER_PAGE);
  }
}

export async function fetchInvoicesPages(query: string) {
  try {
    if (!sql) throw new Error('No database configured');
    const data = await sql`SELECT COUNT(*)
    FROM invoices
    JOIN customers ON invoices.customer_id = customers.id
    WHERE
      customers.name ILIKE ${`%${query}%`} OR
      customers.email ILIKE ${`%${query}%`} OR
      invoices.amount::text ILIKE ${`%${query}%`} OR
      invoices.date::text ILIKE ${`%${query}%`} OR
      invoices.status ILIKE ${`%${query}%`}
  `;

    return Math.ceil(Number(data[0].count) / ITEMS_PER_PAGE);
  } catch (error) {
    console.error('Database Error (using local invoice pages):', error);
    const count = getLocalJoinedInvoices().filter(
      (invoice) =>
        matchesQuery(invoice.name, query) ||
        matchesQuery(invoice.email, query) ||
        matchesQuery(String(invoice.amount), query) ||
        matchesQuery(invoice.date, query) ||
        matchesQuery(invoice.status, query),
    ).length;
    return Math.ceil(count / ITEMS_PER_PAGE);
  }
}

export async function fetchInvoiceById(id: string) {
  try {
    if (!sql) throw new Error('No database configured');
    const data = await sql<InvoiceForm[]>`
      SELECT
        invoices.id,
        invoices.customer_id,
        invoices.amount,
        invoices.status
      FROM invoices
      WHERE invoices.id = ${id};
    `;

    const invoice = data.map((invoice) => ({
      ...invoice,
      amount: invoice.amount / 100,
    }));

    return invoice[0];
  } catch (error) {
    console.error('Database Error (using local invoice by id):', error);
    const invoice = localInvoicesWithIds.find((item) => item.id === id);
    if (!invoice) return undefined;

    return {
      id: invoice.id,
      customer_id: invoice.customer_id,
      amount: invoice.amount / 100,
      status: invoice.status,
    };
  }
}

export async function fetchCustomers() {
  try {
    if (!sql) throw new Error('No database configured');
    const customers = await sql<CustomerField[]>`
      SELECT
        id,
        name
      FROM customers
      ORDER BY name ASC
    `;

    return customers;
  } catch (err) {
    console.error('Database Error (using local customers):', err);
    return [...localCustomers]
      .map(({ id, name }) => ({ id, name }))
      .sort((a, b) => a.name.localeCompare(b.name));
  }
}

export async function fetchFilteredCustomers(query: string) {
  try {
    if (!sql) throw new Error('No database configured');
    const data = await sql<CustomersTableType[]>`
		SELECT
		  customers.id,
		  customers.name,
		  customers.email,
		  customers.image_url,
		  COUNT(invoices.id) AS total_invoices,
		  SUM(CASE WHEN invoices.status = 'pending' THEN invoices.amount ELSE 0 END) AS total_pending,
		  SUM(CASE WHEN invoices.status = 'paid' THEN invoices.amount ELSE 0 END) AS total_paid
		FROM customers
		LEFT JOIN invoices ON customers.id = invoices.customer_id
		WHERE
		  customers.name ILIKE ${`%${query}%`} OR
        customers.email ILIKE ${`%${query}%`}
		GROUP BY customers.id, customers.name, customers.email, customers.image_url
		ORDER BY customers.name ASC
	  `;

    return data.map((customer) => ({
      ...customer,
      total_pending: formatCurrency(customer.total_pending),
      total_paid: formatCurrency(customer.total_paid),
    }));
  } catch (err) {
    console.error('Database Error (using local filtered customers):', err);
    return localCustomers
      .filter(
        (customer) =>
          matchesQuery(customer.name, query) ||
          matchesQuery(customer.email, query),
      )
      .map((customer) => {
        const customerInvoices = localInvoicesWithIds.filter(
          (invoice) => invoice.customer_id === customer.id,
        );
        const totalPending = customerInvoices
          .filter((invoice) => invoice.status === 'pending')
          .reduce((sum, invoice) => sum + invoice.amount, 0);
        const totalPaid = customerInvoices
          .filter((invoice) => invoice.status === 'paid')
          .reduce((sum, invoice) => sum + invoice.amount, 0);

        return {
          id: customer.id,
          name: customer.name,
          email: customer.email,
          image_url: customer.image_url,
          total_invoices: customerInvoices.length,
          total_pending: formatCurrency(totalPending),
          total_paid: formatCurrency(totalPaid),
        };
      })
      .sort((a, b) => a.name.localeCompare(b.name));
  }
}
