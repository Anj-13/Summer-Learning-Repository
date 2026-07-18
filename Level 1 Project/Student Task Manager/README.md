# Student Task Manager

A console-based task management application designed for students to track assignments, deadlines, and revision tasks.

## Features

- **Add Task** — Create tasks with title, description, deadline (YYYY-MM-DD), and priority (HIGH, MEDIUM, LOW)
- **View All Tasks** — Display every task with its ID, title, description, deadline, priority, and completion status
- **View Incomplete Tasks** — Filter and show only unfinished tasks
- **View Complete Tasks** — Filter and show only completed tasks
- **Mark Task Complete** — Mark a task as done (with already-complete detection)
- **Delete Task** — Remove a task by ID (shows task details and asks for confirmation)
- **Load from File** — Load tasks from a saved file (replaces current list)
- **Clear All Tasks** — Remove all tasks (with confirmation prompt)
- **Exit (Auto-Save)** — Automatically saves all tasks to file before exiting
- **Startup Auto-Load** — Automatically loads saved tasks when the application starts
- **Input Validation** — Handles invalid numbers, empty inputs, and malformed data gracefully

## Menu

```
==== Student Task Manager ====
1. Add Task
2. View All Tasks
3. View Incomplete Tasks
4. View Complete Tasks
5. Mark Task Complete
6. Delete Task
7. Load from File
8. Clear All Tasks
9. Exit (Auto-Save)
========================
Choose an option:
```

## Data Model

| Field       | Type           | Description                                  |
|-------------|----------------|----------------------------------------------|
| id          | int            | Unique identifier assigned when task is added|
| title       | String         | Short name for the task (required)           |
| description | String         | Additional details (optional)                |
| deadline    | LocalDate      | Due date (YYYY-MM-DD)                        |
| priority    | PriorityOption | HIGH, MEDIUM, or LOW (enum)                  |
| completed   | boolean        | true if finished, false otherwise            |

## File Storage Format

Tasks are persisted in a pipe-delimited text file (`tasks.txt`):

```
1|Math Homework|Finish algebra questions|2026-07-10|HIGH|false
2|Read Chapter 3|Complete comprehension questions|2026-07-12|MEDIUM|false
3|Submit Essay|Final draft with citations|2026-07-15|HIGH|true
```

The file is written atomically using a temporary file and `Files.move()` to prevent data corruption.

## Project Structure

| File                          | Purpose                                          |
|-------------------------------|--------------------------------------------------|
| `model/Task.java`             | Defines the Task data structure and PriorityOption enum |
| `service/TaskManager.java`    | Manages task operations (add, delete, complete, filter) |
| `storage/FileStorage.java`    | Handles reading and writing tasks to file         |
| `Main.java`                   | Contains the main loop, menu, and user interface  |

## How to Run

1. Ensure you have **Java 8 or higher** installed
2. Open a terminal in the project directory
3. Compile: `javac -d . model\Task.java service\TaskManager.java storage\FileStorage.java Main.java`
4. Run: `java Main`

## Edge Cases Handled

- **Letters instead of numbers** — loops until a valid integer is entered
- **Empty input** — prompts again until non-empty text is provided
- **Delete non-existent task** — shows "not found" message
- **Mark already-complete task** — shows "already completed" message
- **File does not exist on startup** — graceful message, starts with empty list
- **Empty task list** — appropriate messages for view/delete operations
- **Destructive operations** — confirmation prompts for delete, clear, and exit
- **ID continuity after load** — `nextId` is synced to `max(id) + 1` so new tasks never collide with restored IDs

## Future Improvements

- Due date sorting and priority sorting
- Search functionality
- Categories and labels
- Reminder notifications
- GUI with JavaFX
- Database persistence (JDBC)
- Web API (Spring Boot)

---

## Development Log

### [2026-07-06 10:00] 

