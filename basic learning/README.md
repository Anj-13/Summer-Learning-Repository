# Basic Learning

Small hands-on projects for learning fundamentals outside the larger challenge tracks. Each folder is a focused experiment — Docker basics, React tutorials, and similar bite-sized practice.

## Project Folders

### docker-basic

A simple Node.js/Express.js app containerized with Docker for learning containerization fundamentals. Serves a "Test docker" message on port 9000.

**What I learned:** Dockerfile syntax (`FROM`, `WORKDIR`, `COPY`, `RUN`, `ENV`, `EXPOSE`, `CMD`), building images, running containers, port mapping, Docker vs local development workflows.

**Tech Stack:** Node.js, Express.js, Docker, Dockerfile

See [`docker-basic/README.md`](docker-basic/README.md) for full details.

---

### tic-tac-toe-react

A browser-based Tic Tac Toe game built from the official React tutorial, using React, TypeScript, and Vite. Covers components, props, state, immutable updates, win detection, and move-history time travel.

**What I learned:** React function components, lifting state up, `useState`, deriving UI from history, ignoring illegal moves, and running a Vite + TypeScript frontend.

**Tech Stack:** React, TypeScript, Vite, CSS

See [`tic-tac-toe-react/Tutorial.md`](tic-tac-toe-react/Tutorial.md) for the project source.

---

## Consolidated Tech Stack

| Category | Badges | Frameworks, Tools & Core Concepts |
| :--- | :--- | :--- |
| **Languages** | ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![TypeScript](https://img.shields.io/badge/TypeScript-3178C6?style=for-the-badge&logo=typescript&logoColor=white) | JavaScript (ES6+), TypeScript |
| **Backend** | ![Node.js](https://img.shields.io/badge/Node.js-339933?style=for-the-badge&logo=nodedotjs&logoColor=white) ![Express.js](https://img.shields.io/badge/Express.js-000000?style=for-the-badge&logo=express&logoColor=white) | Express.js, simple HTTP server |
| **Frontend** | ![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=black) ![Vite](https://img.shields.io/badge/Vite-646CFF?style=for-the-badge&logo=vite&logoColor=white) | React components, hooks (`useState`), CSS |
| **DevOps & Tools** | ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white) ![NPM](https://img.shields.io/badge/NPM-CB3837?style=for-the-badge&logo=npm&logoColor=white) ![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white) | Dockerfile, Vite, npm scripts |
