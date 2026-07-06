# Level 8 Cybersecurity Projects Basic Plans

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

## Secure Password Manager

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Java or Python, TypeScript optional  
**Core Stack:** JavaFX/Spring Boot or FastAPI, AES encryption, PBKDF2/bcrypt/Argon2, SQLite/PostgreSQL  
**Goal:** Build a local or web-based encrypted password vault.

### basicPlan

Build the local MVP first:

1. Create master password.
2. Hash master password using a strong hashing method.
3. Add website credentials.
4. Encrypt saved credentials.
5. Unlock vault with master password.
6. Search credentials.
7. Export/import encrypted vault.

### 1. Pre-Launch & Discovery

**Problem:** People reuse weak passwords and need a secure way to store credentials.

**Target Users:** Students, developers, privacy-focused users.

**MVP Success Criteria:**

- User can create a vault
- User can unlock vault
- User can add credentials
- User can view saved credentials after unlock
- User can delete credentials
- Vault data is encrypted at rest

### 2. Planning & Design

**Main UI Screens:**

- Unlock Vault Screen
- Vault Dashboard
- Add Credential Form
- Credential Detail Modal
- Password Generator Page
- Settings Page

**Core Data / Models:**

```text
Vault
- id
- masterPasswordHash
- salt
- createdAt

Credential
- id
- website
- username
- encryptedPassword
- notes
- createdAt
- updatedAt
```

**Architecture:**

```text
Desktop UI or Web Frontend
→ Vault Service
→ Encryption Service
→ Local File / SQLite / PostgreSQL
```

### 3. Development

**Recommended Build Order:**

1. Create basic UI or console menu.
2. Implement master password hashing.
3. Implement AES encryption/decryption.
4. Create credential model.
5. Add create/read/update/delete credentials.
6. Store encrypted data.
7. Add password generator.
8. Add search.
9. Add auto-lock timer.
10. Write README with security notes.

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

- Wrong master password cannot unlock vault
- Correct master password unlocks vault
- Saved password is encrypted in storage
- Deleted credential disappears
- Empty website/password is rejected
- Password generator creates valid passwords

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

For safest MVP, run locally only. Package Java app as `.jar` or Python app with PyInstaller. If web-based, deploy only after adding HTTPS, secure auth, and server-side encryption rules.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add browser extension
- Add biometric unlock
- Add password breach checker
- Add encrypted cloud sync
- Add two-factor authentication
- Add audit log

**What This Leads To:** Security engineering, cryptography basics, authentication systems, privacy-focused apps.

---


## Network Scanner Dashboard

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** Python sockets/scapy/nmap wrapper, FastAPI, React/Next.js  
**Goal:** Scan your own local network and display discovered devices.

### basicPlan

Only scan networks you own or have permission to test.

1. Build a Python script that scans local IP range.
2. Detect live hosts.
3. Show IP address, hostname if available, and open common ports.
4. Store scan result.
5. Display results in a dashboard.

### 1. Pre-Launch & Discovery

**Problem:** Users often do not know what devices are connected to their network.

**Target Users:** Home lab learners, cybersecurity students, network admins.

**MVP Success Criteria:**

- User can start a local scan
- App lists discovered devices
- App shows open common ports
- App stores scan history
- App compares current scan with previous scan

### 2. Planning & Design

**Main UI Screens:**

- Dashboard: device count and latest scan
- Scan Page: start scan button and progress
- Device List Page
- Device Detail Page
- Scan History Page

**Core Data / Models:**

```text
Scan
- id
- startedAt
- completedAt
- status

Device
- id
- scanId
- ipAddress
- hostname
- macAddress
- openPorts
```

**Architecture:**

```text
React/Next.js Frontend
→ FastAPI Backend
→ Scanner Worker
→ SQLite/PostgreSQL
→ Local Network
```

### 3. Development

**Recommended Build Order:**

1. Create Python local scan script.
2. Add host discovery.
3. Add common port checking.
4. Wrap scanner in FastAPI endpoint.
5. Store scan results.
6. Build dashboard.
7. Add scan history.
8. Add comparison view.
9. Add clear legal/ethical notice in README.

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

- Scans only configured local range
- Invalid IP range rejected
- Live devices are shown
- Offline devices are not shown as live
- Scan history is saved
- UI handles long-running scan

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

