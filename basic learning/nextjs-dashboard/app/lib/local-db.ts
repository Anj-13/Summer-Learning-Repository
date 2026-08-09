/**
 * In-memory local database used when Postgres is unavailable.
 * Keeps coursework SQL paths intact: data.ts / actions.ts / auth.ts try Postgres first,
 * then fall back here. Data resets when the Next.js server restarts.
 */
import bcrypt from 'bcrypt';
import {
  customers as seedCustomers,
  invoices as seedInvoices,
  revenue as seedRevenue,
  users as seedUsers,
} from './placeholder-data';
import type { InvoicesTable, User } from './definitions';

export type LocalInvoice = {
  id: string;
  customer_id: string;
  amount: number;
  status: 'pending' | 'paid';
  date: string;
};

// Hash passwords once at startup so bcrypt.compare works like the seeded Postgres users.
export const localUsers: User[] = seedUsers.map((user) => ({
  ...user,
  password: bcrypt.hashSync(user.password, 10),
}));
export const localCustomers = [...seedCustomers];
export const localRevenue = [...seedRevenue];

export function getLocalUserByEmail(email: string): User | undefined {
  return localUsers.find(
    (user) => user.email.toLowerCase() === email.toLowerCase(),
  );
}

export const localInvoices: LocalInvoice[] = seedInvoices.map(
  (invoice, index) => ({
    ...invoice,
    id: `local-invoice-${index + 1}`,
    status: invoice.status as 'pending' | 'paid',
  }),
);

export function getLocalJoinedInvoices(): InvoicesTable[] {
  return localInvoices
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

export function createLocalInvoice(input: {
  customer_id: string;
  amount: number;
  status: 'pending' | 'paid';
  date: string;
}) {
  const invoice: LocalInvoice = {
    id: `local-invoice-${Date.now()}`,
    customer_id: input.customer_id,
    amount: input.amount,
    status: input.status,
    date: input.date,
  };
  localInvoices.unshift(invoice);
  return invoice;
}

export function updateLocalInvoice(
  id: string,
  input: {
    customer_id: string;
    amount: number;
    status: 'pending' | 'paid';
  },
) {
  const invoice = localInvoices.find((item) => item.id === id);
  if (!invoice) return undefined;
  invoice.customer_id = input.customer_id;
  invoice.amount = input.amount;
  invoice.status = input.status;
  return invoice;
}

export function deleteLocalInvoice(id: string) {
  const index = localInvoices.findIndex((item) => item.id === id);
  if (index === -1) return false;
  localInvoices.splice(index, 1);
  return true;
}
