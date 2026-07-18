# Student Grade Tracker

A console-based grade tracking application built in Java that helps students manage modules, record assignment grades with weights, calculate weighted averages, and persist data with binary file storage.

## Features

- **Add Module** — Create a new module with a custom name
- **Add Grade** — Record an assignment grade with score and weight for a specific module
- **View Module Average** — Calculate and display the weighted average for a module along with highest and lowest grades
- **View All Grades** — Display all grades across all modules with individual weighted averages
- **Delete Grade** — Remove a grade by ID from a selected module
- **Save Data** — Automatically persists all modules and grades to binary file on exit
- **Startup Auto-Load** — Loads saved data when the application starts
- **Input Validation** — Handles non-numeric menu choices, invalid scores, and empty inputs gracefully

## Menu

```
==== Grade Tracker ====
1. Add Module
2. Add Grade
3. View Module Average
4. View All Grades
5. Delete Grade
6. Exit
Enter your choice:
```

## Data Model

### Module

| Field  | Type            | Description                                  |
|--------|-----------------|----------------------------------------------|
| id     | int             | Unique identifier assigned when module is added |
| name   | String          | Module name (required)                       |
| grades | List\<Grade\>   | List of grades belonging to this module      |

### Grade

| Field          | Type   | Description                                      |
|----------------|--------|--------------------------------------------------|
| id             | int    | Unique identifier assigned when grade is added   |
| assessmentName | String | Name of the assessment (required)                |
| score          | double | Score value between 0 and 100                    |
| weight         | double | Weight percentage between 0 and 100              |

## File Storage Format

Modules and grades are persisted using Java binary serialization (`ObjectOutputStream`) to `grade_data.dat`:

```
Binary serialized List<Module>
Each Module contains: id, name, List<Grade>
Each Grade contains: id, assessmentName, score, weight
```

The entire module list (including nested grades) is serialized as a single object. On load, the list is deserialized and next-ID counters are recalculated to prevent ID collisions.

## Project Structure

| File                          | Purpose                                                           |
|-------------------------------|-------------------------------------------------------------------|
| `model/Grade.java`            | Defines the Grade data structure with score and weight fields     |
| `model/Module.java`           | Defines the Module data structure containing a list of grades     |
| `service/GradeService.java`   | Business logic: add/delete modules and grades, weighted average, highest/lowest |
| `storage/DataStorage.java`    | Binary file I/O: save and load data from `grade_data.dat`        |
| `ui/GradeTrackerUI.java`      | User interface: menu loop, input handling, operation routing      |
| `Main.java`                   | Entry point that launches the grade tracker application           |

## How to Run

**Prerequisites:** Java 8 or higher

1. Open a terminal in the `StudentGrade` directory
2. Compile all source files:
   ```
   javac -d . model\Grade.java model\Module.java service\GradeService.java storage\DataStorage.java ui\GradeTrackerUI.java Main.java
   ```
3. Run the application:
   ```
   java Main
   ```

## Edge Cases Handled

- **Non-numeric menu input** — Re-prompts until a valid integer is entered
- **Non-numeric score/weight input** — Re-prompts until a valid double is entered
- **Score below 0 or above 100** — Rejected in UI and service (`IllegalArgumentException`)
- **Weight ≤ 0 or above 100** — Rejected in UI and service (`IllegalArgumentException`)
- **Module not found** — Shows "Module not found." for grade operations
- **Grade not found** — Shows "Grade not found." when deleting
- **Empty module name** — Rejected in UI and service
- **Empty assessment name** — Rejects empty input with error message
- **No modules available** — Shows prompt to add a module first
- **No grades in module** — Shows "No grades recorded." or "No grades to delete."
- **File does not exist on startup** — Gracefully starts with empty module list
- **Module with no grades** — Average returns 0.0, no highest/lowest displayed
- **ID continuity after load** — Next module/grade IDs recalculated from saved data

## Future Improvements

- Grade prediction based on remaining assessments
- What-if calculator for scenario planning
- Charts and visual grade distribution
- React dashboard for web-based tracking
- AI study recommendations
- Student dashboard with cross-module analytics
- Learning analytics and progress tracking
- Export data to CSV/JSON

---

## Development Log

### [2026-07-18] Package Restructuring & README

**Done:**
- Organized sources into `model/`, `service/`, `storage/`, `ui/` packages
- Created `Main.java` entry point at project root
- Created this `README.md` following the template structure

**In progress:**
- —

**Left:**
- —

### [2026-07-18] Edge Case Testing

**Done:**
- Project initially **failed to compile**: `GradeService` imported `studentgrade.model.*` while classes lived in `package model` (also collided with `java.lang.Module`)
- Ran automated edge-case tests (**17 passed** after fixes) covering score/weight bounds, weighted average, persistence, and ID continuity
- Confirmed correct handling: invalid scores/weights throw; missing module/grade handled; save/load round-trip preserves averages; `nextId` restored after load
- **Bugs found:**
  - Wrong package imports in `GradeService` → entire app would not compile
  - `addGrade` returning `null` for a missing module was not handled in the UI
  - Empty module names blocked only in the UI, not in the service
  - Score/weight range checked only after parse in the service (UI accepted out-of-range then showed a later error)
- **Fixes applied:**
  - Corrected imports to `model.Grade` / `model.Module`
  - UI null-checks `addGrade` result
  - Service rejects empty module names
  - UI validates score/weight ranges before calling the service
- Verified after fix: full compile + all edge-case tests pass

**In progress:**
- —

**Left:**
- —
