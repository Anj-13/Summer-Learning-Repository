# Level 9 Cloud Computing Projects Basic Plans

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

## Cloud File Storage Platform

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Java, TypeScript  
**Core Stack:** Spring Boot, Next.js, PostgreSQL, AWS S3/Azure Blob, JWT  
**Goal:** Build a mini Google Drive for uploading, organising, and sharing files.

### basicPlan

1. Create user auth.
2. Upload file to cloud storage.
3. Save file metadata in database.
4. List user's files.
5. Download file.
6. Delete file.
7. Add folder support.

### 1. Pre-Launch & Discovery

**Problem:** Users need cloud storage with folders, permissions, and sharing.

**Target Users:** Students, teams, small organisations.

**MVP Success Criteria:**

- Register/login
- Upload files
- Create folders
- Download files
- Delete files
- Share file with public link

### 2. Planning & Design

**Main UI Screens:**

- Login/Register
- Drive Dashboard
- Folder View
- Upload Modal
- File Preview Page
- Share Link Modal

**Core Data / Models:**

```text
User
- id
- email
- passwordHash

FileObject
- id
- ownerId
- folderId
- filename
- storageKey
- mimeType
- size
- createdAt

Folder
- id
- ownerId
- parentFolderId
- name
```

**Architecture:**

```text
Next.js Frontend
→ Spring Boot API
→ PostgreSQL Metadata
→ S3/Azure Blob File Storage
```

### 3. Development

**Recommended Build Order:**

1. Create Spring Boot API.
2. Add authentication.
3. Connect PostgreSQL.
4. Add file upload endpoint.
5. Upload files to cloud object storage.
6. Store metadata.
7. Build dashboard.
8. Add folder CRUD.
9. Add download/delete.
10. Add share links.

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

- Upload valid file
- File appears in dashboard
- Download returns correct file
- Deleted file disappears
- User cannot access another user's private file
- Large file gives useful error

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

Deploy frontend to Vercel. Deploy backend to Azure App Service, Render, Railway, or AWS. Use managed PostgreSQL and object storage.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- File previews
- Team folders
- Version history
- Storage quota
- Virus scanning
- Full-text file search

**What This Leads To:** Cloud engineering, SaaS platforms, storage systems.

---


## Serverless Image Processing Pipeline

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python or TypeScript  
**Core Stack:** AWS Lambda/Azure Functions, S3/Blob Storage, Queue, Next.js optional  
**Goal:** Upload images and automatically generate thumbnails/compressed versions.

### basicPlan

1. Upload image to storage bucket.
2. Trigger serverless function.
3. Resize image.
4. Save processed image.
5. Store metadata.
6. Show before/after image in UI.

### 1. Pre-Launch & Discovery

**Problem:** Apps need automatic media processing without running full servers.

**Target Users:** Developers, content platforms, e-commerce apps.

**MVP Success Criteria:**

- Image upload
- Automatic thumbnail generation
- Compression
- Metadata storage
- Processing status
- Download processed image

### 2. Planning & Design

**Main UI Screens:**

- Upload Page
- Processing Status Page
- Gallery Page
- Image Detail Page

**Core Data / Models:**

```text
ImageAsset
- id
- originalKey
- processedKey
- status
- originalSize
- processedSize
- uploadedAt
```

**Architecture:**

```text
Next.js UI optional
→ Cloud Storage Upload
→ Storage Event
→ Serverless Function
→ Processed Storage
→ Database Metadata
```

### 3. Development

**Recommended Build Order:**

1. Create storage bucket.
2. Write local image resize function.
3. Convert it to Lambda/Azure Function.
4. Add storage trigger.
5. Save processed image.
6. Add metadata table.
7. Build simple upload UI.
8. Add status polling.
9. Add README with architecture diagram.

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

- PNG upload processed
- JPG upload processed
- Non-image rejected
- Large image handled
- Processed file saved
- Metadata status updates

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

Deploy serverless function using AWS SAM/CDK, Serverless Framework, or Azure Functions Core Tools. Store secrets in cloud environment settings.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add watermarking
- Add background removal
- Add face/object detection
- Add queue retry logic
- Add CDN delivery

**What This Leads To:** Serverless architecture, event-driven systems, media platforms.

