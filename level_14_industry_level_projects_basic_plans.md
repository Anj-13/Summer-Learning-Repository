# Level 14 Industry-Level Projects Basic Plans

These plans are designed so you can start coding immediately while still following a professional software/product planning structure.

Each project includes:

- `basicPlan`: the fastest version you can build first
- Professional six-phase planning:
  1. Pre-Launch & Discovery
  2. Planning & Design
  3. Development
  4. Testing & Quality Assurance
  5. Deployment & Launch
  6. Post-Launch

---

## AI Developer Operating System

**Difficulty:** ⭐⭐⭐⭐⭐+  
**Languages:** Java, Python, TypeScript  
**Core Stack:** Next.js, Spring Boot, FastAPI, LangGraph, PostgreSQL, Redis, Vector DB, Docker  
**Goal:** Build a platform that connects to a codebase and uses AI agents to explain, document, review, and improve it.

### basicPlan

Build the MVP in this exact order:

1. User enters GitHub repository URL.
2. Backend clones repository.
3. Index source files.
4. Store file metadata.
5. Create embeddings for code chunks.
6. User asks questions about repo.
7. AI answers using retrieved code chunks.
8. Generate README/project documentation.
9. Generate suggested issues/tasks.

### 1. Pre-Launch & Discovery

**Problem:** Developers waste time understanding unfamiliar codebases, writing docs, creating issues, and reviewing changes.

**Target Users:** Students, developers, hackathon teams, engineering teams.

**MVP Success Criteria:**

- Connect GitHub repository by URL
- Index codebase
- Ask questions about code
- Generate documentation
- Generate issues/tasks
- View file tree
- View AI source references
- Export generated docs

### 2. Planning & Design

**Main UI / Interface Screens:**

- Dashboard: connected repositories
- Repository Detail Page
- File Explorer
- AI Chat Page
- Documentation Page
- Generated Issues Page
- Settings Page

**Core Data / Models:**

```text
Repository
- id
- name
- url
- localPath
- indexedAt

CodeFile
- id
- repositoryId
- path
- language
- contentHash

CodeChunk
- id
- fileId
- content
- startLine
- endLine
- embeddingId

GeneratedArtifact
- id
- repositoryId
- type
- content
- createdAt
```

**Architecture:**

```text
Next.js Frontend
→ Spring Boot Main API
→ FastAPI AI Service
→ Repo Indexer
→ Vector DB
→ PostgreSQL
→ Redis Queue
→ LLM Provider
```

### 3. Development

**Recommended Build Order:**

1. Build repo dashboard UI.
2. Create Spring Boot repository model/API.
3. Add Git clone service.
4. Parse files and ignore node_modules/build folders.
5. Create FastAPI embedding/indexing service.
6. Store metadata in PostgreSQL.
7. Store embeddings in vector DB.
8. Build repo chat endpoint.
9. Add documentation generator.
10. Add issue generator.
11. Add Docker Compose for services.
12. Add demo repo and README.

**Suggested Folder Structure:**

```text
project-name/
├── src/
├── assets/
├── docs/
├── tests/
├── scripts/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Valid repo clones
- Invalid repo URL fails gracefully
- Large folders ignored
- Files are indexed
- Repo chat cites relevant files
- Documentation generation works
- Docker Compose starts all services

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has a README
- Has screenshots or demo video
- Has meaningful commit history
- Has no secrets committed to GitHub
- Has basic automated tests where possible
- Has a clear architecture explanation

### 5. Deployment & Launch

Start with Docker Compose locally. Later deploy frontend to Vercel and services to Azure/AWS. Use a background worker for indexing.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- GitHub OAuth
- PR review agent
- Test generation
- Architecture diagram generation
- VS Code extension
- MCP tool support
- Multi-agent coding workflows

**What This Leads To:** Cursor-like tools, developer platforms, AI engineering, final-year project.

---


## Cursor-like AI IDE Prototype

**Difficulty:** ⭐⭐⭐⭐⭐+  
**Languages:** TypeScript, Python  
**Core Stack:** Electron, Monaco Editor, FastAPI, LLM API, Vector DB  
**Goal:** Build a desktop coding editor with AI chat over the local project.

### basicPlan

1. Create Electron desktop app.
2. Add Monaco code editor.
3. Open local folder.
4. Show file tree.
5. Read selected file.
6. Chat with AI about selected file.
7. Add simple code edit suggestion.

### 1. Pre-Launch & Discovery

**Problem:** Developers want AI help inside the editor with project context.

**Target Users:** Developers, students, AI coding tool builders.

**MVP Success Criteria:**

- Open local folder
- File tree
- Code editor
- AI chat
- Explain selected code
- Suggest improvements
- Apply suggested replacement manually

### 2. Planning & Design

**Main UI / Interface Screens:**

- Desktop Window
- Sidebar File Tree
- Code Editor
- AI Chat Panel
- Command Palette
- Settings/API Key Page

**Core Data / Models:**

```text
Workspace
- path
- openedAt

