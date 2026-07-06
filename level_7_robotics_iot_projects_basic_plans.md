# Level 7 Robotics and IoT Projects Basic Plans

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

## Smart Room Assistant

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, JavaScript/TypeScript  
**Core Stack:** Raspberry Pi/ESP32, MQTT, FastAPI/Spring Boot, React, PostgreSQL/InfluxDB  
**Goal:** Monitor room sensors and control devices from a dashboard.

### basicPlan

1. Read temperature sensor.
2. Send data using MQTT.
3. Store readings in backend.
4. Show live dashboard.
5. Add LED/light control.

### 1. Pre-Launch & Discovery

**Problem:** Rooms waste energy and users lack visibility into environment data.

**Target Users:** Students, makers, smart home learners.

**MVP Success Criteria:**

- Read temperature/humidity
- Detect motion
- Control LED or relay
- Show live dashboard
- Store sensor history
- Trigger alerts

### 2. Planning & Design

**Main UI Screens:**

- Dashboard with live sensor cards
- Device Control Page
- Alerts Page
- Analytics Chart Page

**Core Data / Models:**

```text
SensorReading
- id
- sensorType
- value
- unit
- timestamp

Device
- id
- name
- status

Alert
- id
- type
- message
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

1. Set up ESP32/Raspberry Pi.
2. Read one sensor locally.
3. Publish sensor data to MQTT.
4. Build backend subscriber.
5. Store data.
6. Build React dashboard.
7. Add device control command.
8. Add alerts and charts.

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

- Sensor sends data
- MQTT receives data
- Dashboard updates
- Device turns on/off
- Bad sensor values handled
- Backend reconnects after disconnect

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Run device locally. Deploy dashboard/backend on local network first. Later deploy backend to cloud and secure device credentials.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Add more sensors
- Add automation rules
- Add energy usage prediction
- Add mobile notifications
- Add voice assistant

**What This Leads To:** Smart campus, IoT platforms, home automation, edge systems.

---


## Raspberry Pi Security Camera

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python, TypeScript optional  
**Core Stack:** Raspberry Pi Camera/OpenCV, FastAPI, React, SQLite/PostgreSQL  
**Goal:** Create a motion-detection security camera with alerts.

### basicPlan

1. Stream camera.
2. Detect motion.
3. Save snapshot when motion occurs.
4. Show events in dashboard.
5. Add email/Telegram alert later.

### 1. Pre-Launch & Discovery

**Problem:** Users need low-cost monitoring for rooms or equipment.

**Target Users:** Students, makers, home lab users.

**MVP Success Criteria:**

- Live camera stream
- Motion detection
- Save snapshots
- Event log
- Alert when motion detected
- Delete old snapshots

### 2. Planning & Design

**Main UI Screens:**

- Live Feed Page
- Motion Events Page
- Snapshot Viewer
- Settings Page

**Core Data / Models:**

```text
MotionEvent
- id
- snapshotPath
- timestamp
- confidence
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

1. Connect camera.
2. Capture frames.
3. Add motion detection.
4. Save snapshot on motion.
5. Create FastAPI endpoint for stream/events.
6. Build dashboard.
7. Add alert integration.
8. Add cleanup script.

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

- Camera starts correctly
- Motion is detected
- No motion does not spam events
- Snapshot saved
- Dashboard loads events
- Alerts do not duplicate excessively

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Run on Raspberry Pi. Access dashboard locally. Use secure tunnelling only after adding authentication.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Face detection
- Object detection
- Cloud backup
- Night mode
- Mobile notifications

**What This Leads To:** Edge AI cameras, smart security, computer vision IoT.

---


## IoT Plant Care Monitor

**Difficulty:** ⭐⭐⭐  
**Languages:** Python/MicroPython, TypeScript  
**Core Stack:** ESP32, soil moisture sensor, MQTT, React, FastAPI  
**Goal:** Monitor plant health and remind user to water plants.

### basicPlan

1. Read soil moisture.
2. Send data to backend.
3. Display plant status.
4. Alert when soil is dry.
5. Log watering events.

### 1. Pre-Launch & Discovery

**Problem:** People forget to water plants or overwater them.

**Target Users:** Students, home users, makers.

**MVP Success Criteria:**

- Soil moisture monitoring
- Temperature optional
- Plant status dashboard
- Watering reminders
- History chart
- Manual watering log

### 2. Planning & Design

**Main UI Screens:**

- Plant Dashboard
- Sensor History
- Alert Page
- Plant Settings

**Core Data / Models:**

