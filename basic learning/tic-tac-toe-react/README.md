# Tic Tac Toe (React)

A browser-based Tic Tac Toe game built with React, TypeScript, and Vite. It follows the official React tutorial and is aimed at beginners learning component state, props, and immutable updates.

## Features

- **Place Marks** — Click an empty square to place `X` or `O` on alternating turns
- **Show Status** — Display whose turn it is, or announce the winner when the game ends
- **Detect Wins** — Check all eight winning lines (rows, columns, diagonals) after each move
- **Ignore Illegal Clicks** — Block clicks on occupied squares and on the board after a winner exists
- **Time Travel** — Keep a full move history and jump back to any earlier move
- **Truncate Future History** — When playing from a past move, discard the old forward branch and continue from there



## Menu

There is no text menu. The UI is a game board plus a move-history list:

```
Next player: X          (or: Winner: X / Winner: O)

[ ] [ ] [ ]
[ ] [ ] [ ]
[ ] [ ] [ ]

1. Go to game start
2. Go to move #1
3. Go to move #2
   ...
```



## Data Model


| Field         | Type                           | Description                                           |
| ------------- | ------------------------------ | ----------------------------------------------------- |
| `squares`     | `(string | null)[]` (length 9) | Board cells; `null` empty, `'X'` or `'O'` when filled |
| `history`     | `(string | null)[][]`          | Ordered list of board snapshots, starting with empty  |
| `currentMove` | `number`                       | Index into `history` for the board currently shown    |
| `xIsNext`     | `boolean`                      | Derived: `true` when `currentMove` is even (X’s turn) |
| `value`       | `string | null`                | Mark shown inside a single `Square`                   |
| `winner`      | `string | null`                | Result of `calculateWinner`; `'X'`, `'O'`, or `null`  |




## File Storage Format

No file persistence. All game state lives in React `useState` in memory for the browser session. Refreshing the page resets the game.

## Project Structure


| File                 | Purpose                                                                      |
| -------------------- | ---------------------------------------------------------------------------- |
| `index.html`         | HTML shell with `#root` mount point and Vite entry script                    |
| `src/main.tsx`       | Bootstraps React (`createRoot`) and renders the default export in StrictMode |
| `src/App.tsx`        | Game logic: `Square`, `Board`, `Game`, and `calculateWinner`                 |
| `src/styles.css`     | Layout and styling for squares, board rows, status, and game info            |
| `package.json`       | Project metadata, scripts (`dev`, `build`, `lint`, `preview`), dependencies  |
| `package-lock.json`  | Locked dependency versions                                                   |
| `vite.config.ts`     | Vite config with `@vitejs/plugin-react`                                      |
| `tsconfig.json`      | Root TypeScript project references                                           |
| `tsconfig.app.json`  | TypeScript options for app source                                            |
| `tsconfig.node.json` | TypeScript options for Node/Vite config                                      |
| `eslint.config.js`   | ESLint flat config for React/TypeScript                                      |
| `.gitignore`         | Ignores `node_modules`, build output, and local env files                    |
| `Tutorial.md`        | Default Vite + React + TypeScript template notes                             |
| `README.md`          | This project documentation                                                   |




## How to Run

**Prerequisites:** Node.js (npm) installed

1. Open a terminal in the `tic-tac-toe-react` directory
2. Install dependencies: `npm install`
3. Start the dev server: `npm run dev`
4. Open the local URL printed in the terminal (typically `http://localhost:5173`)

Optional:

- Production build: `npm run build`
- Preview build: `npm run preview`
- Lint: `npm run lint`



## Edge Cases Handled

- **Click occupied square** — `handleClick` returns early; board unchanged
- **Click after a win** — `calculateWinner` short-circuits; no further moves allowed on that branch
- **Jump to past move then play** — `history` is sliced to `currentMove + 1` before appending, so the old future is discarded
- **Empty starting board** — `history` starts as `[Array(9).fill(null)]` with `currentMove` at `0`



## Future Improvements

- Draw / stalemate detection when the board is full with no winner
- Highlight the three winning squares
- Restart / “New game” control without using history
- Player names and score tracking across rounds
- Persist history with `localStorage`
- Stronger TypeScript typing on component props (explicit interfaces)

---



## Development Log



### [2026-08-02 17:20]

**Done:**

- Documented the finished React tic-tac-toe tutorial in `TEST.md` (purpose, features, data model, file roles, run steps)
- Confirmed core behaviour in `src/App.tsx`: turn alternation, win checks, illegal-click guards, and move-history time travel

**In progress:**

- —

**Left:**

- (Optional) Replace default Vite `README.md` with project-specific docs
- (Optional) Add draw detection and winning-line highlight

