# Level 5 AI Projects Basic Plans

These plans are written so you can start coding immediately while still following a professional app-planning structure.

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

## AI PDF Study Assistant

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** Next.js, FastAPI, LangChain/LlamaIndex, ChromaDB, PostgreSQL  
**Goal:** Upload PDFs and ask questions about them with source-based answers.

### basicPlan

Build the smallest version first:

1. Create a Next.js upload page.
2. Send PDF to FastAPI.
3. Extract text using PyMuPDF.
4. Split text into chunks.
5. Store chunks in ChromaDB.
6. Let user ask questions.
7. Retrieve relevant chunks.
8. Send chunks to an LLM.
9. Display answer and source snippets.

### 1. Pre-Launch & Discovery

**Problem:** Students have many notes, slides, and PDFs but struggle to revise from them quickly.

**Target Users:** Students, self-learners, researchers, bootcamp learners.

**MVP Success Criteria:**

- User can upload a PDF
- User can ask a question
- App returns an answer
- App shows source text used
- User can view uploaded documents
- User can delete a document

### 2. Planning & Design

**Main UI Screens:**

- Dashboard: uploaded PDFs
- Upload Page: drag-and-drop PDF upload
- Chat Page: question-answer interface
- Sources Panel: source snippets used by AI
- Document Detail Page: extracted text preview

**Core Data / Models:**

```text
Document
- id
- filename
- uploadedAt
- status

Chunk
- id
- documentId
- text
- pageNumber
- embeddingId

ChatMessage
- id
- documentId
- role
- content
- createdAt
```

**Architecture:**

```text
Frontend
→ Backend API
→ Database / AI Service / Device Layer
→ External APIs or Models
```

### 3. Development

**Recommended Build Order:**

1. Build static frontend screens.
2. Create FastAPI backend.
3. Add PDF upload endpoint.
4. Extract text from PDF.
5. Add chunking function.
6. Add vector database.
7. Add question-answer endpoint.
8. Connect frontend chat to backend.
9. Add loading/error states.
10. Add README and demo data.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Upload valid PDF → document is stored
- Upload non-PDF → error shown
- Ask question before upload → blocked
- Ask relevant question → answer uses document text
- Delete document → document removed
- Large PDF → app does not crash

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Deploy frontend on Vercel. Deploy FastAPI backend on Render, Railway, Fly.io, or Azure App Service. Use environment variables for API keys.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Add flashcard generation
- Add quiz generation
- Add multi-document chat
- Add user login
- Add citation links to exact pages
- Add local open-source model support

**What This Leads To:** AI Research Assistant, Personal Knowledge Brain, enterprise RAG systems.

---


## AI Resume Reviewer

**Difficulty:** ⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** Next.js, FastAPI, LLM API, PostgreSQL optional  
**Goal:** Upload a CV and receive feedback, score, and improvement suggestions.

### basicPlan

1. Build upload form.
2. Extract text from PDF/DOCX.
3. Send text to AI reviewer prompt.
4. Return score, strengths, weaknesses, and rewrite suggestions.
5. Add export-to-Markdown option.

### 1. Pre-Launch & Discovery

**Problem:** Students struggle to know whether their CV is good enough for internships.

**Target Users:** Students, graduates, career changers.

**MVP Success Criteria:**

- Upload CV
- Paste job description
- Get CV score
- Get missing keywords
- Get bullet-point improvements
- Generate improved summary section

### 2. Planning & Design

**Main UI Screens:**

- Home Page: explain tool
- Upload Page: CV + job description
- Results Page: score, feedback, rewritten bullets
- History Page: previous reviews optional

**Core Data / Models:**

```text
ResumeReview
- id
- filename
- jobDescription
- score
- feedback
- createdAt
```

**Architecture:**

```text
Frontend
→ Backend API
→ Database / AI Service / Device Layer
→ External APIs or Models
```

### 3. Development

**Recommended Build Order:**

1. Build CV upload UI.
2. Add backend file parser.
3. Create AI feedback prompt.
4. Return structured JSON feedback.
5. Display feedback in cards.
6. Add copy buttons.
7. Add export result as Markdown.
8. Add README and sample CV.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Valid CV uploads successfully
- Empty CV gives error
- Job description improves keyword feedback
- AI response displays correctly
- Long CV does not break UI

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Deploy Next.js to Vercel and FastAPI to Render/Railway. Keep AI key in backend environment variables only.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Add ATS keyword checker
- Add LinkedIn profile review
- Add cover letter generator
- Add version comparison
- Add authentication

**What This Leads To:** Career tools, HR-tech apps, document AI systems.

---


## AI Meeting Summariser

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** Next.js, FastAPI, Whisper/OpenAI, PostgreSQL  
**Goal:** Upload meeting audio and generate transcript, summary, decisions, and action items.

### basicPlan

1. Upload audio file.
2. Transcribe audio.
3. Summarise transcript.
4. Extract action items.
5. Display transcript and summary.

### 1. Pre-Launch & Discovery

**Problem:** People forget what was discussed in meetings and miss action items.

**Target Users:** Students, project teams, hackathon teams, professionals.

**MVP Success Criteria:**

- Upload audio
- Generate transcript
- Generate summary
- Extract action items
- Identify decisions
- Export notes

### 2. Planning & Design

**Main UI Screens:**

