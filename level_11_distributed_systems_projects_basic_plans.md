# Level 11 Distributed Systems Projects Basic Plans

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

## Scalable URL Shortener

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Java, TypeScript  
**Core Stack:** Spring Boot, Next.js, PostgreSQL, Redis, Kafka optional  
**Goal:** Build a production-style URL shortener with analytics.

### basicPlan

1. Create short code from long URL.
2. Store mapping in PostgreSQL.
3. Redirect short URL to original URL.
4. Track click count.
5. Add Redis cache.
6. Add analytics dashboard.

### 1. Pre-Launch & Discovery

**Problem:** Users need short links and analytics for sharing URLs.

**Target Users:** Marketers, developers, students, teams.

**MVP Success Criteria:**

- Create short URL
- Redirect to original URL
- Custom alias optional
- Expiry date
- Click tracking
- Analytics dashboard

### 2. Planning & Design

**Main UI Screens:**

- Create Link Page
- Link Dashboard
- Link Detail Analytics
- Settings Page

**Core Data / Models:**

```text
ShortUrl
- id
- originalUrl
- shortCode
- createdBy
- createdAt
- expiresAt

ClickEvent
- id
- shortUrlId
- ipHash
- userAgent
- referrer
- clickedAt
```

**Architecture:**

```text
Next.js Frontend
→ Spring Boot API
→ PostgreSQL
→ Redis Cache
→ Kafka/Worker for Click Analytics optional
```

### 3. Development

**Recommended Build Order:**

1. Build URL model and API.
2. Generate unique short codes.
3. Add redirect endpoint.
4. Add click count.
5. Build frontend form.
6. Add user dashboard.
7. Add Redis caching.
8. Add analytics events.
9. Add rate limiting.
10. Load test redirects.

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

- Short URL created
- Redirect works
- Invalid short code returns 404
- Expired URL blocked
- Click count increments
- Redis cache returns correct URL

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

Deploy backend to cloud, frontend to Vercel, database managed PostgreSQL, Redis managed or Docker. Use a custom domain later.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- QR code generation
- Geographic analytics
- Abuse detection
- Team workspaces
- Public API
- Horizontal scaling

**What This Leads To:** System design, high-traffic services, backend engineering.

---


## Distributed Chat System

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Java/Go, TypeScript  
**Core Stack:** Spring Boot/Go, WebSockets, Redis Pub/Sub, PostgreSQL, Next.js  
**Goal:** Create real-time chat that can scale across multiple backend instances.

### basicPlan

1. Create chat rooms.
2. Connect users via WebSocket.
3. Send/receive messages.
4. Store messages.
5. Add Redis Pub/Sub so multiple server instances share messages.

### 1. Pre-Launch & Discovery

**Problem:** Real-time messaging must work even when users connect to different servers.

**Target Users:** Teams, communities, students.

**MVP Success Criteria:**

- User login
- Create/join room
- Send real-time messages
- Message history
- Online user list
- Multi-instance message sync

### 2. Planning & Design

**Main UI Screens:**

- Login Page
- Rooms List
- Chat Room
- Online Users Panel
- Message History

**Core Data / Models:**

```text
User
- id
- username

Room
- id
- name

Message
- id
- roomId
- senderId
- content
- createdAt
```

**Architecture:**

```text
Next.js Frontend
→ WebSocket Backend Instance A/B
→ Redis Pub/Sub
→ PostgreSQL Message Store
```

### 3. Development

**Recommended Build Order:**

1. Build auth or simple username login.
2. Add room CRUD.
3. Add WebSocket connection.
4. Broadcast messages in one instance.
5. Store messages.
6. Add Redis Pub/Sub.
7. Test with two backend instances.
8. Add typing indicator.
9. Add online presence.

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

- User can join room
- Message appears instantly
- History loads
- Two browser clients sync
- Two backend instances sync through Redis
- Disconnected user handled

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

Deploy backend instances with Docker Compose first. Use Redis and PostgreSQL containers locally. Later deploy to cloud.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Private messages
- File uploads
- End-to-end encryption
- Push notifications
- Moderation tools

