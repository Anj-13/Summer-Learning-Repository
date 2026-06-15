# 🛋️ Couch to Coder 2025

All my learning materials from the CouchToCoder 2025 journey. This folder contains session notes, combined resources, and advanced topics covered during the program.

## 📅 Summer Holiday Progress

This repository contains everything I'm learning during the summer of 2025 as part of the **Couch to Coder** program.

## Sessions

- **session_1/** through **session_5/** — Core session materials
- **session_advanced/** — Advanced topics
- **Combined/** — Consolidated resources

## 🚀 What I'm Learning

- **Backend:** Node.js, Express.js
- **Frontend:** HTML5, CSS3, JavaScript
- **Data Visualization:** Chart.js
- **Tools:** Git, GitHub, VS Code, REST APIs

## 📁 Project Structure

```
📦 CouchToCoder2025/
├── 📂 Combined/           # Consolidated notes and references
├── 📂 session_1/          # Session 1 — Introduction & Setup
├── 📂 session_2/          # Session 2 — HTML, CSS, JavaScript
├── 📂 session_3/          # Session 3 — Node.js & Express.js
├── 📂 session_4/          # Session 4 — Chart.js & Data Visualization
├── 📂 session_5/          # Session 5 — APIs & Deployment
├── 📂 session_advanced/   # Advanced topics
└── 📄 README.md           # This file
```

## 📚 Resources

- **Couch to Coder 2025 curriculum** — Program structure and project guidelines
- **Express.js documentation** — [expressjs.com](https://expressjs.com)
- **Chart.js documentation** — [chartjs.org](https://www.chartjs.org)
- **MDN Web Docs** — HTML, CSS, JavaScript reference
- **Node.js documentation** — [nodejs.org](https://nodejs.org)

## 🍽️ Recipe Dashboard App

A full-stack web application that:
- Displays recipe data
- Shows cuisine popularity chart
- Allows adding new recipes (POST endpoint)

### API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/recipes` | Get all recipes |
| POST | `/recipes` | Add a new recipe |
| GET | `/cuisine-data` | Get cuisine statistics for chart |

## 🏃‍♂️ How to Run

1. **Install dependencies:**
   ```bash
   npm install express cors
   ```

2. **Start the backend server:**
   - Open `server.js` in VSCode and click the **Run** button (▷) in the top-right corner, or
   - Run in terminal:
     ```bash
     node server.js
     ```
   - Server starts at `http://localhost:3000`

3. **Open the frontend:**
   - Right-click `index.html` in VSCode → **Open with Live Server**
   - Or click **Go Live** in the VSCode status bar