```text
Plant
- id
- name
- moistureThreshold

Reading
- id
- plantId
- moisture
- timestamp

WateringEvent
- id
- plantId
- timestamp
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

1. Wire soil moisture sensor.
2. Read sensor values.
3. Publish values via MQTT/HTTP.
4. Build backend storage.
5. Build dashboard cards.
6. Add threshold alerts.
7. Add watering log.
8. Add chart.

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

- Sensor reads values
- Dry soil triggers alert
- Wet soil clears alert
- Readings stored correctly
- Dashboard updates

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Run device locally. Deploy dashboard on Vercel and backend on Render/Railway if needed.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Auto-watering pump
- Multiple plants
- Light sensor
- AI watering recommendations
- Mobile alerts

**What This Leads To:** Agritech, IoT dashboards, automation systems.

---


## Mini Robot Obstacle Avoider

**Difficulty:** ⭐⭐⭐⭐  
**Languages:** Python/C++/MicroPython  
**Core Stack:** Arduino/ESP32/Raspberry Pi, ultrasonic sensor, motor driver  
**Goal:** Build a robot that avoids obstacles automatically.

### basicPlan

1. Build robot chassis.
2. Read ultrasonic distance.
3. Move forward if clear.
4. Stop and turn if obstacle detected.
5. Tune movement rules.

### 1. Pre-Launch & Discovery

**Problem:** Robotics teaches sensors, control, and real-world debugging.

**Target Users:** Students, robotics beginners, makers.

**MVP Success Criteria:**

- Forward movement
- Distance sensing
- Stop on obstacle
- Turn left/right
- Basic autonomous navigation
- Debug serial output

### 2. Planning & Design

**Main UI Screens:**

- No UI required for MVP
- Optional web dashboard showing distance and mode
- Optional controller page

**Core Data / Models:**

```text
RobotState
- distance
- motorLeftSpeed
- motorRightSpeed
- mode
- timestamp
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

1. Assemble chassis.
2. Test motors.
3. Test distance sensor.
4. Write movement functions.
5. Add obstacle avoidance logic.
6. Tune thresholds.
7. Add battery-safe behaviour.
8. Record demo.

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

- Motors spin correctly
- Distance readings are stable
- Robot stops near obstacle
- Robot turns successfully
- Robot does not crash into objects repeatedly

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Upload firmware/code to device. Document wiring diagram and parts list in README.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Add line following
- Add camera
- Add remote control
- Add mapping
- Add ROS later

**What This Leads To:** Autonomous robots, ROS, drone systems, embedded engineering.

---


## Smart Campus Room Occupancy Prototype

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Python, TypeScript, Java optional  
**Core Stack:** ESP32/Raspberry Pi, PIR sensors/camera, MQTT, Spring Boot/FastAPI, React  
**Goal:** Prototype a system that estimates whether study rooms are occupied.

### basicPlan

1. Use motion sensor to detect room activity.
2. Send occupancy events to backend.
3. Show room status on dashboard.
4. Add historical occupancy chart.
5. Add simple prediction later.

### 1. Pre-Launch & Discovery

**Problem:** Students waste time searching for free study spaces.

**Target Users:** Students, university staff, campus services.

**MVP Success Criteria:**

- Room status: free/busy/unknown
- Sensor event ingestion
- Live dashboard
- Room list
- Occupancy history
- Admin room setup

### 2. Planning & Design

**Main UI Screens:**

- Campus Dashboard
- Room Detail Page
- Sensor Status Page
- Analytics Page

**Core Data / Models:**

```text
Room
- id
- name
- location
- capacity

OccupancyEvent
- id
- roomId
- status
- confidence
- timestamp

Sensor
- id
- roomId
- type
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

1. Define room model.
2. Simulate sensor data first.
3. Build backend event API.
4. Build dashboard.
5. Connect real sensor via MQTT.
6. Add room status logic.
7. Add historical chart.
8. Add prediction stretch goal.

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

- Simulated sensor events update room status
- Real sensor sends events
- Dashboard shows correct status
- Offline sensor shows unknown
- History chart works

**Quality Checklist:**

- Handles invalid input
- Has clear error messages
- Has loading states where needed
- Has a README
- Has screenshots or demo video
- Code is organised into reusable components/classes
- No secrets or API keys committed to GitHub

### 5. Deployment & Launch

Start with local deployment. Later deploy backend/cloud dashboard and keep sensors authenticated.

**Launch Checklist:**

- Push code to GitHub
- Write README
- Add setup instructions
- Add environment variable examples
- Record short demo video
- Add future roadmap

### 6. Post-Launch

- Add indoor maps
- Add prediction model
- Add QR room feedback
- Add timetable integration
- Add privacy-friendly camera counting

**What This Leads To:** Smart campus platform, IoT analytics, final-year project.

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
