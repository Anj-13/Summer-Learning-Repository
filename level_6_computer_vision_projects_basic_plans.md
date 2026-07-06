# Level 6 Computer Vision Projects Basic Plans

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

## Hand Gesture Computer Controller

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python  
**Core Stack:** OpenCV, MediaPipe, PyAutoGUI, Tkinter/PyQt optional  
**Goal:** Control the computer using webcam hand gestures.

### basicPlan

1. Open webcam.
2. Detect hand landmarks with MediaPipe.
3. Recognise simple gestures.
4. Map gestures to actions.
5. Show live camera overlay.
6. Add a settings file for gesture-action mapping.

### 1. Pre-Launch & Discovery

**Problem:** Gesture interfaces are visual, fun, and teach real computer vision fundamentals.

**Target Users:** Students, accessibility users, demo audiences, makers.

**MVP Success Criteria:**

- Detect one hand
- Detect pinch
- Detect open palm
- Detect swipe left/right
- Move cursor
- Click using pinch
- Pause/play media
- Show gesture label on screen

### 2. Planning & Design

**Main UI Screens:**

- Live Camera Window
- Gesture Label Overlay
- Simple Settings Screen optional
- Debug Panel showing coordinates and confidence

**Core Data / Models:**

```text
Gesture
- name
- requiredLandmarks
- confidence
- action

Action
- name
- keyboardShortcut
- enabled
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

1. Set up OpenCV webcam feed.
2. Add MediaPipe hand tracking.
3. Draw landmarks on screen.
4. Implement pinch detection.
5. Implement swipe detection.
6. Connect PyAutoGUI actions.
7. Add cooldown to avoid repeated triggers.
8. Add config file for mappings.
9. Package and record demo.

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

- Webcam starts
- Hand landmarks appear
- Pinch triggers click once
- Swipe does not trigger repeatedly
- No hand detected does nothing
- App exits safely

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Package locally with PyInstaller. Upload code to GitHub with setup instructions and a demo GIF/video.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Add custom gestures
- Add two-hand gestures
- Add volume control
- Add virtual keyboard
- Add Electron desktop UI
- Add accessibility mode

**What This Leads To:** AR interfaces, sign language translator, gesture OS, HCI projects.

---


## Virtual Air Drawing App

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python  
**Core Stack:** OpenCV, MediaPipe, NumPy  
**Goal:** Draw in the air using finger tracking.

### basicPlan

1. Track index finger.
2. Use finger tip as brush.
3. Draw lines on canvas.
4. Add clear gesture.
5. Add colour switching with gestures.

### 1. Pre-Launch & Discovery

**Problem:** Air drawing is a strong beginner-friendly computer vision project with visual output.

**Target Users:** Students, presenters, creative users.

**MVP Success Criteria:**

- Draw with index finger
- Clear canvas
- Change colour
- Change brush size
- Save drawing as image
- Show camera feed and drawing overlay

### 2. Planning & Design

**Main UI Screens:**

- Camera Feed
- Drawing Canvas Overlay
- Toolbar with colours
- Save/Clear controls

**Core Data / Models:**

```text
DrawingSession
- canvasImage
- selectedColour
- brushSize
- lastPoint
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

1. Open webcam.
2. Track hand landmarks.
3. Identify index fingertip coordinate.
4. Draw line between previous and current point.
5. Add clear gesture.
6. Add colour buttons on screen.
7. Add save image function.
8. Add README and demo.

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

- Drawing follows finger
- No random lines when hand disappears
- Clear works
- Colour changes correctly
- Saved image opens correctly

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Run locally as Python app. Package with PyInstaller later.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Shape recognition
- Whiteboard mode
- Presentation annotation
- Multiplayer drawing
- AI sketch recognition

**What This Leads To:** AR whiteboard, educational tools, creative CV apps.

---


## AI Fitness Pose Coach

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, TypeScript optional  
**Core Stack:** OpenCV, MediaPipe Pose, FastAPI optional, React optional  
**Goal:** Analyse exercise form using pose estimation.

### basicPlan

1. Track body pose.
2. Calculate joint angles.
3. Detect squat or push-up reps.
4. Count reps.
5. Give simple form feedback.

### 1. Pre-Launch & Discovery

**Problem:** People exercise with poor form and risk injury.

**Target Users:** Gym beginners, students, fitness enthusiasts.

**MVP Success Criteria:**

