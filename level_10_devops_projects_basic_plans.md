# Level 10 DevOps Projects Basic Plans

These plans are designed so you can start coding immediately while still following a professional software planning structure.

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

## CI/CD Pipeline Dashboard

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Java, TypeScript  
**Core Stack:** Spring Boot, Next.js, GitHub Actions API, PostgreSQL, WebSockets  
**Goal:** Track GitHub Actions workflows and deployments from one dashboard.

### basicPlan

1. User enters GitHub repo.
2. Fetch latest GitHub Actions runs.
3. Display status cards.
4. Show failed jobs.
5. Show logs link.
6. Refresh manually.

### 1. Pre-Launch & Discovery

**Problem:** Developers need a clear overview of builds, failures, and deployment health.

**Target Users:** Developers, DevOps learners, project teams.

**MVP Success Criteria:**

- Add repository
- View workflow runs
- See success/failure status
- View run duration
- View failed jobs
- Store monitored repos

### 2. Planning & Design

**Main UI Screens:**

- Dashboard with repo cards
- Repository Detail Page
- Workflow Run Detail Page
- Failure Summary Page
- Settings Page

**Core Data / Models:**

```text
Repository
- id
- owner
- name
- provider
- createdAt

WorkflowRun
- id
- repositoryId
- externalRunId
- status
- conclusion
- startedAt
- completedAt
```

**Architecture:**

```text
Next.js Frontend
→ Spring Boot API
→ GitHub Actions API
→ PostgreSQL
→ Optional WebSocket Updates
```

### 3. Development

**Recommended Build Order:**

1. Build repo input UI.
2. Create backend repo model.
3. Connect GitHub Actions API.
4. Fetch workflow runs.
5. Store latest runs.
6. Build dashboard.
7. Add failure page.
8. Add periodic refresh.
9. Add WebSocket updates later.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
├── scripts/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Valid repo loads workflows
- Invalid repo shows error
- Failed workflow displays failure
- No workflows handled
- API rate limit handled
- Refresh updates status

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Uses environment variables for secrets
- Has a README
- Has screenshots or demo video
- Has meaningful commit history
- Has no secrets or private keys committed to GitHub
- Has basic automated tests where possible

### 5. Deployment & Launch

Deploy frontend to Vercel. Deploy backend to Render/Railway/Azure. Use GitHub token in backend environment variables.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- GitHub OAuth
- Slack/email alerts
- Deployment approval gates
- Multi-provider support
- Build time analytics

**What This Leads To:** DevOps dashboards, platform engineering, internal developer tools.

---


## Docker Container Dashboard

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python/Java, TypeScript  
**Core Stack:** FastAPI/Spring Boot, Next.js, Docker SDK, WebSockets  
**Goal:** Manage local Docker containers from a web dashboard.

### basicPlan

1. List running containers.
2. Show container status.
3. Start/stop/restart containers.
4. Show basic logs.
5. Show CPU/memory stats.

### 1. Pre-Launch & Discovery

**Problem:** Developers need a simple visual way to monitor and control containers.

**Target Users:** Developers, DevOps learners, homelab users.

**MVP Success Criteria:**

- List containers
- Start/stop/restart
- View logs
- View stats
- Filter by status
- Refresh dashboard

### 2. Planning & Design

**Main UI Screens:**

- Container Dashboard
- Container Detail Page
- Logs Panel
- Stats Panel
- Actions Menu

**Core Data / Models:**

```text
ContainerInfo
- id
- name
- image
- status
- ports
- createdAt

ContainerMetric
- containerId
- cpuPercent
- memoryUsage
- timestamp
```

**Architecture:**

```text
Next.js Frontend
→ Backend API
→ Docker Engine API / Docker SDK
→ WebSocket for logs/stats
```

### 3. Development

**Recommended Build Order:**

1. Connect backend to local Docker SDK.
2. List containers endpoint.
3. Start/stop/restart endpoints.
4. Logs endpoint.
5. Stats endpoint.
6. Build dashboard.
7. Add live updates.
8. Add safety confirmations.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
├── scripts/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Containers list correctly
- Stop button stops test container
- Restart works
- Logs display
- Backend handles Docker unavailable
- UI prevents accidental destructive actions

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Uses environment variables for secrets
- Has a README
- Has screenshots or demo video
- Has meaningful commit history
- Has no secrets or private keys committed to GitHub
- Has basic automated tests where possible

### 5. Deployment & Launch

Run locally because it needs Docker socket access. Do not expose publicly without strong authentication and permissions.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Docker Compose support
- Image management
- Volume/network viewer
- Alerts
- Kubernetes version

**What This Leads To:** Container orchestration, DevOps tooling, Kubernetes dashboards.

---