Run locally first. Do not deploy public scanning functionality. If deploying dashboard, keep scanner restricted to the user's machine or private lab.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add device labels
- Add vulnerability notes manually
- Add network map visualisation
- Add scheduled scans
- Add alert when new device appears

**What This Leads To:** Network security, asset discovery, SIEM tooling, SRE observability.

---


## Secure File Sharing App

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Java, TypeScript  
**Core Stack:** Spring Boot, Next.js, PostgreSQL, AES encryption, JWT  
**Goal:** Upload encrypted files and share temporary download links.

### basicPlan

1. User uploads a file.
2. Backend encrypts the file.
3. App stores metadata.
4. User generates a share link.
5. Link expires after a set time.
6. Receiver downloads and decrypts through backend.

### 1. Pre-Launch & Discovery

**Problem:** Users need to share sensitive files with time-limited access.

**Target Users:** Students, project teams, small businesses.

**MVP Success Criteria:**

- User registration/login
- File upload
- Server-side encryption
- Share link generation
- Expiry time
- File deletion

### 2. Planning & Design

**Main UI Screens:**

- Login/Register
- File Dashboard
- Upload File Page
- Share Link Modal
- Public Download Page
- Settings Page

**Core Data / Models:**

```text
User
- id
- email
- passwordHash

FileRecord
- id
- ownerId
- originalName
- encryptedPath
- size
- createdAt

ShareLink
- id
- fileId
- token
- expiresAt
- maxDownloads
```

**Architecture:**

```text
Next.js Frontend
→ Spring Boot API
→ Encryption Service
→ File Storage
→ PostgreSQL
```

### 3. Development

**Recommended Build Order:**

1. Create Spring Boot project.
2. Add user auth with JWT.
3. Add file upload endpoint.
4. Encrypt file before storage.
5. Add file metadata table.
6. Add share token endpoint.
7. Add public download endpoint.
8. Add frontend dashboard.
9. Add expiry checks.
10. Add README and demo.

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

- Upload works
- File is not stored as plain text
- Expired link cannot download
- Invalid token rejected
- Deleted file cannot download
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

Deploy frontend to Vercel and backend to Render/Railway/Azure. Use object storage later. Never commit encryption keys.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add virus scanning
- Add download audit logs
- Add password-protected links
- Add client-side encryption
- Add team folders

**What This Leads To:** Secure SaaS platforms, cloud storage, privacy engineering.

---


## Log Analysis Security Monitor

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** FastAPI, React, SQLite/PostgreSQL, Regex, optional Elasticsearch  
**Goal:** Analyse application logs and flag suspicious patterns.

### basicPlan

1. Upload a log file.
2. Parse log lines.
3. Detect failed logins, suspicious IPs, and error spikes.
4. Show results in dashboard.
5. Export report.

### 1. Pre-Launch & Discovery

**Problem:** Security incidents often appear in logs before anyone notices them.

**Target Users:** Developers, SRE learners, cybersecurity students.

**MVP Success Criteria:**

- Upload log file
- Parse timestamps/IPs/status codes
- Detect suspicious events
- Dashboard with alerts
- Export findings

### 2. Planning & Design

**Main UI Screens:**

- Upload Logs Page
- Alerts Dashboard
- IP Detail Page
- Timeline Page
- Export Report Page

**Core Data / Models:**

```text
LogFile
- id
- filename
- uploadedAt

LogEvent
- id
- logFileId
- timestamp
- ipAddress
- eventType
- severity
- message

Alert
- id
- eventId
- ruleName
- severity
```

**Architecture:**

```text
React Frontend
→ FastAPI Parser API
→ Rule Engine
→ Database
→ Report Generator
```

### 3. Development

**Recommended Build Order:**

1. Define supported log format.
2. Build parser.
3. Add upload endpoint.
4. Store parsed events.
5. Implement simple detection rules.
6. Build alerts dashboard.
7. Add filtering/search.
8. Add export as Markdown/CSV.
9. Add sample logs.

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

- Valid log file parses correctly
- Invalid log lines do not crash parser
- Failed login rule triggers
- Error spike rule triggers
- Export includes detected alerts

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

Deploy as internal tool. Frontend on Vercel, backend on Render/Railway. For real logs, avoid uploading private production data.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add `.env.example`
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add custom rules
- Add real-time log streaming
- Add Elasticsearch
- Add Slack/email alerts
- Add ML anomaly detection

**What This Leads To:** SIEM systems, observability, incident response, DevSecOps.

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
