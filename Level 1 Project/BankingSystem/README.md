# Banking System

A console-based banking simulation built in Java that teaches object-oriented programming, input validation, and file persistence. Users can create accounts, deposit and withdraw money, check balances, and view transaction history.

## Features

- **Create Account** — Generate a new bank account with a unique account number
- **Deposit Money** — Add funds to an existing account with validation
- **Withdraw Money** — Remove funds with insufficient-balance protection
- **Check Balance** — View current balance of any account
- **View Transaction History** — Display a timestamped log of all deposits and withdrawals
- **Auto-Save & Load** — Accounts and transactions persist to disk automatically on exit and load on startup
- **Input Validation** — Rejects negative/zero deposits and withdrawals, and prevents over-withdrawal

## Menu

```
==== Banking System ====
1. Create Account
2. Deposit
3. Withdraw
4. Check Balance
5. View Transactions
6. Exit
```

## Data Model

### UI Class: BankSystem

| Field | Type | Description |
|-------|------|-------------|
| `scan` | `Scanner` | Reads user keyboard input |
| `bankService` | `BankService` | Backend service for all account operations |

| Method | Access | Return | Parameters |
|--------|--------|--------|------------|
| `start` | public | `void` | none |
| `displayMenu` | private | `void` | none |
| `handleChoice` | private | `void` | `int choice` |
| `createAccount` | private | `void` | none |
| `deposit` | private | `void` | none |
| `withdrawal` | private | `void` | none |
| `checkBalance` | private | `void` | none |
| `viewTransaction` | private | `void` | none |
| `exit` | private | `void` | none |

Each menu action is extracted into its own private method. `start()` loops the menu, `handleChoice()` routes to the correct method, and `exit()` saves data and terminates.

### Transaction

| Field | Type | Description |
|-------|------|-------------|
| `id` | `int` | Unique transaction identifier |
| `type` | `Transaction.Type` | Enum: `Deposit` or `Withdrawal` |
| `amount` | `double` | Transaction amount |
| `date` | `String` | ISO timestamp of the transaction |

**Inner Enum:** `Transaction.Type { Deposit, Withdrawal }`

| Method | Access | Return | Parameters |
|--------|--------|--------|------------|
| `Transaction` | public | constructor | `int id, Type type, double amount, String date` |
| `getId` | public | `int` | none |
| `getType` | public | `Type` | none |
| `getAmount` | public | `double` | none |
| `getDate` | public | `String` | none |

### BankAccount

| Field | Type | Description |
|-------|------|-------------|
| `accountNumber` | `int` | Unique account identifier |
| `ownerName` | `String` | Name of the account holder |
| `balance` | `double` | Current balance (starts at 0.0) |
| `transactions` | `ArrayList<Transaction>` | List of all transactions |
| `transactionCounter` | `int` | Auto-incrementing ID counter (starts at 1) |

| Method | Access | Return | Parameters |
|--------|--------|--------|------------|
| `BankAccount` | public | constructor | `int accountNumber, String ownerName` |
| `deposit` | public | `boolean` | `double amount` |
| `withdraw` | public | `boolean` | `double amount` |
| `getBalance` | public | `double` | none |
| `getAccountNumber` | public | `int` | none |
| `getOwnerName` | public | `String` | none |
| `getTransactionHistory` | public | `ArrayList<Transaction>` | none |
| `addTransaction` | private | `void` | `Type type, double amount` |
| `generateTransactionId` | private | `int` | none |
| `restoreBalance` | public | `void` | `double balance` |
| `restoreTransaction` | public | `void` | `Transaction t` |

### BankService

| Field | Type | Description |
|-------|------|-------------|
| `accounts` | `ArrayList<BankAccount>` | All bank accounts in the system |
| `accountNumberCounter` | `int` | Auto-incrementing account number generator (starts at 1001) |

| Method | Access | Return | Parameters |
|--------|--------|--------|------------|
| `BankService` | public | constructor | none |
| `createAccount` | public | `int` | `String ownerName` |
| `findAccount` | private | `BankAccount` | `int accountNumber` |
| `depositToAccount` | public | `boolean` | `int accountNumber, double amount` |
| `withdrawFromAccount` | public | `boolean` | `int accountNumber, double amount` |
| `getAccountBalance` | public | `double` | `int accountNumber` |
| `getAccountTransactions` | public | `ArrayList<Transaction>` | `int accountNumber` |
| `generateAccountNumber` | private | `int` | none |
| `saveAccounts` | public | `void` | none |
| `loadAccounts` | public | `void` | none |

