# Level 1 Project

A collection of 10 Java console-based applications built as part of the Summer Learning Challenge. Each project follows a layered architecture pattern with `model`, `service`, `ui`, and `storage` packages where applicable. No external frameworks or libraries are used — all projects rely solely on the JDK standard library.

---

## What I Learned

| Category | Badges | Frameworks, Tools & Core Concepts |
| :--- | :--- | :--- |
| **Languages** | ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) | Java 8+, console applications, JDK standard library only |
| **Architecture** | ![OOP](https://img.shields.io/badge/OOP-2C3E50?style=for-the-badge) ![MVC](https://img.shields.io/badge/Layered_MVC-6C63FF?style=for-the-badge) | Packages: `model` / `service` / `ui` / `storage`, encapsulation, enums, abstract classes & polymorphism (e.g. TicTacToe players) |
| **Core Java APIs** | ![Java](https://img.shields.io/badge/java.util-007396?style=for-the-badge&logo=openjdk&logoColor=white) ![Time](https://img.shields.io/badge/java.time-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) | `ArrayList`, `List`, `Scanner`, `Collections.shuffle`, `LocalDate` / `LocalDateTime`, `Math` (calculator & grades) |
| **File I/O & Persistence** | ![I/O](https://img.shields.io/badge/File_I%2FO-4CAF50?style=for-the-badge) ![NIO](https://img.shields.io/badge/java.nio.file-1565C0?style=for-the-badge) | `BufferedReader` / `BufferedWriter`, `Files.move()` atomic saves, pipe/CSV text formats, binary serialization (`ObjectOutputStream`) |
| **Algorithms & Logic** | ![Algorithms](https://img.shields.io/badge/Algorithms-FF5722?style=for-the-badge) | Minimax AI (Hard TicTacToe), weighted averages, streak calculation, input validation & edge-case handling |
| **Dev Tools** | ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white) ![VS Code](https://img.shields.io/badge/VS_Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white) ![OpenJDK](https://img.shields.io/badge/OpenJDK-21-white?style=for-the-badge&logo=openjdk&logoColor=black) | Git version control, GitHub, VS Code / Cursor, `javac` / `java` CLI |

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
- **Done:** Updated root `README.md` so the project list matches `Do this in order.txt` (completion order 1–10); added **What I Learned** badge table (Java, OOP/layered architecture, File I/O, algorithms, Git/GitHub tools)
- **In progress:** —
- **Left:** —
