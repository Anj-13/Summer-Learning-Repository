# Level 13 AI Agents Projects Basic Plans

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

## Multi-Agent Startup Simulator

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** Next.js, FastAPI, LangGraph/CrewAI/AutoGen, PostgreSQL, Redis optional  
**Goal:** Simulate a startup team where AI agents collaborate to turn an idea into a plan.

### basicPlan

1. User enters startup idea.
2. Create 5 agents: CEO, Product Manager, Engineer, Designer, Marketer.
3. Each agent produces one document.
4. Manager agent combines outputs into final startup plan.
5. Display outputs in dashboard.

### 1. Pre-Launch & Discovery

**Problem:** One AI assistant gives shallow answers; specialised agents can divide work into product, tech, design, finance, and marketing.

**Target Users:** Students, founders, hackathon teams, product learners.

**MVP Success Criteria:**

- User submits idea
- Agents run sequentially or as a graph
- Each agent has a role
- App generates product plan, tech plan, UI plan, marketing plan
- Final report is downloadable

### 2. Planning & Design

**Main UI / Interface Screens:**

- Idea Input Page
- Agent Activity Dashboard
- Agent Output Cards
- Final Startup Plan Page
- Export Markdown Button

**Core Data / Models:**

```text
Project
- id
- idea
- status
- createdAt

Agent
- id
- name
- role
- systemPrompt

AgentOutput
- id
- projectId
- agentId
- content
- createdAt
```

**Architecture:**

```text
Next.js Frontend
→ FastAPI Backend
→ Agent Orchestrator
→ LLM Provider
→ PostgreSQL
→ Optional Redis Queue
```

### 3. Development

**Recommended Build Order:**

1. Build idea input UI.
2. Create FastAPI project endpoint.
3. Define agent roles/prompts.
4. Run agents sequentially first.
5. Store each output.
6. Display live-ish progress.
7. Generate final combined report.
8. Add export to Markdown.
9. Add README and demo startup idea.

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

- Idea submission creates project
- Each agent returns output
- Failed agent shows error
- Final report combines outputs
- Export works
- Long idea input handled safely

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

Deploy frontend to Vercel and backend to Render/Railway. Keep LLM API keys server-side.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add parallel agents
- Add human approval between steps
- Add generated task board
- Add financial model spreadsheet export
- Add pitch deck generation
- Add memory per project

**What This Leads To:** Agent orchestration, AI product tools, autonomous planning systems.

---


## AI Research Agent

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** Next.js, FastAPI, LangGraph, arXiv/Semantic Scholar APIs, Vector DB  
**Goal:** Build an AI agent that researches a topic, finds sources, summarises, and creates a report.

### basicPlan

1. User enters research question.
2. Search arXiv or web API.
3. Collect paper titles/abstracts.
4. Summarise each source.
5. Compare papers.
6. Generate final research brief with citations/links.

### 1. Pre-Launch & Discovery

**Problem:** Research takes time and users need structured, source-aware summaries.

**Target Users:** Students, researchers, analysts, final-year project learners.

**MVP Success Criteria:**

- Research query input
- Source search
- Paper/source cards
- Summaries
- Comparison table
- Final report export

### 2. Planning & Design

**Main UI / Interface Screens:**

- Research Query Page
- Source Results Page
- Research Dashboard
- Comparison Table
- Final Report Page

**Core Data / Models:**

```text
ResearchProject
- id
- query
- status
- createdAt

Source
- id
- projectId
- title
- authors
- url
- abstract
- publishedDate

Summary
- id
- sourceId
- keyFindings
- limitations
- relevanceScore
```

**Architecture:**

```text
Next.js Frontend
→ FastAPI Backend
→ Search Tool/API
→ Agent Graph
→ LLM Summariser
→ Vector DB/PostgreSQL
```

### 3. Development

**Recommended Build Order:**

1. Build query form.
2. Add source search API.
3. Store returned sources.
4. Summarise abstracts first.
5. Add comparison table.
6. Generate final report.
7. Add export.
8. Add source links.
9. Add PDF reading later.

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

- Query returns sources
- Empty query rejected
- Summaries generated
- Source links preserved
- Report cites sources
- API failure handled

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

Deploy frontend to Vercel and backend to Render/Railway. Use official/public APIs where possible and respect rate limits.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Download and parse PDFs
- Add knowledge graph
- Add citation formats
- Add contradiction detection
- Add slide generation
- Add scheduled literature monitoring

