# Habit Tracker

A console-based habit tracking application built in Java that helps users build habits, track daily completions, and monitor streaks with persistent file storage.

## Features

- **Add Habit** — Create a new habit with a custom name
- **View Habits** — Display all habits with ID, name, and completion count
- **Mark Done Today** — Record today's completion with duplicate prevention
- **View Streak** — Calculate and display current consecutive-day streak
- **Delete Habit** — Remove a habit by ID
- **Save Data** — Automatically persists habits to file on every change
- **Startup Auto-Load** — Loads saved habits when the application starts
- **Input Validation** — Handles non-numeric menu choices and invalid IDs gracefully

## Menu

```
==== Habit Tracker ====
1. Add Habit
2. View Habits
3. Mark Done Today
4. View Streak
5. Delete Habit
6. Exit
Enter choice:
```

## Data Model

| Field           | Type               | Description                                    |
|-----------------|--------------------|------------------------------------------------|
| id              | int                | Unique identifier assigned when habit is added |
| name            | String             | Habit name (required)                          |
| completedDates  | ArrayList\<String\> | List of completion dates (YYYY-MM-DD format)   |

## File Storage Format

Habits are persisted in a pipe-delimited text file (`habits.txt`):

```
1|Read 30 minutes|2026-07-18,2026-07-17,2026-07-16
2|Exercise|2026-07-18
3|Meditate|
```

Each line represents one habit: `id|name|date1,date2,date3`. Dates are comma-separated within the third field. Empty date field means no completions yet.

## Project Structure

| File                          | Purpose                                                     |
|-------------------------------|-------------------------------------------------------------|
| `model/Habit.java`            | Defines the Habit data structure with completion tracking    |
| `service/HabitService.java`   | Business logic: add, mark done, streak calculation, delete  |
| `storage/HabitStorage.java`   | File I/O: save and load habits from `habits.txt`            |
| `ui/HabitUI.java`             | User interface: menu loop, input handling, operation routing |
| `Main.java`                   | Entry point that launches the habit tracker application     |

## How to Run

**Prerequisites:** Java 8 or higher

1. Open a terminal in the `HabitTracker` directory
2. Compile all source files:
   ```
   javac -d . Main.java model\Habit.java service\HabitService.java storage\HabitStorage.java ui\HabitUI.java
   ```
3. Run the application:
   ```
   java Main
   ```

## Edge Cases Handled

- **Non-numeric menu input** — Re-prompts until a valid integer is entered
- **Non-numeric habit ID** — Shows "Invalid ID!" and returns to menu
- **Habit not found** — Shows "Habit not found!" for mark/view/delete operations
- **Mark same habit twice (same day)** — Shows "Already marked done for today!"
- **Empty habit name** — Rejects empty input with error message
- **Empty habit list** — Shows "No habits yet. Add one first!" on view operations
- **File does not exist on startup** — Gracefully starts with empty habit list
- **Habit with no completions** — Streak shows 0, total completions shows 0
- **Pipe (`|`) in habit name** — Rejected (would break the save format)
- **Malformed lines in `habits.txt`** — Skipped with a warning; remaining habits still load
- **Broken current streak** — Streak is 0 if the latest completion is older than yesterday

## Future Improvements

- Calendar view for completion visualization
- Weekly analytics and completion rates
- Reminder system for daily nudges
- React dashboard for web-based tracking
- AI habit coach with personalized suggestions
- Categories and habit grouping
- Export data to CSV/JSON

---

## Development Log

### [2026-07-18] Package Restructuring & README

**Done:**
- Created `model/`, `service/`, `storage/`, `ui/` packages with respective Java files
- Added package declarations to all class files
- Created this `README.md` following the template structure
- No `BasicPlan.md` existed in the project; `Habit Tracker.md` served as the plan document

**In progress:**
- —

**Left:**
- —

### [2026-07-18] Edge Case Testing

**Done:**
- Ran automated edge-case tests (**10 passed** after fixes) covering add/mark/delete, ID continuity after load, storage, and streak rules
- Confirmed correct handling: double mark-same-day rejected; missing IDs handled; `nextId` restored after load
- **Bugs found:**
  - `addHabit()` called an extra `scan.nextLine()`, skipping the user's first name input
  - Pipe (`|`) in a habit name corrupted load (name truncated at delimiter)
  - Malformed `habits.txt` lines threw `NumberFormatException` and aborted the rest of the file
  - “Current streak” counted consecutive history even when the latest day was older than yesterday
- **Fixes applied:**
  - Removed the extra `nextLine()` in `HabitUI.addHabit()`
  - Reject `|` in habit names (UI + service)
  - Skip malformed lines during load instead of throwing
  - Streak returns `0` unless the most recent completion is today or yesterday
- Verified after fix: pipe rejected; malformed lines skipped; valid habits still load

**In progress:**
- —

**Left:**
- —