---


## Cloud Deployment Platform

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Java/Go, TypeScript  
**Core Stack:** Spring Boot/Go, Docker, Kubernetes optional, GitHub API, PostgreSQL  
**Goal:** Create a small platform that deploys GitHub projects from a dashboard.

### basicPlan

1. User connects GitHub repo manually with URL.
2. Backend clones repo.
3. Builds Docker image.
4. Runs container locally or on cloud VM.
5. Shows deployment logs.
6. Shows app URL.

### 1. Pre-Launch & Discovery

**Problem:** Developers need simple deployment workflows for small apps.

**Target Users:** Students, indie hackers, internal developer teams.

**MVP Success Criteria:**

- Add repository
- Trigger deployment
- Show build logs
- Show deployment status
- Restart deployment
- View environment variables

### 2. Planning & Design

**Main UI Screens:**

- Project Dashboard
- New Deployment Page
- Build Logs Page
- Environment Variables Page
- Deployment Detail Page

**Core Data / Models:**

```text
Project
- id
- name
- repoUrl
- ownerId

Deployment
- id
- projectId
- status
- commitHash
- logs
- createdAt

EnvironmentVariable
- id
- projectId
- key
- encryptedValue
```

**Architecture:**

```text
Next.js Frontend
→ Backend API
→ Build Worker
→ Docker Engine / Kubernetes
→ PostgreSQL
→ GitHub
```

### 3. Development

**Recommended Build Order:**

1. Build project CRUD.
2. Add repo URL input.
3. Clone repo in backend worker.
4. Run Docker build.
5. Capture build logs.
6. Run container.
7. Display deployment status.
8. Add environment variable support.
9. Add redeploy button.
10. Add documentation.

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

- Valid repo clones
- Invalid repo fails gracefully
- Build logs stream/display
- Failed build shows failure status
- Environment variables are not exposed
- Redeploy creates new deployment record

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

Start locally using Docker. Later deploy on a VM. Kubernetes is a stretch goal, not MVP.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- GitHub OAuth
- Webhook auto-deploy
- Kubernetes support
- Domains/SSL
- Rollbacks
- Team permissions

**What This Leads To:** Platform engineering, PaaS products, DevOps tooling.

---


## Cloud Cost Tracker

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python/Java, TypeScript  
**Core Stack:** FastAPI/Spring Boot, Next.js, Cloud Billing APIs, PostgreSQL  
**Goal:** Track and visualise cloud spending across services.

### basicPlan

1. User manually enters cloud expenses first.
2. Dashboard shows total cost.
3. Categorise costs by service.
4. Add monthly budget.
5. Alert when budget is near limit.

### 1. Pre-Launch & Discovery

**Problem:** Students and teams can accidentally overspend on cloud services.

**Target Users:** Students, startups, cloud learners.

**MVP Success Criteria:**

- Add cloud cost manually
- Categorise by provider/service
- Monthly dashboard
- Budget alerts
- Cost trend chart
- CSV export

### 2. Planning & Design

**Main UI Screens:**

- Cost Dashboard
- Add Cost Page
- Budget Settings
- Provider Breakdown
- Monthly Report Page

**Core Data / Models:**

```text
CloudCost
- id
- provider
- service
- amount
- currency
- billingDate

Budget
- id
- month
- limitAmount
- alertThreshold
```

**Architecture:**

```text
Next.js Frontend
→ Backend API
→ PostgreSQL
→ Optional Cloud Billing API Integrations
```

### 3. Development

**Recommended Build Order:**

1. Build cost CRUD API.
2. Add PostgreSQL schema.
3. Build dashboard cards.
4. Add charts.
5. Add budget logic.
6. Add alert message.
7. Add CSV export.
8. Add cloud API integration later.

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

- Add cost works
- Monthly total correct
- Budget alert triggers
- Invalid amount rejected
- CSV export correct
- Chart displays correct data

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

Deploy frontend on Vercel and backend on Render/Railway/Azure. Store cloud API keys securely if added.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- AWS/Azure/GCP API import
- Email alerts
- Cost forecasting
- Team budgets
- Service optimisation suggestions

**What This Leads To:** FinOps, cloud operations, SaaS analytics.

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
