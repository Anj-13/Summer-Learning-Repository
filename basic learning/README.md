# Basic Learning

Small hands-on projects for learning fundamentals outside the larger challenge tracks. Each folder is a focused experiment — Docker basics, React and Next.js tutorials, Scala exercises, and similar bite-sized practice.

## Project Folders

### docker-basic

A simple Node.js/Express.js app containerized with Docker for learning containerization fundamentals. Serves a "Test docker" message on port 9000.

**What I learned:** Dockerfile syntax (`FROM`, `WORKDIR`, `COPY`, `RUN`, `ENV`, `EXPOSE`, `CMD`), building images, running containers, port mapping, Docker vs local development workflows.

**Tech Stack:** Node.js, Express.js, Docker, Dockerfile, pnpm

See [`docker-basic/README.md`](docker-basic/README.md) for full details.

---

### tic-tac-toe-react

A browser-based Tic Tac Toe game built from the official React tutorial, using React, TypeScript, and Vite. Covers components, props, state, immutable updates, win detection, and move-history time travel.

**What I learned:** React function components, lifting state up, `useState`, deriving UI from history, ignoring illegal moves, and running a Vite + TypeScript frontend.

**Tech Stack:** React, TypeScript, Vite, CSS

See [`tic-tac-toe-react/Tutorial.md`](tic-tac-toe-react/Tutorial.md) for the project source.

---

### React-vers/weather-app

A React weather dashboard that ports the vanilla `WeatherApp` from `Level 2 Project` into components and hooks, styled with Tailwind CSS. It uses demo data; no live weather API is connected yet.

**What I learned:** Splitting a vanilla UI into components, lifting state into hooks, keeping data behind a service layer, and building layouts with Tailwind CSS.

**Tech Stack:** React 19, TypeScript, Vite 7, Tailwind CSS v4, LocalStorage

See [`React-vers/weather-app/README.md`](React-vers/weather-app/README.md) for full details.

---

### nextjs-dashboard

A full-stack financial dashboard for invoices, customers, and revenue, built by following the official Next.js Learn course. It falls back to a local in-memory database when Postgres is unavailable.

**What I learned:** Next.js App Router, Server Components, streaming, search and pagination with URL params, Server Actions, form validation, and authentication.

**Tech Stack:** Next.js, React, TypeScript, Tailwind CSS, PostgreSQL, NextAuth.js, bcrypt, Zod, pnpm

See [`nextjs-dashboard/README.md`](nextjs-dashboard/README.md) for full details.

---

### scala-learning

Functional programming exercises in Scala 3, checked by example tests and property-based tests.

**What I learned:** Higher-order functions, the Scala `String` API, case class methods, and property-based testing.

**Tech Stack:** Scala 3, Scala CLI, ScalaTest, ScalaCheck

See [`scala-learning/src/main/exercise/valfunction/ValueFunctionExercises.scala`](scala-learning/src/main/exercise/valfunction/ValueFunctionExercises.scala) for the exercises.

---

## Consolidated Tech Stack

| Category | Badges | Frameworks, Tools & Core Concepts |
| :--- | :--- | :--- |
| **Languages** | ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white) ![Scala](https://img.shields.io/badge/Scala-DC322F?style=for-the-badge&logo=scala&logoColor=white) | JavaScript (ES6+), TypeScript, Scala 3 |
| **Backend** | ![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white) ![Express.js](https://img.shields.io/badge/Express.js-000000?style=for-the-badge&logo=express&logoColor=white) ![Next.js](https://img.shields.io/badge/Next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white) | Express.js, simple HTTP server, Next.js Server Actions |
| **Frontend** | ![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=black) ![Next.js](https://img.shields.io/badge/Next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white) ![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white) ![Tailwind CSS](https://img.shields.io/badge/Tailwind_CSS-06B6D4?style=for-the-badge&logo=tailwindcss&logoColor=white) | React components, hooks (`useState`), Next.js App Router, CSS |
| **Database & Auth** | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white) | PostgreSQL, NextAuth.js, bcrypt, Zod validation |
| **Testing** | ![Scala](https://img.shields.io/badge/Scala-DC322F?style=for-the-badge&logo=scala&logoColor=white) | ScalaTest, ScalaCheck, property-based testing |
| **DevOps & Tools** | ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white) ![NPM](https://img.shields.io/badge/NPM-CB3837?style=for-the-badge&logo=npm&logoColor=white) ![pnpm](https://img.shields.io/badge/pnpm-F69220?style=for-the-badge&logo=pnpm&logoColor=white) ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) | Dockerfile, Vite, Scala CLI, npm and pnpm scripts |
