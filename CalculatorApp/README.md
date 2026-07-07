# Calculator App

A console-based calculator application built in Java that supports basic and advanced arithmetic operations with persistent calculation history.

## Features

- **Add, Subtract, Multiply, Divide** — Perform basic arithmetic operations with divide-by-zero protection
- **Power, Square Root, Percentage** — Intermediate mathematical operations
- **Factorial, Sine, Cosine, Tangent** — Advanced operations with degree-based trigonometry
- **Calculation History** — View, clear (with confirmation), auto-save on exit, auto-load on start
- **Input Validation** — Graceful re-prompt for invalid numeric and menu entries
- **Edge Case Handling** — Guardrails against negative square root, negative factorial, and undefined tangent angles

## Menu

```
===== Calculator =====
1.  Add
2.  Subtract
3.  Multiply
4.  Divide
5.  Percentage
6.  Power
7.  Square Root
8.  Factorial
9.  Sine
10. Cosine
11. Tangent
12. View History
13. Clear History
14. Exit
======================
```

## Data Model

| Field      | Type     | Description              |
|------------|----------|--------------------------|
| `history`  | `ArrayList<String>` | In-memory calculation log |
| `filename`  | `String` | History file path        |

## File Storage Format

History is stored line-by-line in `history.txt`:

```
5 + 3 = 8.0
sqrt(9) = 3.0
5! = 120.0
```

Each line is a formatted entry string. The file is loaded on startup and saved on exit (option 14).

## Project Structure

| File                              | Purpose                                              |
|-----------------------------------|------------------------------------------------------|
| `service/Calculator.java`         | Core arithmetic and advanced math methods            |
| `storage/CalculationHistory.java` | In-memory history list with file I/O persistence     |
| `main.java`                       | Menu loop, user input, operation routing, history UI |
| `history.txt`                     | Persistent storage for calculation history           |

## How to Run

**Prerequisites:** Java 8 or higher

1. Compile all source files:
   ```
   javac -d . service\Calculator.java storage\CalculationHistory.java main.java
   ```
2. Run the application:
   ```
   java main
   ```

## Edge Cases Handled

| Scenario                          | Response                                      |
|-----------------------------------|-----------------------------------------------|
| Division by zero                  | `ArithmeticException` with descriptive message|
| Square root of negative number    | `ArithmeticException` with descriptive message|
| Factorial of negative number      | `ArithmeticException` with descriptive message|
| Tangent at 90°, 270°, etc.        | `ArithmeticException` with descriptive message|
| Non-numeric input                 | Re-prompt until valid number entered          |
| Invalid menu choice               | "Invalid choice. Please try again."           |
| Empty history view                | "No history available."                       |
| Clear history (with confirmation) | Prompts "y/n" before clearing                 |
| Missing history file on load      | Silently starts with empty history            |

## Future Improvements

- JavaFX graphical user interface
- Scientific calculator with additional functions
- Currency converter
- Unit converter
- Expression parser
- Finance and data processing tools
- Trading simulators

## Development Log

### [2026-07-06 00:00]

- **Done:** Created calculator methods, menu system, user input handling, divide-by-zero check, advanced operations, history management, history persistence to `history.txt`, input validation, clear-history confirmation, and edge case handling for negative square root, negative factorial, and undefined tangent angles.
- **In progress:** —
- **Left:** —

### [2026-07-07 14:57]

- **Done:** Restructured project into `service/` and `storage/` packages; moved `Calculator.java` → `service/Calculator.java` with `package service;`, moved `CalculationHistory.java` → `storage/CalculationHistory.java` with `package storage;`; renamed `Main.java` → `main.java`, updated imports and class name; removed `Basic Plan.md`; updated `README.md` with new structure and compile/run instructions.
- **In progress:** —
- **Left:** —