- Detect human pose
- Count reps
- Calculate knee/elbow angles
- Give feedback like “go lower”
- Show skeleton overlay
- Save session summary

### 2. Planning & Design

**Main UI Screens:**

- Live Camera View
- Rep Counter
- Form Feedback Text
- Session Summary Page optional

**Core Data / Models:**

```text
WorkoutSession
- id
- exerciseType
- repCount
- feedback
- duration

PoseFrame
- timestamp
- jointAngles
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

1. Set up webcam.
2. Add MediaPipe Pose.
3. Draw skeleton overlay.
4. Calculate joint angles.
5. Implement squat counter.
6. Add feedback rules.
7. Add session summary.
8. Record demo video.

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

- Pose detected correctly
- Rep count increases once per rep
- Bad form shows warning
- No person detected handled
- Session summary accurate

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Run locally. Optional web dashboard can be deployed on Vercel with FastAPI backend.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Add push-ups/lunges
- Add voice feedback
- Add progress tracking
- Add mobile version
- Add AI-generated workout plan

**What This Leads To:** Health tech, pose analysis, sports analytics.

---


## Sign Language Alphabet Recogniser

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Python  
**Core Stack:** OpenCV, MediaPipe, TensorFlow/PyTorch, scikit-learn  
**Goal:** Recognise hand signs for letters or simple words.

### basicPlan

1. Collect hand landmark data for 5-10 letters.
2. Train a small classifier.
3. Run webcam inference.
4. Show predicted letter.
5. Add confidence score.

### 1. Pre-Launch & Discovery

**Problem:** Sign language recognition can support accessibility and communication.

**Target Users:** Learners, accessibility researchers, demo users.

**MVP Success Criteria:**

- Collect training samples
- Train model
- Predict sign from webcam
- Show confidence
- Save model
- Add simple word builder

### 2. Planning & Design

**Main UI Screens:**

- Data Collection Screen
- Training Script Output
- Live Prediction Window
- Word Builder Panel

**Core Data / Models:**

```text
Sample
- label
- landmarks[21]
- createdAt

Model
- version
- labels
- accuracy
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

1. Build landmark extraction.
2. Create data collection script.
3. Collect samples for each sign.
4. Train classifier.
5. Save model.
6. Build live inference script.
7. Add confidence display.
8. Add README with dataset instructions.

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

- Samples saved with correct labels
- Model trains successfully
- Prediction works for known signs
- Unknown/uncertain signs handled
- Accuracy measured on test split

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Run locally. Share trained model file only if small. Add demo video to README.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- More letters
- Word recognition
- Sentence builder
- Deep learning sequence model
- Accessibility web app

**What This Leads To:** Accessibility AI, gesture recognition, human-computer interaction.

---


## Smart Attendance Face Detection System

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, TypeScript optional  
**Core Stack:** OpenCV, face-recognition/deepface, FastAPI, PostgreSQL optional  
**Goal:** Detect faces and mark attendance automatically.

### basicPlan

1. Register users with face images.
2. Open webcam.
3. Detect and recognise faces.
4. Mark attendance with timestamp.
5. Export attendance as CSV.

### 1. Pre-Launch & Discovery

**Problem:** Manual attendance is slow and error-prone.

**Target Users:** Classrooms, clubs, teams, hackathon groups.

**MVP Success Criteria:**

- Register person
- Detect face
- Recognise known person
- Mark attendance
- Prevent duplicate attendance
- Export CSV

### 2. Planning & Design

**Main UI Screens:**

- Register Person Screen
- Live Camera Attendance Screen
- Attendance Table
- Export Button

**Core Data / Models:**

```text
Person
- id
- name
- faceEncoding

Attendance
- id
- personId
- timestamp
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

1. Build face registration script.
2. Store face encodings.
3. Build webcam recognition.
4. Add attendance record storage.
5. Prevent duplicates per session/day.
6. Add CSV export.
7. Optional FastAPI dashboard.

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

- Known face recognised
- Unknown face ignored
- Duplicate not counted twice
- CSV exports correct data
- Poor lighting handled gracefully

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Run locally for privacy. Optional local network dashboard. Avoid uploading face data publicly.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Admin dashboard
- Class groups
- Liveness detection
- Privacy consent workflow
- Cloud-free local mode

**What This Leads To:** Computer vision systems, identity apps, edge AI.

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