- Upload Page: audio upload
- Processing Page: status indicator
- Summary Page: summary, actions, decisions
- Transcript Page: full transcript
- Export Button: Markdown/PDF later

**Core Data / Models:**

```text
Meeting
- id
- title
- audioFilename
- transcript
- summary
- createdAt

ActionItem
- id
- meetingId
- task
- owner
- dueDate
- status
```

**Architecture:**

```text
Frontend
→ Backend API
→ Database / AI Service / Device Layer
→ External APIs or Models
```

### 3. Development

**Recommended Build Order:**

1. Build upload page.
2. Add audio upload endpoint.
3. Add transcription service.
4. Add summary prompt.
5. Parse action items into structured data.
6. Build results page.
7. Add export to Markdown.
8. Add sample audio and README.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Upload MP3/WAV works
- Unsupported file type rejected
- Transcript generated
- Summary generated
- Empty/quiet audio handled
- Export works

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Frontend on Vercel. Backend on cloud VM or Render/Railway. For large files, consider object storage later.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Speaker diarisation
- Calendar integration
- Email action items
- Search across meetings
- Team workspace

**What This Leads To:** Productivity SaaS, AI assistant tools, workplace automation.

---


## AI Code Reviewer

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, TypeScript, Java optional  
**Core Stack:** Next.js, FastAPI, GitHub API, LLM API  
**Goal:** Paste code or connect a GitHub file and get review comments.

### basicPlan

1. Create code input box.
2. Select language.
3. Send code to backend.
4. AI returns bugs, style issues, security concerns, and improvements.
5. Display comments grouped by category.

### 1. Pre-Launch & Discovery

**Problem:** Beginner developers need feedback before submitting code.

**Target Users:** Students, junior developers, hackathon teams.

**MVP Success Criteria:**

- Paste code
- Select programming language
- Get review comments
- Get improved version
- Get explanation of bugs
- Copy fixed code

### 2. Planning & Design

**Main UI Screens:**

- Code Input Page
- Review Results Page
- Category Filters: Bugs, Style, Security, Performance
- Fixed Code Panel

**Core Data / Models:**

```text
CodeReview
- id
- language
- originalCode
- feedback
- improvedCode
- createdAt
```

**Architecture:**

```text
Frontend
→ Backend API
→ Database / AI Service / Device Layer
→ External APIs or Models
```

### 3. Development

**Recommended Build Order:**

1. Build code editor UI using Monaco Editor.
2. Add backend review endpoint.
3. Create structured review prompt.
4. Display feedback as cards.
5. Add fixed-code output.
6. Add language selector.
7. Add GitHub file import later.
8. Add README.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Java code reviewed correctly
- JavaScript code reviewed correctly
- Empty code rejected
- Very long code handled safely
- Feedback categories display correctly

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Deploy frontend to Vercel and backend to Render/Railway. Keep LLM calls server-side.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- GitHub PR review integration
- Test generation
- Security scan mode
- Architecture explanation
- VS Code extension

**What This Leads To:** AI Developer OS, coding assistant, developer tools.

---


## AI Flashcard Generator

**Difficulty:** ⭐⭐⭐  
**Languages:** Python, TypeScript  
**Core Stack:** Next.js, FastAPI, LLM API, PostgreSQL optional  
**Goal:** Generate revision flashcards from pasted notes or uploaded text.

### basicPlan

1. Paste notes.
2. Click generate.
3. AI returns question-answer flashcards.
4. Display cards with flip animation.
5. Save cards locally or in database.

### 1. Pre-Launch & Discovery

**Problem:** Creating flashcards manually takes time.

**Target Users:** Students and self-learners.

**MVP Success Criteria:**

- Paste notes
- Generate flashcards
- Flip cards
- Mark known/unknown
- Export flashcards as CSV/Markdown

### 2. Planning & Design

**Main UI Screens:**

- Notes Input Page
- Flashcard Deck Page
- Study Mode
- Export Page optional

**Core Data / Models:**

```text
Deck
- id
- title
- createdAt

Flashcard
- id
- deckId
- front
- back
- status
```

**Architecture:**

```text
Frontend
→ Backend API
→ Database / AI Service / Device Layer
→ External APIs or Models
```

### 3. Development

**Recommended Build Order:**

1. Build notes input.
2. Create generate endpoint.
3. Prompt AI for structured flashcards.
4. Render flashcard deck.
5. Add known/unknown buttons.
6. Add export.
7. Add local persistence.

**Suggested Folder Structure:**

```text
project-name/
├── frontend/
├── backend/
├── docs/
├── tests/
└── README.md
```

### 4. Testing & Quality Assurance

**Manual Tests:**

- Empty notes rejected
- Notes generate correct JSON
- Flashcards flip correctly
- Export contains all cards
- Known/unknown status updates

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Vercel for frontend. Render/Railway for backend. Optional Supabase/PostgreSQL for saved decks.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Spaced repetition
- Quiz mode
- PDF upload
- User accounts
- Shared decks

**What This Leads To:** AI tutor, study platform, learning analytics.

---

# Recommended Build Strategy

For each level:

1. Build the `basicPlan` version first.
2. Push the first working version to GitHub.
3. Add one stretch feature.
4. Write what you learned in the README.
5. Record a 60-90 second demo video.

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

## How To Run
Step-by-step setup instructions.

## Screenshots / Demo
Add images or video link.

## What I Learned
Explain the technical skills gained.

## Future Improvements
List next features.
```
