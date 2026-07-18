# Expense Tracker

A console-based Java application for tracking student spending. Built as a structured CRUD exercise with category filtering, totals, input validation, and file persistence.


## Features

- **Add Expense** – Register a new expense with title, category, amount, and date
- **View Expenses** – Display all tracked expenses
- **View Total** – Calculate and show total spending across all expenses
- **Filter By Category** – Show only expenses matching a category (case-insensitive)
- **Delete Expense** – Remove an expense by ID
- **Automatic ID Generation** – Expenses get sequential IDs that continue after reload
- **Category Validation** – Only accepts Food, Transport, Rent, Shopping, Entertainment, Other
- **Input Validation** – Rejects blank titles, blank dates, non-numeric amounts, and amounts ≤ 0
- **Persistent Storage** – Data auto-saves on exit via atomic temporary-file writes
- **Graceful Missing/Corrupt File Handling** – Starts cleanly if no save file exists; skips bad lines on load


## Menu

```
==== Expense Tracker ====
1. Add Expense
2. View Expenses
3. View Total
4. Filter By Category
5. Delete Expense
6. Exit
```

---

## Data Model

### Expense

| Field | Type | Description |
|-------|------|-------------|
| `id` | `int` | Unique expense identifier |
| `title` | `String` | Short description of the expense |
| `category` | `String` | One of the allowed categories |
| `amount` | `double` | Spending amount (must be > 0) |
| `date` | `String` | Date of the expense |

**Allowed categories:** Food, Transport, Rent, Shopping, Entertainment, Other

### ExpenseService

| Field | Type | Description |
|-------|------|-------------|
| `expenses` | `List<Expense>` | In-memory list of all expenses |
| `nextID` | `int` | Auto-incrementing ID counter (starts at 1) |

| Method | Access | Return | Parameters |
|--------|--------|--------|------------|
| `ExpenseService` | public | constructor | none |
| `getExpense` | public | `List<Expense>` | none |
| `setExpense` | public | `void` | `List<Expense> expenses` |
| `setNextID` | public | `void` | `int nextID` |
| `generateid` | public | `int` | none |
| `addExpense` | public | `void` | `String title, String category, double amount, String date` |
| `deleteExpense` | public | `boolean` | `int id` |
| `viewAllExpenses` | public | `List<Expense>` | none |
| `calculateTotal` | public | `double` | none |
| `filterCategory` | public | `List<Expense>` | `String category` |

### FileStorage

| Method | Access | Return | Parameters |
|--------|--------|--------|------------|
| `save` | public | `boolean` | `List<Expense> expense` |
| `load` | public | `List<Expense>` | none |
| `expenseToString` | private | `String` | `Expense a` |
| `stringToExpense` | private | `Expense` | `String line` |

### ExpenseUI

| Method | Access | Return | Parameters |
|--------|--------|--------|------------|
| `start` | public static | `void` | none |
| `menu` | private static | `void` | none |
| `choice` | private static | `void` | `int choice` |
| `ExpenseAdd` | private static | `void` | none |
| `ExpenseView` | private static | `void` | none |
| `ExpenseTotal` | private static | `void` | none |
| `SearchExpense` | private static | `void` | none |
| `ExpenseDelete` | private static | `void` | none |
| `exit` | private static | `void` | none |
| `matchCategory` | private static | `String` | `String input` |

`start()` loads saved data, restores the next ID, then loops the menu. `choice()` routes to the correct handler. `exit()` saves data and terminates.

---

## File Storage Format

Pipe-delimited (`|`), one expense per line in `expense.txt`:

```
1|Lunch|Food|10.0|2026-07-18
2|Bus|Transport|5.0|2026-07-18
```

The save strategy uses atomic temporary-file writes: data is written to `expense.txt_temp.txt` first, then atomically renamed to `expense.txt`. Missing files on load return an empty list. Empty or corrupted lines are skipped.

---

## Project Structure

| File | Package | Purpose |
|------|---------|---------|
| `Main.java` | *(default)* | Entry point; starts `ExpenseUI` |
| `model/Expense.java` | `model` | Expense data model with getters, setters, `toString()` |
| `service/ExpenseService.java` | `service` | Business logic: add, view, total, filter, delete, ID generation |
| `storage/FileStorage.java` | `storage` | File I/O: save/load expenses with pipe-delimited format |
| `ui/ExpenseUI.java` | `ui` | Console interface: menu loop, validation, user interaction |

### Methods Beyond the Basic Plan

The following were implemented beyond the original plan fields/files:

- **Expense.java**: All getters/setters, `toString()`
- **ExpenseService.java**: `getExpense()`, `setExpense()`, `setNextID()`, `generateid()`
- **FileStorage.java**: `expenseToString()`, `stringToExpense()` (private serialization helpers); atomic temp-file save
- **ExpenseUI.java**: Full menu UI with `matchCategory()`, blank-title/date checks, amount validation, category whitelist, corrupt-input guards for menu/ID/amount
- **Main.java**: Entry point launching `ExpenseUI` (plan listed Main but not the UI layer)

---

## How to Run

1. Ensure **Java 8 or higher** is installed
2. Navigate to the project directory
3. Compile:
   ```
   javac -d . model\Expense.java service\ExpenseService.java storage\FileStorage.java ui\ExpenseUI.java Main.java
   ```
4. Run:
   ```
   java Main
   ```

---

## Edge Cases Handled

| Scenario | Behavior |
|----------|----------|
| No `expense.txt` on startup | Starts with an empty expense list |
| Blank title | Rejected: "Title cannot be blank." |
| Blank date | Rejected: "Date cannot be blank." |
| Amount ≤ 0 | Rejected: "Amount must be greater than zero." |
| Non-numeric amount | Rejected: "Amount must be a number." |
| Category not in allowed list | Rejected with list of valid categories |
| Delete non-existent ID | "Error: Expense not found" |
| Empty list on View/Filter | Informative empty-state message |
| Invalid menu choice / non-int input | "Invalid choice. Please try again" |
| `nextDouble()` / `nextInt()` leftover newline | Consumed with `scan.nextLine()` before reading the next string |
| Corrupted or empty lines in file | Skipped on load; valid expenses still load |
| Filter with mixed case | Case-insensitive category match |

---

## Future Improvements

- Monthly budget limits
- Charts / spending breakdown
- CSV export
- JavaFX dashboard
- React frontend
- Banking API integration


## Development Log

### [2026-07-18 14:18]

- **Done:**
  - Created `README.md` from `BasicPlanExpense.md` content using the project README template style `Template.md`
  - Documented all classes, methods, file format, edge cases, and methods beyond the basic plan
  - Confirmed package layout: `model/`, `service/`, `storage/`, `ui/` with package declarations; `Main.java` remains in the project root
  - Renamed `storage/fileStorage.java` → `storage/FileStorage.java` and updated `ExpenseUI` imports/field names
  - Aligned menu labels with the original plan wording
  - Deleted `BasicPlanExpense.md` (replaced by this README)
- **In progress:** None
- **Left:** None — MVP documentation and structure complete
