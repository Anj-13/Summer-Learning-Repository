# Quiz App

A console-based quiz application built in Java that tests users on multiple-choice questions, tracks scores, and maintains a high score leaderboard.

## Features

- **Start Quiz** — Begin a randomized 5-question quiz with multiple-choice answers
- **View High Score** — Display the top 5 saved scores sorted in descending order
- **Exit** — Exit the application with a goodbye message
- **Input Validation** — Re-prompts for invalid menu choices and answer inputs
- **Answer Feedback** — Shows correct/wrong feedback after each answer
- **Score Calculation** — Displays final score and percentage after quiz completion
- **Score Persistence** — Saves scores to file and loads them on startup

## Menu

```
==== Quiz App ====
1. Start Quiz
2. View High Score
3. Exit
Enter choice:
```

## Data Model

| Field               | Type     | Description                                      |
|---------------------|----------|--------------------------------------------------|
| id                  | int      | Unique identifier for the question               |
| questionText        | String   | The question text displayed to the user          |
| options             | String[] | Array of 4 multiple-choice answer options        |
| correctAnswerIndex  | int      | Zero-based index of the correct answer           |

## File Storage Format

Scores are stored line-by-line in `highscore.txt`:

```
3
5
4
2
5
```

Each line is an integer representing the score achieved in a quiz session.

## Project Structure

| File                          | Purpose                                                  |
|-------------------------------|----------------------------------------------------------|
| `model/Question.java`         | Defines the Question data structure with getters         |
| `service/QuizService.java`    | Quiz logic: question loading, display, answer validation, scoring |
| `storage/ScoreManager.java`   | Score persistence: save, load, and display high scores   |
| `ui/QuizUI.java`              | User interface: menu system and operation routing        |
| `Main.java`                   | Entry point that launches the quiz application           |

## How to Run

**Prerequisites:** Java 8 or higher

1. Open a terminal in the `Quiz` directory
2. Compile all source files:
   ```
   javac -d . Main.java model\Question.java service\QuizService.java storage\ScoreManager.java ui\QuizUI.java
   ```
3. Run the application:
   ```
   java Main
   ```

## Edge Cases Handled

- **Non-numeric menu input** — Re-prompts until a valid integer is entered
- **Answer out of range** — Validates answer is within valid option range (1-4)
- **Non-numeric answer input** — Clears invalid input and re-prompts
- **No high scores yet** — Shows "No high scores yet" message when viewing empty leaderboard
- **File does not exist on startup** — Gracefully starts with empty score list
- **Corrupt score file line** — Invalid lines skipped; remaining scores still load
- **Empty question set** — Percentage reports `0.0%` instead of dividing by zero

## Future Improvements

- Categories and difficulty levels
- Timer for each question
- Leaderboard with player names
- Question file import (CSV/JSON)
- Web-based version
- AI-generated quiz questions

---

## Development Log

### [2026-07-18] Package Restructuring

**Done:**
- Moved `Question.java` → `model/Question.java` with `package model;`
- Moved `QuizService.java` → `service/QuizService.java` with `package service;`
- Moved `ScoreManager.java` → `storage/ScoreManager.java` with `package storage;`
- Moved `QuizUI.java` → `ui/QuizUI.java` with `package ui;`
- Updated `Main.java` with `import ui.QuizUI;`
- Created this `README.md` with full documentation

**In progress:**
- —

**Left:**
- —

### [2026-07-18] Edge Case Testing

**Done:**
- Ran automated edge-case tests (**5 passed** after fixes) for score persistence and quiz results
- Confirmed correct handling: empty high-score list; max high score; zero/full score percentage display
- **Bugs found:**
  - Menu used `scan.nextInt()` with no validation — non-numeric input crashed with `InputMismatchException`
  - Dual `Scanner` on `System.in` (UI + service) was fragile
  - Questions shuffled only once at construction — replay kept the same order
  - One bad line in `highscore.txt` aborted the rest of score loading via outer `NumberFormatException` catch
- **Fixes applied:**
  - Menu input now uses `hasNextInt()` / re-prompt pattern
  - Shared a single `Scanner` from `QuizUI` into `QuizService`
  - `Collections.shuffle` moved into `startQuiz()` so each run reorders questions
  - Score load skips invalid lines and continues
  - Guard against divide-by-zero in `showResult` when there are no questions
- Verified after fix: file `3 / bad / 7` loads high score `7`

**In progress:**
- —

**Left:**
- —