FileContext
- path
- language
- content

ChatSession
- id
- workspacePath
- messages
```

**Architecture:**

```text
Electron App
→ Renderer UI
→ Node File System Bridge
→ FastAPI/Local AI Service
→ LLM Provider
→ Optional Vector Index
```

### 3. Development

**Recommended Build Order:**

1. Create Electron app.
2. Add Monaco Editor.
3. Add open-folder functionality.
4. Render file tree.
5. Load file content.
6. Add AI chat panel.
7. Send selected file context to AI.
8. Add explain/refactor commands.
9. Add basic project indexing.
10. Package desktop app.

**Suggested Folder Structure:**

```text
project-name/
├── src/
├── assets/
├── docs/
├── tests/
├── scripts/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- App opens
- Folder can be selected
- File tree displays correctly
- File content opens in editor
- AI explains selected code
- Large file handled safely
- App does not expose API key in GitHub

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has a README
- Has screenshots or demo video
- Has meaningful commit history
- Has no secrets committed to GitHub
- Has basic automated tests where possible
- Has a clear architecture explanation

### 5. Deployment & Launch

Package with Electron Builder. Release on GitHub Releases. This is a desktop app, not a normal web deploy.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Inline AI edits
- Multi-file context
- Terminal integration
- Git diff viewer
- Extension system
- Local model support

**What This Leads To:** AI IDEs, developer tools, desktop app engineering.

---


## Google Docs Clone with Real-Time Collaboration

**Difficulty:** ⭐⭐⭐⭐⭐+  
**Languages:** TypeScript, Java optional  
**Core Stack:** Next.js, WebSockets, Yjs/CRDT, PostgreSQL, Redis  
**Goal:** Build a collaborative document editor where multiple users edit together in real time.

### basicPlan

1. Create document list.
2. Open rich text editor.
3. Save document.
4. Add WebSocket collaboration.
5. Show two users typing together.
6. Add presence cursors.
7. Persist document updates.

### 1. Pre-Launch & Discovery

**Problem:** Real-time collaboration requires conflict-free editing, presence, syncing, and persistence.

**Target Users:** Students, teams, writers, collaboration-tool learners.

**MVP Success Criteria:**

- Create document
- Edit rich text
- Real-time multi-user editing
- Save changes
- Show active users
- Document sharing link
- Basic permissions

### 2. Planning & Design

**Main UI / Interface Screens:**

- Document Dashboard
- Editor Page
- Share Modal
- Presence Avatars
- Version History Page optional

**Core Data / Models:**

```text
Document
- id
- title
- ownerId
- createdAt
- updatedAt

DocumentPermission
- id
- documentId
- userId
- role

DocumentUpdate
- id
- documentId
- updatePayload
- createdAt
```

**Architecture:**

```text
Next.js Frontend
→ Rich Text Editor + Yjs Client
→ WebSocket Collaboration Server
→ Redis Pub/Sub optional
→ PostgreSQL Persistence
```

### 3. Development

**Recommended Build Order:**

1. Build document dashboard.
2. Add basic editor.
3. Add save/load.
4. Add Yjs or CRDT provider.
5. Add WebSocket server.
6. Test two browser windows.
7. Add presence.
8. Add share links.
9. Persist updates.
10. Add permissions.

**Suggested Folder Structure:**