## Monitoring and Alerting Platform

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Python/Java, TypeScript  
**Core Stack:** FastAPI/Spring Boot, Next.js, Prometheus-style metrics, PostgreSQL/TimescaleDB  
**Goal:** Monitor app uptime and send alerts when services fail.

### basicPlan

1. Add service URL.
2. Periodically ping health endpoint.
3. Store response time and status.
4. Show uptime dashboard.
5. Trigger alert when service is down.

### 1. Pre-Launch & Discovery

**Problem:** Teams need to know when their services are down or slow.

**Target Users:** Developers, SRE learners, small teams.

**MVP Success Criteria:**

- Add monitored service
- Uptime checks
- Response time tracking
- Incident detection
- Alert history
- Status page

### 2. Planning & Design

**Main UI Screens:**

- Uptime Dashboard
- Service Detail Page
- Incident Timeline
- Status Page
- Alert Settings

**Core Data / Models:**

```text
Service
- id
- name
- url
- expectedStatusCode
- checkInterval

CheckResult
- id
- serviceId
- statusCode
- responseTimeMs
- success
- checkedAt

Incident
- id
- serviceId
- startedAt
- resolvedAt
- status
```

**Architecture:**

```text
Next.js Frontend
→ Backend API
→ Scheduler/Worker
→ Database
→ Alert Service
```

### 3. Development

**Recommended Build Order:**

1. Build service CRUD.
2. Add scheduled health checks.
3. Store check results.
4. Detect down status.
5. Build dashboard.
6. Add charts.
7. Add incident timeline.
8. Add email/Slack alerts later.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
├── scripts/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Healthy URL marked up
- Broken URL marked down
- Response time saved
- Incident opens on failure
- Incident resolves when service recovers
- Invalid URL rejected

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Uses environment variables for secrets
- Has a README
- Has screenshots or demo video
- Has meaningful commit history
- Has no secrets or private keys committed to GitHub
- Has basic automated tests where possible

### 5. Deployment & Launch

Deploy backend with always-on worker support. Use managed database. Frontend can deploy to Vercel.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- SSL expiry monitoring
- Public status page
- Multi-region checks
- Alert escalation
- Prometheus/Grafana integration

**What This Leads To:** SRE, observability platforms, reliability engineering.

---


## Infrastructure as Code Template Generator

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** TypeScript/Python  
**Core Stack:** Next.js, FastAPI, Terraform templates, YAML, GitHub export  
**Goal:** Generate starter Terraform/Docker/Kubernetes templates from user choices.

### basicPlan

1. User selects app type.
2. User selects cloud provider.
3. User selects database/container options.
4. App generates Terraform/Docker Compose template.
5. User downloads files.

### 1. Pre-Launch & Discovery

**Problem:** Beginners struggle to write correct infrastructure configuration from scratch.

**Target Users:** Students, DevOps learners, small teams.

**MVP Success Criteria:**

- Form-based infrastructure builder
- Generate Dockerfile
- Generate docker-compose.yml
- Generate Terraform skeleton
- Download ZIP
- Explain generated files

### 2. Planning & Design

**Main UI Screens:**

- Project Type Wizard
- Cloud Provider Selection
- Config Preview Page
- Generated Files Page
- Download Page

**Core Data / Models:**

```text
TemplateRequest
- appType
- language
- cloudProvider
- database
- containerised
- generatedAt

GeneratedFile
- filename
- content
```

**Architecture:**

```text
Next.js Frontend
→ Template API
→ Template Engine
→ ZIP Generator
```

### 3. Development

**Recommended Build Order:**

1. Define template options.
2. Create template files.
3. Build form wizard.
4. Generate files from options.
5. Preview generated content.
6. Add ZIP download.
7. Add explanations.
8. Add README examples.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
├── scripts/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Dockerfile generated correctly
- Compose file generated correctly
- Terraform files generated
- Invalid option combination handled
- ZIP downloads correctly

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Uses environment variables for secrets
- Has a README
- Has screenshots or demo video
- Has meaningful commit history
- Has no secrets or private keys committed to GitHub
- Has basic automated tests where possible

### 5. Deployment & Launch

Deploy frontend/backend normally. No privileged infrastructure access needed for MVP.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add Kubernetes manifests
- Add GitHub Actions pipelines
- Add Azure/AWS/GCP variants
- Add validation
- Add AI explanation assistant

**What This Leads To:** Developer platforms, DevOps education tools, internal tooling.

---

# Recommended Build Strategy

For each level:

1. Build the `basicPlan` version first.
2. Push the first working version to GitHub.
3. Add one professional feature.
4. Add tests and documentation.
5. Record a 60-90 second demo video.
6. Write what you learned in the README.

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
List languages, frameworks, databases, and tools.

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

## Future Improvements
List next features.
```
