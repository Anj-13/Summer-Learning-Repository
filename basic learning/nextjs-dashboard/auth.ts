import NextAuth from 'next-auth';
import Credentials from 'next-auth/providers/credentials';
import bcrypt from 'bcrypt';
import postgres from 'postgres';
import { z } from 'zod';
import type { User } from '@/app/lib/definitions';
import { getLocalUserByEmail } from '@/app/lib/local-db';
import { authConfig } from './auth.config';

// Coursework Postgres client — kept for the Learn tutorial SQL path.
const sql = process.env.POSTGRES_URL
  ? postgres(process.env.POSTGRES_URL, {
      ssl: process.env.POSTGRES_SSL === 'false' ? false : 'require',
    })
  : null;

async function getUser(email: string): Promise<User | undefined> {
  try {
    if (!sql) throw new Error('No database configured');

    // Tutorial / coursework Postgres lookup (kept intentionally)
    const user = await sql<User[]>`SELECT * FROM users WHERE email=${email}`;
    return user[0];
  } catch (error) {
    // Local fallback when Postgres is missing or fails
    console.error('Failed to fetch user (using local):', error);
    return getLocalUserByEmail(email);
  }
}

export const { auth, signIn, signOut } = NextAuth({
  ...authConfig,
  providers: [
    Credentials({
      async authorize(credentials) {
        const parsedCredentials = z
          .object({ email: z.string().email(), password: z.string().min(6) })
          .safeParse(credentials);

        if (parsedCredentials.success) {
          const { email, password } = parsedCredentials.data;
          const user = await getUser(email);
          if (!user) return null;
          const passwordsMatch = await bcrypt.compare(password, user.password);

          if (passwordsMatch) return user;
        }

        console.log('Invalid credentials');
        return null;
      },
    }),
  ],
});