**Done:**
- Fixed `PriorityOption` enum import issue in `TaskManager.java` — nested enums in the default package cannot be imported, switched to fully qualified `Task.PriorityOption`
- Fixed `FileStorage.java`: `ArrayList.add()` was passing 6 args (now creates Task and calls `setCompleted()`); added missing `java.nio.file.Files` import; added newlines in save output; removed unused `File f` variable
- Fixed `Main.java`: `Scanner(null)` → `Scanner(System.in)`; static `FileStorage.loadTasks()` → instance `FS.loadTasks()`; wired up startup load flow

**In progress:**
- Establishing baseline project structure and compilation

**Left:**
- Align all files with the detailed spec (method signatures, return types, naming)

---

### [2026-07-06 11:30] 

**Done:**
- `Task.java`: Removed `id` from constructor (TaskManager assigns it); `getDeadline()` returns `LocalDate`; `getPriority()` returns `String`; trimmed setters to spec; `toString()` is now user-friendly
- `TaskManager.java`: `getAllTasks()`, `getIncompleteTasks()`, `getCompleteTasks()` return `ArrayList<Task>` instead of printing; `markTasksByID()` renamed to `markTaskComplete()` returning `boolean`; `deleteTask()` returns `boolean`
- `FileStorage.java`: Switched to `BufferedWriter`/`BufferedReader`; writes fields individually (not relying on `toString()`); `fileExists()` with no parameters
- `Main.java`: Prints returned lists; uses `markTaskComplete()` boolean; shows task details before delete; `loadFromFile()` clears then adds
- `Basic Plan.md`: Updated data model to match code (`LocalDate`, enum `PriorityOption`)

**In progress:**
- Verifying compilation across all files

**Left:**
- Polish UI text to match plan spec
- Add already-complete detection
- Replace Yes/No with true/false in file format
- Implement auto-save on exit

---

### [2026-07-06 13:00]

**Done:**
- Changed completed field in file storage from `"Yes"`/`"No"` to `"true"`/`"false"` to match plan spec
- Added `isCompleted()` check in `markTaskComplete()` with distinct "already completed" message
- Changed menu title to `==== Student Task Manager ====` and prompt to `Choose an option:`
- Replaced "Save and Exit" + "Exit Without Saving" with single "Exit (Auto-Save)" as last menu option
- Updated `Basic Plan.md` menu to match
- Created this `README.md` with full documentation and development log

**In progress:**
- Project is functionally complete and compiles cleanly

**Left:**
- (Optional) .jar packaging

---

### [2026-07-07 15:01]

**Done:**
- Restructured project into `model/`, `service/`, `storage/` packages: moved `Task.java` → `model/Task.java` with `package model;`, `TaskManager.java` → `service/TaskManager.java` with `package service;`, `FileStorage.java` → `storage/FileStorage.java` with `package storage;`
- Renamed `Main.java` → `main.java`, updated class name and added imports for packaged classes
- Removed `Basic Plan.md`
- Updated `README.md` project structure, compile/run commands, and this log entry

**In progress:**
- —

**Left:**
- —

---

### [2026-07-18] Edge Case Testing

**Done:**
- Ran automated edge-case tests (**14 passed**) covering CRUD, filters, and file persistence
- Confirmed correct handling: mark/delete missing IDs; complete/incomplete filters; clear continues ID sequence
- **Bugs found:**
  - After startup load or menu "Load from File", `nextId` stayed at `0` → new tasks collided with saved IDs; `findTaskById` returned the first match only
  - Pipe (`|`) characters in title/description break the pipe-delimited save format
- **Fixes applied:**
  - Added `TaskManager.syncNextIdFromTasks()` and `setNextId(int)`
  - Startup load and `loadFromFile()` now call `syncNextIdFromTasks()`
  - `clearAllTasks()` resets `nextId` to `0`
  - Renamed entry class to `Main` so it matches `Main.java` and compiles cleanly
- Verified after fix: new task after load gets the next free ID (no collision)

**In progress:**
- —

**Left:**
- Delimiter characters in title/description still unsupported (optional escaping)