## File Storage Format

Data is persisted to `accounts.txt` in the working directory using pipe-delimited (`|`) lines:

```
1001|Alice|250.0
1|Deposit|500.0|2026-07-08T12:00:00
2|Withdrawal|250.0|2026-07-08T12:30:00
---
1002|Bob|100.0
3|Deposit|100.0|2026-07-08T13:00:00
---
```

Each account starts with a header line (`accountNumber|ownerName|balance`), followed by its transaction lines (`id|type|amount|date`), and ends with `---` as a separator. The `type` field stores the enum constant name (`Deposit` or `Withdrawal`) and is deserialized via `Transaction.Type.valueOf()`.

## Project Structure

```
BankingSystem/
├── model/
│   ├── Transaction.java       # Data class with inner Type enum (Deposit, Withdrawal)
│   └── BankAccount.java       # Account blueprint with balance and transaction history
├── service/
│   └── BankService.java       # Business logic layer managing multiple accounts + file I/O
├── ui/
│   └── BankSystem.java        # Console-based UI — each menu action extracted into its own method
├── Main.java                  # Entry point — creates BankSystem and calls start()
├── accounts.txt               # Auto-generated persistence file (not tracked in git)
└── README.md
```

## How to Run

**Prerequisites:** Java 8 or higher

```bash
# Navigate to the project directory
cd BankingSystem

# Compile all source files
javac model\Transaction.java model\BankAccount.java service\BankService.java ui\BankSystem.java Main.java

# Run the application
java Main
```

## Edge Cases Handled

- **Negative/zero deposit amount** — Rejected with `false` return; balance unchanged
- **Negative/zero withdrawal amount** — Rejected with `false` return; balance unchanged
- **Over-withdrawal** — Withdrawal larger than current balance returns `false`; no transaction recorded
- **Unknown account number** — `getAccountBalance` returns `-1.0`; `getAccountTransactions` returns `null`; deposit/withdraw methods return `false`
- **Empty transaction history** — Displays "No transactions found." to the user
- **File not found on startup** — `loadAccounts` silently returns; system starts fresh
- **Corrupted save file** — Parsing errors are caught and printed; partially loaded data may be recovered. Invalid transaction types are skipped with a warning.

## Future Improvements

- Login PIN authentication per account
- Transfer money between accounts
- Interest calculation over time
- Admin panel for account management
- Database-backed persistence (replacing text file)
- Spring Boot REST API for web access
- GUI interface (JavaFX or Swing)

## Development Log

### [2026-07-08 01:00]

- **Done:**
  - Created `model/`, `service/`, `ui/` folders
  - Moved `Transaction.java` and `BankAccount.java` into `model/` with `package model;`
  - Moved `BankService.java` into `service/` with `package service;`
  - Renamed `Main.java` to `main.java` and moved into `ui/` with `package ui;`
  - Changed `restoreBalance`/`restoreTransaction` from package-private to `public` for cross-package access
  - Deleted old root-level `.java` files and `BasicPlan.md`
  - Recompiled successfully with new package structure
  - Created `README.md` with full project documentation per `Template.md`

- **In progress:** None

- **Left:** None — project is complete

### [2026-07-18] Edge Case Testing

- **Done:**
  - Ran automated edge-case tests against `BankAccount` and `BankService` (**25 passed**)
  - Confirmed correct handling: zero/negative deposit & withdraw rejected; overdraft blocked; missing account returns `-1.0` / `null` / `false`
  - Confirmed `saveAccounts()` + reload restores balances correctly when save is called
  - **Bugs found:**
    - Missing entry point (`Main.java` / `main.java`) — app could not start as documented
    - Menu option 6 (`Exit`) broke the loop without calling `exit()` / `saveAccounts()` — **accounts never persisted**
  - **Fixes applied:**
    - Added `Main.java` entry point (`new BankSystem().start()`)
    - Exit path now calls `exit()` so accounts are saved before shutdown
  - Recompiled successfully after fixes

- **In progress:** —

- **Left:** Empty owner name still allowed; non-numeric Scanner input can still crash the UI (optional hardening)