**What This Leads To:** Real-time systems, WebSocket scaling, collaboration platforms.

---


## Distributed Task Queue

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Python/Java/Go  
**Core Stack:** FastAPI/Spring Boot, Redis/RabbitMQ, PostgreSQL, Worker Processes  
**Goal:** Build a mini Celery-like system for background jobs.

### basicPlan

1. API receives a job request.
2. Job is pushed to queue.
3. Worker pulls job.
4. Worker processes job.
5. Job status is stored.
6. User checks job status.

### 1. Pre-Launch & Discovery

**Problem:** Apps need to run slow tasks outside the main request-response flow.

**Target Users:** Developers, backend learners, platform teams.

**MVP Success Criteria:**

- Submit job
- Queue job
- Worker execution
- Job status tracking
- Retry failed jobs
- View job logs

### 2. Planning & Design

**Main UI Screens:**

- Submit Job Page
- Jobs Dashboard
- Job Detail Page
- Worker Status Page optional

**Core Data / Models:**

```text
Job
- id
- type
- payload
- status
- attempts
- result
- error
- createdAt
- completedAt

Worker
- id
- status
- lastHeartbeat
```

**Architecture:**

```text
Client/UI
→ API Server
→ Queue Broker
→ Worker Process
→ PostgreSQL Status Store
```

### 3. Development

**Recommended Build Order:**

1. Build job API.
2. Add job table.
3. Push job to Redis/RabbitMQ.
4. Build worker process.
5. Update job status.
6. Add retries.
7. Add job dashboard.
8. Add logs.
9. Add multiple workers.

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

- Job submitted successfully
- Worker processes job
- Status changes pending → running → completed
- Failed job retries
- Multiple workers do not process same job twice
- Invalid payload rejected

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

Run locally using Docker Compose with API, worker, database, and queue. Later deploy worker separately from API.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Scheduled jobs
- Priority queues
- Dead-letter queue
- Worker autoscaling
- Metrics dashboard

**What This Leads To:** Distributed systems, async processing, platform engineering.

---


## Distributed File Sync Prototype

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Java/Go/Python, TypeScript optional  
**Core Stack:** Spring Boot/Go/FastAPI, WebSockets/gRPC, PostgreSQL, local filesystem  
**Goal:** Sync files between two clients through a central server.

### basicPlan

1. Watch local folder for changes.
2. Upload changed file metadata to server.
3. Upload changed file content.
4. Another client downloads update.
5. Handle simple conflicts by keeping both versions.

### 1. Pre-Launch & Discovery

**Problem:** File sync systems must detect changes, resolve conflicts, and transfer efficiently.

**Target Users:** Developers, distributed systems learners.

**MVP Success Criteria:**

- Folder watcher
- File upload/download
- Change detection
- Sync status
- Conflict handling
- Version history basic

### 2. Planning & Design

**Main UI Screens:**

- Desktop/CLI Client Status
- Synced Files List
- Conflict List
- Server Dashboard optional

**Core Data / Models:**

```text
FileRecord
- id
- path
- hash
- version
- updatedAt

SyncClient
- id
- name
- lastSeen

FileVersion
- id
- fileId
- version
- storagePath
- hash
```

**Architecture:**

```text
Client A Folder Watcher
→ Sync Server
→ File Storage + PostgreSQL
→ Client B Poll/WebSocket Download
```

### 3. Development

**Recommended Build Order:**

1. Build folder watcher.
2. Calculate file hash.
3. Create server metadata API.
4. Upload file changes.
5. Store file versions.
6. Build second client download sync.
7. Add conflict detection.
8. Add sync logs.
9. Add README with diagrams.

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

- New file syncs to server
- Updated file creates new version
- Deleted file handled
- Two clients sync same file
- Conflict creates duplicate/conflict version
- Large file handled safely

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

Start locally with two folders on one machine. Later test across two devices on same network. Avoid syncing sensitive files.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Delta sync
- Peer-to-peer sync
- Encryption
- Offline queue
- Desktop UI
- Selective sync

**What This Leads To:** Dropbox-style systems, consistency models, distributed storage.

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
