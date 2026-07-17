# Library Management System

A console-based Java application for tracking books, borrowers, and returns. Built as a structured CRUD exercise with file persistence.


## Features

- **Add Book** – Register a new book with title and author
- **View Books** – Display all books in the library
- **Search Book** – Find books by title (case-insensitive)
- **Borrow Book** – Lend a book to a borrower (marks as unavailable, creates a borrow record)
- **Return Book** – Process a book return (marks as available, sets return date)
- **Delete Book** – Remove a book from the library
- **Automatic ID Generation** – Books and records get sequential IDs
- **Persistent Storage** – Data auto-saves on exit via atomic temporary-file writes
- **Graceful Missing-File Handling** – Starts cleanly with empty data if no save files exist


## Menu

```
==== Library System ====
1. Add Book
2. View Books
3. Search Book
4. Borrow Book
5. Return Book
6. Delete Book
7. Exit
```

---

## Data Model

### Book

| Field | Type | Description |
|-------|------|-------------|
| `id` | `int` | Unique book identifier |
| `title` | `String` | Book title |
| `author` | `String` | Author name |
| `available` | `boolean` | Whether the book is available to borrow |

### BorrowRecord

| Field | Type | Description |
|-------|------|-------------|
| `id` | `int` | Unique record identifier |
| `bookId` | `int` | ID of the borrowed book |
| `borrowerName` | `String` | Name of the borrower |
| `borrowDate` | `String` | Date borrowed (`YYYY-MM-DD`) |
| `returnDate` | `String` | Date returned (`null` if not yet returned) |

---

## File Storage Format

Files are comma-delimited (`,`) and stored as plain text.

**books.txt** — one book per line:
```
1,Harry Potter,J.K. Rowling,true
```

**records.txt** — one record per line:
```
1,1,John Doe,2026-07-07,null
```

The save strategy uses atomic temporary-file writes: data is written to a `_temp.txt` file first, then atomically renamed to the target file. Missing files on load are silently handled (empty library).

---

## Project Structure

| File | Package | Purpose |
|------|---------|---------|
| `main.java` | *(default)* | Entry point; starts `LibraryUI` |
| `model/Book.java` | `model` | Book data model with getters, setters, `toString()` |
| `model/BorrowRecord.java` | `model` | Borrow record data model with getters, setters, `toString()` |
| `service/LibraryService.java` | `service` | Business logic: add, view, search, borrow, return, delete |
| `storage/FileStorage.java` | `storage` | File I/O: save/load books and records |
| `ui/LibraryUI.java` | `ui` | Console interface: menu loop and user interaction |

### Methods Beyond the Basic Plan

The following methods were implemented beyond the original plan:

- **Book.java**: `getId()`, `setId()`, `getTitle()`, `setTitle()`, `getAuthor()`, `setAuthor()`, `isAvailable()`, `setAvailable()`, `toString()`
- **BorrowRecord.java**: All getters/setters, `toString()`
- **LibraryService.java**: `getBooks()`, `getRecords()`, `setBooks()`, `setRecords()`, `setNextBookId()`, `setNextRecordId()`, `searchBookById()` (private), `generateBookId()` (private), `generateRecordId()` (private)
- **FileStorage.java**: `bookToString()`, `recordToString()`, `stringToBook()`, `stringToRecord()` (all private serialization helpers)
- **LibraryUI.java**: `start()`, `showMenu()`, `handleAddBook()`, `handleViewBooks()`, `handleSearchBook()`, `handleBorrowBook()`, `handleReturnBook()`, `handleDeleteBook()`, `exitApplication()`


## How to Run

1. Ensure **Java 8 or higher** is installed
2. Navigate to the project directory
3. Compile:
   ```
   javac -d . main.java
   ```
4. Run:
   ```
   java main
   ```

## Edge Cases Handled

| Scenario | Behavior |
|----------|----------|
| No data files exist | Silently returns empty lists; starts fresh |
| Borrow an unavailable book | Returns error: "Book not found or already borrowed" |
| Return an available book | Returns error: "Book not found or not currently borrowed" |
| Delete a non-existent book | Returns error: "Book not found" |
| Empty book list on View/Search | Prints "No books found." |
| Invalid menu choice | Prints "Invalid choice. Please try again." |
| `nextInt()` Scanner newline | `scanner.nextLine()` called after `nextInt()` to consume trailing newline |
| Search with mixed case | `.toLowerCase()` on both search term and titles for case-insensitive match |


## Future Improvements

- Member accounts with login
- Late return fines
- Book categories and genres
- Admin login with elevated privileges
- Database storage (MySQL / PostgreSQL)
- Spring Boot REST API
- GUI frontend (JavaFX / web)


## Development Log

### [2026-07-07 23:46]

- **Done:**
  - Fixed `Book.java` constructor to use the `available` parameter (was hardcoded `true`)
  - Renamed `getAvilable()` → `isAvailable()` across all files
  - Fixed `BorrowRecord.toString()` with proper `\n` separators
  - Added `file.exists()` guard in `loadBooks()` / `loadRecords()` for silent missing-file handling
  - Fully implemented `LibraryUI` with menu loop, all 7 handlers, data loading with ID tracking
  - Renamed `Main.java` → `main.java`; added `import ui.LibraryUI`
  - Organized files into packages: `model/`, `service/`, `storage/`, `ui/`
  - Added `package` declarations and cross-package imports to all moved files
- **In progress:** Wrapping up project documentation and structure
- **Left:** N/A (MVP complete)
