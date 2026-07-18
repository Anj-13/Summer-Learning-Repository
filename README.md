# Level 1 Project

A collection of 10 Java console-based applications built as part of the Summer Learning Challenge. Each project follows a layered architecture pattern with `model`, `service`, `ui`, and `storage` packages where applicable. No external frameworks or libraries are used — all projects rely solely on the JDK standard library.

---

## Features

- **10 complete Java applications** covering various domains
- **Consistent architecture** across all projects using MVC-like layering
- **File-based persistence** using plain text / binary file I/O
- **Input validation** and error handling throughout
- **No external dependencies** — runs on Java 8+ alone

---

## Projects (completed in order)

Projects were built in the following order:

| # | Project | Folder | Description | Tech Stack |
|---|---------|--------|-------------|------------|
| 1 | **Calculator** | `CalculatorApp/` | Console calculator with basic and advanced arithmetic, plus history | Java (java.util, java.io, java.lang.Math) |
| 2 | **Tic Tac Toe** | `TicTacToe/` | Two-player / AI Tic Tac Toe with Easy, Medium, and Hard difficulties | Java (java.util) |
| 3 | **Contact Book** | `ContactBook/` | Contact management — add, view, search, edit, and delete | Java (java.util, java.io, java.nio.file) |
| 4 | **Student Task Manager** | `Student Task Manager/` | Student tasks with deadlines, priority, filters, and file persistence | Java (java.util, java.io, java.nio.file, java.time) |
| 5 | **Expense Tracker** | `ExpenseTracker/` | Track and manage daily expenses with filtering and reporting | Java (java.util, java.io, java.nio.file) |
| 6 | **Quiz App** | `Quiz/` | Console quiz with shuffled questions, scoring, and high-score file | Java (java.util, java.io) |
| 7 | **Grade Tracker** | `StudentGrade/` | Modules and weighted grades with binary persistence | Java (java.util, java.io) |
| 8 | **Library Management** | `LibraryManagementSystem/` | Books, borrowing, returns, and file persistence | Java (java.util, java.io, java.nio.file, java.time) |
| 9 | **Banking System** | `BankingSystem/` | Accounts, deposits, withdrawals, and transaction history | Java (java.util, java.io) |
| 10 | **Habit Tracker** | `HabitTracker/` | Daily habits with completion logging and streak tracking | Java (java.util, java.io, java.time) |

---

## Project Structure

| Path | Purpose |
|------|---------|
| `CalculatorApp/` | Calculator with history (project 1) |
| `TicTacToe/` | Tic Tac Toe game with AI (project 2) |
| `ContactBook/` | Contact book manager (project 3) |
| `Student Task Manager/` | Task management for students (project 4) |
| `ExpenseTracker/` | Personal expense tracking tool (project 5) |
| `Quiz/` | Quiz application with scoring (project 6) |
| `StudentGrade/` | Student grade recording and averages (project 7) |
| `LibraryManagementSystem/` | Library management and book lending (project 8) |
| `BankingSystem/` | Banking and account management (project 9) |
| `HabitTracker/` | Daily habit tracker (project 10) |

---

## How to Run

1. Ensure you have **Java 8 or higher** installed (`java -version` to check)
2. Navigate to any project folder (see table above)
3. Compile the sources (example):
   ```bash
   javac -d . Main.java
   ```
   Or compile packages explicitly as described in each project's own `README.md`
4. Run the main class:
   ```bash
   java Main
   ```

---

## Edge Cases Handled

- **Invalid menu selections** — prompts user for valid input
- **Empty data states** — graceful handling when no records exist
- **File not found errors** — creates files on first run / starts fresh
- **Input type mismatches** — caught and re-prompted
- **Empty string inputs** — rejected with appropriate messages
- **Project-specific edge cases** — documented in each project's `README.md` development log

---

## Future Improvements

- Migrate to GUI-based interfaces using JavaFX or Swing
- Integrate a database (e.g., SQLite or MySQL) for persistent storage
- Add unit testing with JUnit
- Implement REST APIs for web-based access
- Add multi-user support with authentication

---

## Development Log

### [2025-07-18 00:00]
- **Done:** Set up project repository with 10 Java console applications
- **In progress:** Documentation and README finalization
- **Left:** Potential GUI enhancements and database integration

### [2026-07-18]
- **Done:** Updated root `README.md` so the project list matches `Do this in order.txt` (completion order 1–10)
- **In progress:** —
- **Left:** —
