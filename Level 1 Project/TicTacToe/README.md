# Tic Tac Toe

A console-based Tic Tac Toe game built in Java featuring multiple AI difficulty levels, including an unbeatable Minimax opponent. Designed for two players (Human vs Human, Human vs Computer, or Computer vs Computer).

## Features

- **Play against Human or AI** — Choose from Easy, Medium, or Hard (unbeatable) computer opponents
- **3x3 Board** — Classic grid with row/column coordinate input
- **Win Detection** — Automatically detects row, column, and diagonal wins
- **Draw Detection** — Recognises a full board with no winner
- **Input Validation** — Rejects out-of-bounds, occupied cells, and non-numeric input with descriptive messages
- **Play Again** — Restart without relaunching the program
- **Player Factory** — Menu-driven player selection with name customisation
- **Minimax Algorithm** — Hard difficulty uses full game-tree search for perfect play

## Menu

```
==== Tic Tac Toe ====

Select Player 1 type:
1 - Human
2 - Computer (Easy)
3 - Computer (Medium)
4 - Computer (Hard - Unbeatable)
Enter choice (1-4):
```

During gameplay:
```
Player X turn
Enter row:
Enter column:
```

## Data Model

| Field | Type | Description |
|---|---|---|
| `board` | `char[3][3]` | 3x3 grid storing `'X'`, `'O'`, or `' '` (empty) |
| `symbol` | `char` | Player's mark (`'X'` or `'O'`) |
| `name` | `String` | Player's display name |
| `currentPlayer` | `Player` | Reference to the active player (polymorphic) |
| `gameRunning` | `boolean` | Controls the main game loop |

## Project Structure

| File | Purpose |
|---|---|
| `Main.java` | Entry point — instantiates `Game` and calls `startGame()` |
| `Game.java` | Orchestrates the match loop, win/draw checks, and play-again flow |
| `Board.java` | Models the 3x3 grid with move validation, display, and reset |
| `Player.java` | Abstract base class defining `getMove()` contract |
| `HumanPlayer.java` | Reads row/col from `Scanner` with error handling |
| `ComputerPlayer.java` | Abstract base with helper methods (`getWinningMove`, `checkWin`, `getEmptyCells`) |
| `EasyComputer.java` | Picks a random empty cell |
| `MediumComputer.java` | Rule-based: win > block > centre > corner > random |
| `HardComputer.java` | Minimax algorithm — never loses |
| `PlayerFactory.java` | Menu display, input validation, and player instantiation |

## How to Run

**Prerequisite:** Java 8 or higher

1. Open a terminal in the `TicTacToe` directory
2. Compile all source files:
   ```
   javac *.java
   ```
3. Run the game:
   ```
   java Main
   ```

## Edge Cases Handled

| Scenario | Response |
|---|---|
| Out-of-bounds cell | Error message, re-prompt |
| Occupied cell | Error message, re-prompt |
| Non-numeric input | Catches `InputMismatchException`, clears buffer, re-prompts |
| Empty player name | Defaults to `"Player 1"` or `"Player 2"` |
| Board full with no winner | Announces draw, offers play again |
| No legal moves remaining | Breaks out of game loop gracefully |
| Invalid menu choice (outside 1-4) | Re-prompts until valid input is entered |

## Future Improvements

- GUI version (Swing / JavaFX)
- Online multiplayer
- Scoreboard tracking across sessions
- Sound effects and animations

## Development Log

### [2026-07-06]

- **Done:** Created project structure with `Board`, `Game`, `Player`, `Main`, `HumanPlayer`, `ComputerPlayer`, `EasyComputer`, `MediumComputer`, `HardComputer`, and `PlayerFactory` classes. Implemented Minimax for Hard difficulty. Added input validation and error handling throughout.
- **In progress:** Documentation and README finalisation.
- **Left:** GUI version, online multiplayer, scoreboard persistence.
