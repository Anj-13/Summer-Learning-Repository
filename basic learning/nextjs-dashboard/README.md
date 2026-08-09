## Next.js App Router Course - Starter

This is the starter template for the Next.js App Router Course. It contains the starting code for the dashboard application.

For more information, see the [course curriculum](https://nextjs.org/learn) on the Next.js Website.

---

# Next.js Financial Dashboard

A full-stack Next.js App Router learning project that builds a financial dashboard for invoices, customers, and revenue — following the official [Next.js Learn](https://nextjs.org/learn/dashboard-app) course while supporting **local in-memory data** so you can study without Vercel Postgres.

## Features

- **Browse** a public home page and protected dashboard overview
- **View** revenue charts, latest invoices, and summary cards
- **Search** and **paginate** invoices (and customers) via URL search params
- **Create**, **edit**, and **delete** invoices with React Server Actions
- **Validate** form input with Zod on the server
- **Authenticate** users with NextAuth.js (credentials)
- **Fall back** to a local in-memory database when Postgres / Vercel is unavailable
- **Keep** the coursework SQL / Postgres paths intact so you can still follow the official chapters

## Course Curriculum (Chapters 1–16)

Follow along with the official course: [App Router Dashboard](https://nextjs.org/learn/dashboard-app)

| # | Chapter | What you learn |
| ---: | --- | --- |
| 1 | [Getting Started](https://nextjs.org/learn/dashboard-app/getting-started) | Create the app and run the local dev server |
| 2 | [CSS Styling](https://nextjs.org/learn/dashboard-app/css-styling) | Style with Tailwind and CSS Modules |
| 3 | [Optimizing Fonts and Images](https://nextjs.org/learn/dashboard-app/optimizing-fonts-images) | Use `next/font` and `next/image` |
| 4 | [Creating Layouts and Pages](https://nextjs.org/learn/dashboard-app/creating-layouts-and-pages) | File-system routing, nested layouts |
| 5 | [Navigating Between Pages](https://nextjs.org/learn/dashboard-app/navigating-between-pages) | Client-side navigation with `<Link>` |
| 6 | [Setting Up Your Database](https://nextjs.org/learn/dashboard-app/setting-up-your-database) | Vercel Postgres seeding *(optional here — see Local Database)* |
| 7 | [Fetching Data](https://nextjs.org/learn/dashboard-app/fetching-data) | Server Components + SQL / local fetch helpers |
| 8 | [Static and Dynamic Rendering](https://nextjs.org/learn/dashboard-app/static-and-dynamic-rendering) | When pages are static vs dynamic |
| 9 | [Streaming](https://nextjs.org/learn/dashboard-app/streaming) | Streaming UI and loading skeletons |
| 10 | [Adding Search and Pagination](https://nextjs.org/learn/dashboard-app/adding-search-and-pagination) | Search params for filter + pages |
| 11 | [Mutating Data](https://nextjs.org/learn/dashboard-app/mutating-data) | Server Actions, revalidate, redirect |
| 12 | [Handling Errors](https://nextjs.org/learn/dashboard-app/error-handling) | `error.tsx` and `not-found` |
| 13 | [Improving Accessibility](https://nextjs.org/learn/dashboard-app/improving-accessibility) | Server-side validation and a11y |
| 14 | [Adding Authentication](https://nextjs.org/learn/dashboard-app/adding-authentication) | NextAuth.js + protected routes |
| 15 | [Adding Metadata](https://nextjs.org/learn/dashboard-app/adding-metadata) | Metadata and social sharing |
| 16 | [Next Steps](https://nextjs.org/learn/dashboard-app/next-steps) | Course conclusion and where to go next |

## Dashboard Navigation

```
Acme Dashboard
├── Home (/)                    — public landing
├── Login (/login)              — credentials auth
└── Dashboard (protected)
    ├── Overview (/dashboard)           — cards, revenue, latest invoices
    ├── Invoices (/dashboard/invoices)  — search, pagination, CRUD
    │   ├── Create (/dashboard/invoices/create)
    │   └── Edit   (/dashboard/invoices/[id]/edit)
    └── Customers (/dashboard/customers)
```

## Local Database (vs course Postgres)

The official course (Chapter 6+) uses **Vercel + PostgreSQL**. This fork keeps those SQL paths for coursework, but adds a **local in-memory fallback** so you can learn without creating a Vercel app or Postgres database.

| Mode | When it runs | Persistence |
| --- | --- | --- |
| **Postgres** | `POSTGRES_URL` is set and queries succeed | Durable (hosted DB) |
| **Local DB** | No URL, or Postgres fails | In-memory only — resets when the Next.js server restarts |

Key files:

- `app/lib/placeholder-data.ts` — seed data (same as the course)
- `app/lib/local-db.ts` — mutable local store (create / update / delete)
- `app/lib/data.ts` — try SQL first, then fall back to local
- `app/lib/actions.ts` — Server Actions with the same Postgres-then-local pattern

Default demo login (from placeholder users): `user@nextmail.com` / `123456`

## Data Model

| Field | Type | Description |
| --- | --- | --- |
| `id` | `string` | Unique invoice / customer / user id |
| `customer_id` | `string` | Foreign key from invoice → customer |
| `name` | `string` | Customer or user display name |
| `email` | `string` | Login / contact email |
| `image_url` | `string` | Customer avatar path under `/public` |
| `amount` | `number` | Invoice amount in **cents** (UI often shows dollars) |
| `status` | `'pending' \| 'paid'` | Invoice payment status |
| `date` | `string` | Invoice date (`YYYY-MM-DD`) |
| `revenue` | `number` | Monthly revenue value for charts |
| `password` | `string` | User password (hashed for auth compares) |

## Project Structure

| Path | Purpose |
| --- | --- |
| `app/` | App Router pages, layouts, and route handlers |
| `app/dashboard/` | Protected dashboard routes (overview, invoices, customers) |
| `app/lib/data.ts` | Data fetching (Postgres + local fallback) |
| `app/lib/actions.ts` | Server Actions for mutations / auth helpers |
| `app/lib/local-db.ts` | In-memory local database |
| `app/lib/placeholder-data.ts` | Course seed data |
| `app/lib/definitions.ts` | Shared TypeScript types |
| `app/ui/` | Pre-styled UI components (cards, forms, tables) |
| `auth.ts` | NextAuth.js configuration |
| `public/` | Static assets (customer images, hero art) |

## How to Run

**Prerequisites:** Node.js 18+, pnpm (or npm/yarn)

1. Open this folder: `basic learning/nextjs-dashboard`
2. Install dependencies: `pnpm install`
3. Start the dev server: `pnpm dev`
4. Open [http://localhost:3000](http://localhost:3000)

Optional (course path): copy `.env.example` → `.env.local`, add a `POSTGRES_URL`, then seed via `/seed` as in Chapter 6.

Useful scripts: `pnpm build`, `pnpm start`, `pnpm lint`

## Git Ignore (local PC config)

`.gitignore` keeps **machine-specific / personal** files out of GitHub so each learner’s PC config does not pollute the repo.

| Category | Ignored examples | Why |
| --- | --- | --- |
| Dependencies / build | `node_modules/`, `.next/`, `.turbo/`, `out/`, `build/` | Regenerated locally; large & machine-dependent |
| Secrets | `.env`, `.env*.local` | Private DB / auth keys (keep `.env.example` tracked) |
| OS junk | `.DS_Store`, `Thumbs.db`, `Desktop.ini` | Windows / macOS desktop metadata |
| Editors / IDE | `.vscode/`, `.idea/`, `.cursor/` | Personal editor settings |
| Logs / caches | `*.log`, `debug-*.log`, `.eslintcache`, `*.tsbuildinfo` | Local debug output |
| Next agent file | `AGENTS.md` | Auto-rewritten by `next dev` per machine |
| Personal notes | `lefted-at.txt`, `*.local.md` | Private learning bookmarks |

**Stopped tracking on the branch (files stay on your PC, not on GitHub):**

- `AGENTS.md`
- `lefted-at.txt`

If those files ever get committed again by mistake, untrack them without deleting locally:

```bash
git rm --cached AGENTS.md lefted-at.txt
git add .gitignore
git commit -m "Stop tracking local PC config files"
```

## Edge Cases Handled

- **No Postgres / Vercel** — fetches and mutations fall back to `local-db` instead of crashing
- **Missing invoice id on edit** — `notFound()` + `not-found.tsx`
- **Route / render failures** — `error.tsx` recovery UI
- **Invalid form payloads** — Zod parse / validation on Server Actions
- **Auth without DB** — local users seeded (with hashed passwords) for credentials login
- **ESLint peer mismatch** — project pins ESLint 9 for compatibility with `eslint-config-next`

## Future Improvements

- Persist local data to a JSON file or SQLite so restarts keep mutations
- Docker Compose Postgres option for offline “real SQL” without Vercel
- Align `next-auth` / Next version pins for cleaner peer dependency installs
- Expand customer CRUD to match invoice mutation coverage

## Agent Assistance (Cursor)

Cursor agents helped on request during this learning path:

- **Local database** — implemented Postgres-first + local fallback so coursework SQL stays while learning without Vercel Postgres
- **Debugging** — dependency / lint issues (e.g. ESLint 10 vs 9, pnpm build approvals) and edit-page wiring fixes
- **Git** — occasional branch cleanup / orphaning; expanded `.gitignore` and untracked local PC files (`AGENTS.md`, `lefted-at.txt`) so they are not pushed to GitHub

Ask the agent when you want the same flexibility (local data, debug a failing step, or tidy git history) without dropping the official course code paths.

## Development Log

### [2026-08-10 00:20]

- **Done:** Expanded `.gitignore` for OS / IDE / env / cache / agent files; ran `git rm --cached` on `AGENTS.md` and `lefted-at.txt` so they remain local only; documented the ignore + untrack steps in this README.
- **In progress:** Working through App Router course chapters with local-db enabled for day-to-day practice.
- **Left:** Commit and push the `.gitignore` + untrack changes on `basic-learing-only` if not already pushed; optional real Postgres for Chapter 6 “as written”.

### [2026-08-09 18:00]

- **Done:** Added `app/lib/local-db.ts`; wired `data.ts` / `actions.ts` Postgres-then-local fallback; fixed edit invoice page params + fetch; repaired ESLint install (pin to v9, `unrs-resolver` build allow); expanded this README from Template.md while keeping the original starter blurb.
- **In progress:** Working through App Router course chapters with local-db enabled for day-to-day practice.
- **Left:** Optional real Postgres when ready for Chapter 6 “as written”; consider durable local storage; finish any remaining chapter polish (metadata / next steps).
