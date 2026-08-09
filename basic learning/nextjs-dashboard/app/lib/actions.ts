'use server';

import { z } from 'zod';
import { revalidatePath } from 'next/cache';
import { redirect } from 'next/navigation';
import postgres from 'postgres';
import { createLocalInvoice, deleteLocalInvoice, updateLocalInvoice } from './local-db';
import { signIn } from '@/auth';
import { AuthError } from 'next-auth';

const FormSchema = z.object({
  id: z.string(),
  customerId: z.string({
    invalid_type_error: 'Please select a customer.',
  }),
  amount: z.coerce.number()
  .gt(0, {message: 'Please enter an amount greater than $0'}),
  status: z.enum(['pending', 'paid'], {
    invalid_type_error: 'Please seletect an invoice status.',
  }),
  date: z.string(),
});

export type State = {
  errors?: {
    customerId?: string[];
    amount?: string[];
    status?: string[];
  };
  message?: string | null;
}

const CreateInvoice = FormSchema.omit({ id: true, date: true });
const UpdateInvoice = FormSchema.omit({ id: true, date: true });

// Coursework Postgres client — kept for the Learn tutorial SQL path.
const sql = process.env.POSTGRES_URL
  ? postgres(process.env.POSTGRES_URL, {
    ssl: process.env.POSTGRES_SSL === 'false' ? false : 'require',
  })
  : null;

export async function createInvoice(prevState: State, formData: FormData): Promise<State> {
  const validatedFields = CreateInvoice.safeParse({
    customerId: formData.get('customerId'),
    amount: formData.get('amount'),
    status: formData.get('status'),
  });

  if (!validatedFields.success) {
    return {
      errors: validatedFields.error.flatten().fieldErrors,
      message: 'Missing Fields. Failed to Create Invoice.',
    };
  }

  const { customerId, amount, status } = validatedFields.data;
  const amountInCents = amount * 100;
  const date = new Date().toISOString().split('T')[0];

  try {
    if (!sql) throw new Error('No database configured');

    // Tutorial / coursework Postgres insert (kept intentionally)
    await sql`
      INSERT INTO invoices (customer_id, amount, status, date)
      VALUES (${customerId}, ${amountInCents}, ${status}, ${date})
    `;
  } catch (error) {
    // Local fallback when Postgres is missing or fails
    console.error('Database Error (using local invoice insert):', error);
    createLocalInvoice({
      customer_id: customerId,
      amount: amountInCents,
      status,
      date,
    });
  }

  revalidatePath('/dashboard/invoices');
  redirect('/dashboard/invoices');
}

export async function updateInvoice(
  id: string,
  prevState: State,
  formData: FormData,
): Promise<State> {
  const validatedFields = UpdateInvoice.safeParse({
    customerId: formData.get('customerId'),
    amount: formData.get('amount'),
    status: formData.get('status'),
  });

  if (!validatedFields.success) {
    return {
      errors: validatedFields.error.flatten().fieldErrors,
      message: 'Missing Fields. Failed to update Invoice.',
    };
  }

  const{ customerId, amount, status} = validatedFields.data;
  const amountInCents = amount * 100;

  try {
    if (!sql) throw new Error('No database configured');

    await sql`
      UPDATE invoices
    SET customer_id = ${customerId}, amount = ${amountInCents}, status = ${status}
    WHERE id = ${id}
    `;
  } catch (error) {
    // Local fallback when Postgres is missing or fails
    console.error('Database Error (using local invoice update):', error);
    updateLocalInvoice(id, {
      customer_id: customerId,
      amount: amountInCents,
      status,
    });
  }

  revalidatePath('/dashboard/invoices');
  redirect('/dashboard/invoices');
}

export async function deleteInvoice(id: string) {
  try {
    if(!sql) throw new Error('no database configured');

    await sql`DELETE FROM invoices WHERE id = ${id}`;
  } catch (error) {
    console.error('Database Error (using local invoice delete):', error);
    deleteLocalInvoice(id);
  }
  
  revalidatePath('/dashboard/invoices');
}

export async function authenticate(
  prevState: string | undefined,
  formData: FormData,
) {
  try {
    await signIn('credentials', formData);
  } catch (error) {
    if (error instanceof AuthError) {
      switch (error.type) {
        case 'CredentialsSignin':
          return 'Invalid credentials.';
        default:
          return 'Something went wrong.';
      }
    }
    throw error;
  }
}