**What This Leads To:** Research assistants, RAG systems, academic AI tools.

---


## AI Project Manager Agent

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Python, TypeScript, Java optional  
**Core Stack:** Next.js, FastAPI/Spring Boot, LangGraph, PostgreSQL, GitHub API  
**Goal:** Turn a project idea into requirements, tasks, milestones, and GitHub issues.

### basicPlan

1. User enters project idea.
2. AI generates functional requirements.
3. AI creates milestones.
4. AI creates task breakdown.
5. User can edit tasks.
6. Export tasks to Markdown or GitHub issues.

### 1. Pre-Launch & Discovery

**Problem:** Students and teams struggle to break projects into organised, buildable tasks.

**Target Users:** Students, hackathon teams, solo developers.

**MVP Success Criteria:**

- Project idea input
- Requirements generation
- Milestone planning
- Task board
- Task priority/difficulty
- Markdown export

### 2. Planning & Design

**Main UI / Interface Screens:**

- Project Input Page
- Requirements Page
- Roadmap Page
- Kanban Task Board
- Export Page

**Core Data / Models:**

```text
Project
- id
- name
- description

Requirement
- id
- projectId
- type
- description

Milestone
- id
- projectId
- title
- dueOrder

Task
- id
- milestoneId
- title
- description
- priority
- status
```

**Architecture:**

```text
Next.js Frontend
→ Backend API
→ AI Planning Agent
→ PostgreSQL
→ GitHub API optional
```

### 3. Development

**Recommended Build Order:**

1. Build project creation UI.
2. Create backend project model.
3. Create AI prompt for requirements.
4. Create AI prompt for milestones/tasks.
5. Build Kanban board.
6. Add edit/delete task.
7. Add export to Markdown.
8. Add GitHub issue export later.

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

- Idea creates project
- Requirements are generated
- Tasks appear in board
- User can edit task
- Export includes all tasks
- AI errors handled gracefully

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

Frontend on Vercel. Backend on Render/Railway. GitHub integration optional after MVP.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- GitHub issue creation
- Sprint planning
- Risk analysis
- Progress reports
- Slack/email summaries
- Multi-agent planning

**What This Leads To:** Developer productivity tools, AI project planning, internal tools.

---


## AI Personal Agent with Tools

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** Next.js, FastAPI, LangGraph, Tool Calling, PostgreSQL, Vector DB  
**Goal:** Create a personal AI agent that can use tools like notes, calendar mock data, search, and task planning.

### basicPlan

1. Build chat UI.
2. Add backend agent.
3. Give agent tools: create task, list tasks, search notes.
4. Store tasks and notes.
5. Add memory retrieval.
6. Show which tool the agent used.

### 1. Pre-Launch & Discovery

**Problem:** Basic chatbots cannot take structured actions or remember useful context.

**Target Users:** Students, productivity enthusiasts, AI engineering learners.

**MVP Success Criteria:**

- Chat with agent
- Agent can create tasks
- Agent can search notes
- Agent can summarise notes
- Agent has simple memory
- Tool usage is visible

### 2. Planning & Design

**Main UI / Interface Screens:**

- Chat Page
- Tasks Page
- Notes Page
- Agent Tool Log Panel
- Settings Page

**Core Data / Models:**

```text
UserNote
- id
- title
- content
- embeddingId

Task
- id
- title
- dueDate
- status

AgentRun
- id
- userMessage
- toolCalls
- finalAnswer
- createdAt
```

**Architecture:**

```text
Next.js Chat UI
→ FastAPI Agent Backend
→ Tool Registry
→ Database
→ Vector Search
→ LLM Provider
```

### 3. Development

**Recommended Build Order:**

1. Build chat UI.
2. Add backend chat endpoint.
3. Create task CRUD.
4. Register create/list task tools.
5. Create notes CRUD.
6. Add note search.
7. Add vector memory.
8. Display tool logs.
9. Add README and demo.

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

- Chat response works
- Agent creates task when asked
- Agent lists tasks
- Agent searches notes
- Tool failure is handled
- Memory retrieval returns relevant notes

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

Deploy frontend/backend normally. Keep tool actions limited and safe in MVP. Do not connect real email/calendar until you have permission handling.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Calendar integration
- Email draft integration
- Voice mode
- Long-term memory
- Multi-agent mode
- Mobile app

**What This Leads To:** AI assistants, agentic workflows, productivity systems.

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
