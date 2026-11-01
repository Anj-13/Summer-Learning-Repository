# Summer Learning Repository

Everything I learn during summer holiday goes here. This repo captures all topics, projects, and experiments explored — regardless of the year. Browse the folders to see what's inside.

## Table of Contents
- [Overview](#overview)
- [Projects](#projects)
- [Consolidated Tech Stack](#consolidated-tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [How to Use](#how-to-use)
- [Logging and Data](#logging-and-data)
- [Development Notes](#development-notes)
- [Future Improvements](#future-improvements)
- [License](#license)

## Overview

This repository is a record of my summer learning: a full-stack web course, Java console applications, front-end projects, and small experiments with new tools. Each folder is its own project with its own dependencies, so nothing needs to be installed at the repo root. The [Consolidated Tech Stack](#consolidated-tech-stack) tracks everything I have used so far.

## Projects

### CouchToCoder2025

A full-stack web development journey through the Couch to Coder 2025 program. Starts from JavaScript basics and progresses to building a complete **Recipe Dashboard** — a full-stack app with CRUD API, dynamic frontend, and Chart.js data visualization.

**Sessions:**
- **Session 1** — JavaScript intro: variables, operators, control flow
- **Session 2** — Arrays, Objects, Loops
- **Session 3** — Node.js & Express.js server setup, GET/POST routes, JSON file I/O
- **Session 4** — HTML5 structure, CSS3 styling, DOM manipulation
- **Session 5** — Full CRUD API, async/await `fetch()`, HTML forms, CSS flexbox & media queries
- **Session Advanced** — Chart.js pie charts, data aggregation with `reduce()`
- **Combined** — Final integrated app: Recipe Dashboard + Cuisine Data chart with page navigation

**Tech Stack:** HTML5, CSS3, JavaScript (ES6+), Node.js, Express.js, Chart.js, JSON, CORS, npm

See [`CouchToCoder2025/README.md`](CouchToCoder2025/README.md) for full details.

---

### Level 1 Project

A collection of **10 Java console applications** built for the Summer Learning Challenge. Each app uses a layered `model` / `service` / `ui` / `storage` architecture where applicable, with file-based persistence and no external libraries.

**Projects:** CalculatorApp, TicTacToe, ContactBook, Student Task Manager, ExpenseTracker, Quiz, StudentGrade, LibraryManagementSystem, BankingSystem, HabitTracker

**What I learned:** Layered OOP design, enums & polymorphism, `java.time`, file I/O (`BufferedReader`/`BufferedWriter`, `Files.move()`, binary serialization), algorithms (e.g. Minimax AI), and input validation.

**Tech Stack:** Java 8+, JDK standard library only

See [`Level 1 Project/README.md`](Level%201%20Project/README.md) for full details.

---

### Level 2 Project

Beginner web projects for the Summer Learning Challenge. So far this contains **WeatherApp**, a browser-based weather dashboard with city search, a 5-day forecast, animated weather conditions, and saved favourites. It uses demo data; no live weather API is connected yet.

**What I learned:** DOM rendering without a framework, input validation, LocalStorage persistence, CSS animations, and responsive layouts.

**Tech Stack:** HTML5, CSS3, JavaScript (vanilla), LocalStorage

See [`Level 2 Project/README.md`](Level%202%20Project/README.md) for full details.

---

### basic learning

Small hands-on projects for learning fundamentals outside the larger challenge tracks.

| Project | What it is | Tech Stack |
| :--- | :--- | :--- |
| **docker-basic** | A Node.js/Express.js app containerized with Docker | Node.js, Express.js, Docker, pnpm |
| **tic-tac-toe-react** | The official React tutorial game with move-history time travel | React, TypeScript, Vite, CSS |
| **React-vers/weather-app** | The vanilla WeatherApp ported to React components and hooks | React 19, TypeScript, Vite 7, Tailwind CSS v4 |
| **nextjs-dashboard** | The Next.js Learn financial dashboard with invoices, search, and authentication | Next.js, React, TypeScript, Tailwind CSS, PostgreSQL, NextAuth.js, Zod, pnpm |
| **scala-learning** | Functional programming exercises with property-based tests | Scala 3, Scala CLI, ScalaTest, ScalaCheck |

See [`basic learning/README.md`](basic%20learning/README.md) for full details.

---

## Consolidated Tech Stack

| Category | Badges | Frameworks, Tools & Core Concepts |
| :--- | :--- | :--- |
| **Languages** | ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white) ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Scala](https://img.shields.io/badge/Scala-DC322F?style=for-the-badge&logo=scala&logoColor=white) ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white) | JavaScript (ES6+), TypeScript, Java, Scala 3, HTML5, CSS3 |
| **Backend** | ![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white) ![Express.js](https://img.shields.io/badge/Express.js-000000?style=for-the-badge&logo=express&logoColor=white) ![Next.js](https://img.shields.io/badge/Next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white) | Express.js, REST APIs, CORS, JSON configuration, Next.js Server Actions |
| **Frontend** | ![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=black) ![Next.js](https://img.shields.io/badge/Next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white) ![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white) ![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white) ![Chart.js](https://img.shields.io/badge/Chart.js-FF6384?style=for-the-badge&logo=chartdotjs&logoColor=white) | Vanilla JavaScript, React hooks, Next.js App Router, Flexbox, Media Queries, Google Fonts, LocalStorage |
| **Database & Auth** | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white) | PostgreSQL, NextAuth.js, bcrypt, Zod validation |
| **DevOps & Tools** | ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white) ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white) ![VS Code](https://img.shields.io/badge/VS_Code-007ACC?style=for-the-badge&logo=visual-studio-code&logoColor=white) ![NPM](https://img.shields.io/badge/NPM-CB3837?style=for-the-badge&logo=npm&logoColor=white) ![pnpm](https://img.shields.io/badge/pnpm-F69220?style=for-the-badge&logo=pnpm&logoColor=white) | Dockerfile, Live Server plugin, npm and pnpm scripts |
| **Java Deep Dive** | ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) | Java 8+, layered MVC (`model`/`service`/`ui`/`storage`), `java.time`, File I/O (`BufferedReader`/`BufferedWriter`, `Files.move()`, serialization), OOP (enums, polymorphism), algorithms (Minimax) |
| **Scala Deep Dive** | ![Scala](https://img.shields.io/badge/Scala-DC322F?style=for-the-badge&logo=scala&logoColor=white) | Scala 3, Scala CLI, higher-order functions, ScalaTest, property-based testing (ScalaCheck) |

## Project Structure

```text
Summer-Learning-Repository/
├── CouchToCoder2025/        # Full-stack course: sessions 1–5, advanced, combined app
├── Level 1 Project/         # 10 Java console applications
├── Level 2 Project/         # Beginner web projects
│   └── WeatherApp/          # Vanilla JavaScript weather dashboard
├── basic learning/          # Small focused experiments
│   ├── docker-basic/        # Node.js app in Docker
│   ├── tic-tac-toe-react/   # React tutorial game
│   ├── React-vers/
│   │   └── weather-app/     # React port of WeatherApp
│   ├── nextjs-dashboard/    # Next.js financial dashboard
│   └── scala-learning/      # Scala exercises and tests
└── README.md
```

## Getting Started

### Prerequisites

Only install what the project you want to run needs:

- **Web and Node.js projects:** Node.js 18+, plus pnpm for `nextjs-dashboard`
- **Level 1 Project:** Java 8+
- **docker-basic:** Docker
- **scala-learning:** Scala CLI

### Installation

```bash
git clone https://github.com/Anj-13/Summer-Learning-Repository.git
cd Summer-Learning-Repository
```

`node_modules` is not committed, so install dependencies inside a project folder before running it.

### Run

| Project | From folder | Commands |
| :--- | :--- | :--- |
| Recipe Dashboard (Combined) | `CouchToCoder2025/Combined/server` | `npm install`, then `node index.js`, then open `Frontend/index.html` with Live Server |
| Level 1 apps | See [`Level 1 Project/README.md`](Level%201%20Project/README.md) | `javac -d . Main.java`, then `java Main` |
| WeatherApp | `Level 2 Project/WeatherApp` | Open `index.html` in a browser |
| docker-basic | `basic learning/docker-basic` | `docker build -t docker-basic .`, then `docker run -p 9000:9000 docker-basic` |
| tic-tac-toe-react | `basic learning/tic-tac-toe-react` | `npm install`, then `npm run dev` |
| weather-app (React) | `basic learning/React-vers/weather-app` | `npm install`, then `npm run dev` |
| nextjs-dashboard | `basic learning/nextjs-dashboard` | `pnpm install`, then `pnpm dev` |
| scala-learning | `basic learning/scala-learning` | `scala-cli test .` |

## How to Use

1. **Start:** Pick a project from [Projects](#projects) and open its folder.
2. **Interact:** Follow that project's README, which covers its features and setup in more detail.
3. **Finish:** Check the [Consolidated Tech Stack](#consolidated-tech-stack) to see what the repo covers so far.

## Logging and Data

Nothing is stored at the repo level. Each project handles its own data:

- **CouchToCoder2025:** recipes are saved in JSON files in each `server/` folder.
- **Level 1 Project:** apps save to local text or binary files.
- **WeatherApp and weather-app (React):** favourites are saved in browser LocalStorage.
- **nextjs-dashboard:** uses PostgreSQL when `POSTGRES_URL` is set, otherwise a local in-memory database.

## Development Notes

### Branch integration

Work on Level 2 and basic learning started on separate branches. On Nov 1, 2026, the remaining work was merged into `main`: `basic-learing-only` as a normal merge, and the orphan branch `level2-project-only` with `--allow-unrelated-histories` into `Level 2 Project/`. The committed `node_modules` folders under `CouchToCoder2025` were removed from tracking at the same time.

### Cursor agents — what has been done

This repository is also a record of how **Cursor agents** were used for Git recovery and branch integration.

#### Aug 9 & 10, 2026: human rebase error and repo mess

While trying to bring the orphan branch `basic-learing-only` (basic learning work: React weather app, Next.js dashboard) into `main`, a **rebase** was used instead of a merge. That rewrote `main`’s history, made the commit graph confusing, and made it look as if earlier commits were lost. The orphan branch itself was still fine; the damage was on `main` (and briefly on `origin/main` after the rewritten history was pushed).

#### Using Cursor agents to recover and merge correctly

Cursor agents were then used to:

1. **Inspect** `git reflog` / branch state and confirm the commits were recoverable, not permanently deleted.
2. **Reset** local `main` to the pre-rebase tip (`cfef51b` — *Aug 2: Moved docker-basic to basic learning and added tic-tac-toe-react*).
3. **Force-push with lease** (on explicit approval) so `origin/main` matched that restored history.
4. **Merge** the orphan branch the right way: `git merge basic-learing-only --allow-unrelated-histories`, producing merge commit `92c988f` on `main`, then push.

Outcome: `main` keeps its original history **and** the unrelated `basic-learing-only` history, joined by a proper merge commit, with the basic learning projects available under `basic learning/`.

This section exists so future work (and future Cursor agents) know that orphan branches in this repo were meant to be **merged with unrelated histories**, and that the Aug 10 incident was fixed by agent-assisted recovery after a human rebase mistake — not by more rebasing.

## Future Improvements

- [ ] Connect WeatherApp to a live weather API, with the API key kept in environment variables
- [ ] Add more projects to `Level 2 Project/`
- [ ] Move this README to the portfolio template once the work is ready

## License

No license has been specified.
