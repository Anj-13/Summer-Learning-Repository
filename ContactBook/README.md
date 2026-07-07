# Contact Book

A console-based Java application for storing, searching, and managing contacts, built as a learning project.

## Features

- **Add Contact** — Create a new contact with name, phone, and email
- **View Contacts** — List all saved contacts with full details
- **Search Contact** — Find a contact by **ID** or by **name** (substring/partial match)
- **Edit Contact** — Update any field of an existing contact (keeps current values by default)
- **Delete Contact** — Remove a contact with a confirmation prompt
- **Auto-Save & Auto-Load** — Contacts persist to a pipe-delimited file on exit and load on startup
- **Email Validation Warning** — Detects missing `@` or `.` in email input and warns the user

## Menu

```
==== Contact Book ====
1. Add Contact
2. View Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Exit
```

Press `Enter` to keep the existing value when editing a contact.

## Data Model

| Field  | Type     | Description          |
|--------|----------|----------------------|
| `id`   | `int`    | Unique contact ID    |
| `name` | `String` | Contact's full name  |
| `phone`| `String` | Phone number         |
| `email`| `String` | Email address        |

### File Storage Format

Pipe-delimited (`|`), one contact per line:

```
1|Jane Smith|555-0000|jane@test.com
2|John Doe|123-456-7890|john@example.com
```

The app writes to a temporary file first (`contacts.txt_temp.txt`), then atomically renames it to `contacts.txt` to prevent data corruption.

## Project Structure

| File | Purpose |
|------|---------|
| `model/Contact.java` | Contact data class with fields, getters, setters, and `toString()` |
| `service/ContactService.java` | Business logic — CRUD operations, search, ID generation |
| `storage/FileStorage.java` | File I/O — save/load contacts with atomic file rewrite |
| `ui/ContactUI.java` | Console interface — menu, input handling, user-facing logic |
| `main.java` | Entry point — launches the app |

## How to Run

1. **Prerequisites:** Java 8 or higher
2. **Compile:**
   ```
   javac -d . model\Contact.java service\ContactService.java storage\FileStorage.java ui\ContactUI.java main.java
   ```
3. **Run:**
   ```
   java main
   ```

## Edge Cases Handled

| Scenario | Response |
|----------|----------|
| Empty input for required field | Prompt repeats until non-empty input is provided |
| Invalid number for menu/ID | Error message, prompt repeats |
| Email without `@` or `.` | Warning printed, contact still saved |
| Searching for non-existent ID | "No contact found" message |
| Searching for non-existent name | "No contacts found" message |
| Editing a non-existent contact | Error message, returns to menu |
| Deleting a non-existent contact | Error message, returns to menu |
| Delete cancellation | Contact is preserved |
| File not found on startup | "Save file not found" message, empty contact list |
| Empty contact list | "No contacts in the book" message |

## Future Improvements

- Contact groups / categories
- Birthday reminders
- CSV import/export
- JavaFX graphical user interface
- Spring Boot contact API
- Integration with CRM systems and messaging apps

## Development Log

### [2026-07-07 12:48]

- Initial project scaffolding with package structure (model, service, storage, ui)
- Implemented `Contact.java`, `ContactService.java`, `FileStorage.java`, `ContactUI.java`, `main.java`

### [2026-07-07 14:00]

- Fixed bugs in `ContactUI.java`: renamed undeclared variable `FM` to `fs`, removed `static` from `getStringInput()`, removed extra closing brace in `searchContactUI()`
- Fixed `main.java` — corrected method signature to `public static void main`
- Smoke tested: add, view, save, and exit all confirmed working