```text
project-name/
├── src/
├── assets/
├── docs/
├── tests/
├── scripts/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Document saves
- Two users see same edits
- Simultaneous typing does not overwrite
- Refresh loads latest document
- Share link works
- Permission checks block unauthorised users

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has a README
- Has screenshots or demo video
- Has meaningful commit history
- Has no secrets committed to GitHub
- Has basic automated tests where possible
- Has a clear architecture explanation

### 5. Deployment & Launch

Deploy frontend and collaboration server carefully. WebSocket server needs a persistent backend, not just static hosting. Use Render/Fly.io/Azure for backend.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Comments
- Version history
- Offline editing
- Export PDF/Markdown
- Team workspaces
- AI writing assistant

**What This Leads To:** Real-time collaboration, distributed systems, productivity SaaS.

---


## AI DevOps Engineer

**Difficulty:** ⭐⭐⭐⭐⭐+  
**Languages:** Python, TypeScript, Java optional  
**Core Stack:** Next.js, FastAPI/Spring Boot, Kubernetes API, Docker, Terraform templates, LLM Agent  
**Goal:** Build an AI assistant that diagnoses deployment issues and suggests fixes.

### basicPlan

1. User uploads Dockerfile, logs, or Kubernetes YAML.
2. AI analyses the files.
3. App identifies likely issues.
4. App suggests fixes.
5. App generates corrected config.
6. User can compare original vs fixed.

### 1. Pre-Launch & Discovery

**Problem:** Debugging deployments, logs, Dockerfiles, and Kubernetes configs is difficult for learners and teams.

**Target Users:** DevOps learners, SRE students, platform teams.

**MVP Success Criteria:**

- Upload logs/config files
- Analyse Dockerfile
- Analyse Kubernetes YAML
- Explain errors
- Generate fixed version
- Save reports

### 2. Planning & Design

**Main UI / Interface Screens:**

- Upload/Import Page
- Analysis Results Page
- Issue List
- Diff Viewer
- Fix Recommendation Page
- Reports Page

**Core Data / Models:**

```text
AnalysisJob
- id
- type
- status
- createdAt

UploadedArtifact
- id
- jobId
- filename
- content

Finding
- id
- jobId
- severity
- message
- suggestedFix

GeneratedFix
- id
- jobId
- content
- createdAt
```

**Architecture:**

```text
Next.js Frontend
→ Backend API
→ AI Diagnostic Agent
→ Static Rule Checker
→ PostgreSQL
→ Optional Kubernetes API Read-Only Integration
```

### 3. Development

**Recommended Build Order:**

1. Build upload UI.
2. Create analysis job API.
3. Add Dockerfile parser/basic rules.
4. Add Kubernetes YAML parser/basic rules.
5. Add AI explanation layer.
6. Add generated fix output.
7. Add side-by-side diff viewer.
8. Add report saving.
9. Add sample broken configs.
10. Add README and demo.

**Suggested Folder Structure:**

```text
project-name/
├── src/
├── assets/
├── docs/
├── tests/
├── scripts/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Dockerfile upload works
- YAML upload works
- Invalid YAML shows error
- Known bad config triggers finding
- Fixed config is displayed
- No real cluster write access in MVP

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has a README
- Has screenshots or demo video
- Has meaningful commit history
- Has no secrets committed to GitHub
- Has basic automated tests where possible
- Has a clear architecture explanation

### 5. Deployment & Launch

Deploy as analysis-only tool. Avoid giving the AI write access to real infrastructure until you add permissions, approvals, and audit logs.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- GitHub repo scan
- Kubernetes read-only diagnostics
- CI/CD failure analysis
- Terraform analysis
- Auto-fix pull request generation
- Approval-based infrastructure actions

**What This Leads To:** SRE tools, AI platform engineering, DevOps automation.

---

# Recommended Build Strategy

For these advanced levels:

1. Build the `basicPlan` version only.
2. Push the first working version to GitHub.
3. Record a demo as soon as it works.
4. Add one professional feature.
5. Add tests, architecture notes, and limitations.
6. Write a strong README explaining what you learned.

# Professional README Template

```md
# Project Name

## Problem
Explain what problem this solves.

## Features
- Feature 1
- Feature 2
- Feature 3

## Tech Stack
List languages, frameworks, databases, AI tools, cloud tools, and libraries.

## Architecture
Add a simple diagram or explanation.

## How To Run
Step-by-step setup instructions.

## Environment Variables
Show `.env.example`, not real secrets.

## Screenshots / Demo
Add images or video link.

## Testing
Explain how to run tests.

## What I Learned
Explain the technical skills gained.

## Limitations
Be honest about what the system cannot do yet.

## Future Improvements
List next features.
```
