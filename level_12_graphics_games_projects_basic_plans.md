# Level 12 Graphics and Games Projects Basic Plans

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

## 2D Physics Game Engine

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Java or C++  
**Core Stack:** Java LibGDX/JavaFX or C++ SDL2, basic physics, collision detection  
**Goal:** Build a small reusable 2D engine with rendering, input, collision, and physics.

### basicPlan

1. Open a window.
2. Render a player rectangle/sprite.
3. Move the player with keyboard input.
4. Add gravity.
5. Add platforms.
6. Detect collisions.
7. Add a simple level.
8. Add debug overlay with FPS and position.

### 1. Pre-Launch & Discovery

**Problem:** Most beginners use engines, but building a mini engine teaches game loops, maths, rendering, and architecture.

**Target Users:** Game development learners, CS students, graphics learners.

**MVP Success Criteria:**

- Game window runs at stable FPS
- Player can move and jump
- Gravity affects player
- Platforms block movement
- Collision detection works
- Level can be restarted
- Debug overlay displays FPS and coordinates

### 2. Planning & Design

**Main UI / Interface Screens:**

- Game Window
- Start Menu
- Pause Menu
- Debug Overlay
- Optional Level Editor

**Core Data / Models:**

```text
GameObject
- id
- position
- velocity
- size
- sprite
- collider

Player
- health
- speed
- jumpForce

Level
- objects
- spawnPoint
- boundaries
```

**Architecture:**

```text
Game Loop
→ Input System
→ Physics System
→ Collision System
→ Render System
→ Game State Manager
```

### 3. Development

**Recommended Build Order:**

1. Create project and game window.
2. Implement game loop.
3. Add keyboard input.
4. Render player and platforms.
5. Add velocity and gravity.
6. Add collision detection.
7. Add game states: menu, playing, paused.
8. Add simple level loading from JSON/text.
9. Add debug overlay.
10. Package and document.

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

- Player moves left/right
- Player jumps
- Gravity pulls player down
- Player lands on platforms
- Player cannot fall through floor
- Pause menu stops movement
- Level restart resets position

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

Package as runnable `.jar` if Java or executable if C++. Upload release builds to GitHub Releases or itch.io if you want a public demo.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add enemies
- Add camera scrolling
- Add level editor
- Add sound effects
- Add particle system
- Add save/load
- Add scripting support

**What This Leads To:** Game engine development, simulation systems, graphics programming, physics engines.

---


## Ray Tracer Renderer

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** C++ or Java  
**Core Stack:** C++ STL/Java, vector maths, image output as PPM/PNG  
**Goal:** Render 3D scenes using ray tracing from scratch.

### basicPlan

1. Generate an image file.
2. Implement vectors and rays.
3. Render a sphere.
4. Add camera.
5. Add diffuse lighting.
6. Add shadows.
7. Add reflections.
8. Render final scene.

### 1. Pre-Launch & Discovery

**Problem:** Ray tracing teaches maths, performance, graphics, lighting, and clean architecture.

**Target Users:** Graphics learners, CS students, technical portfolio reviewers.

**MVP Success Criteria:**

- Output image file
- Sphere rendering
- Camera system
- Materials
- Diffuse lighting
- Shadows
- Reflections
- Multiple objects

### 2. Planning & Design

**Main UI / Interface Screens:**

- Command-line renderer
- Scene configuration file
- Output image viewer
- Optional small preview window

**Core Data / Models:**

```text
Vector3
- x
- y
- z

Ray
- origin
- direction

Sphere
- center
- radius
- material

Material
- color
- reflectivity
- roughness

Scene
- camera
- objects
- lights
```

**Architecture:**

```text
Scene File
→ Parser
→ Camera
→ Ray Generator
→ Intersection Engine
→ Shading Engine
→ Image Writer
```

### 3. Development

**Recommended Build Order:**

1. Create vector maths class.
2. Create ray class.
3. Write image output.
4. Add sphere intersection.
5. Add camera rays.
6. Add material colour.
7. Add light and shadows.
8. Add reflections.
9. Add anti-aliasing.
10. Add scene config file.

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

- Image file generated
- Sphere appears centered
- Moving camera changes view
- Light direction changes shading
- Shadow appears behind object
- Reflections visible on reflective material

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

This is usually a command-line project. Upload source, sample scene files, and rendered images to GitHub. Add before/after render examples.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add triangles
- Add OBJ model loading
- Add textures
- Add BVH acceleration
- Add depth of field
- Add multithreading
- Add GPU version later

**What This Leads To:** Computer graphics, rendering engines, GPU programming, simulation.

---


## Voxel World Prototype

**Difficulty:** ⭐⭐⭐⭐⭐  
**Languages:** Java, C++, or TypeScript  
**Core Stack:** Java LWJGL/LibGDX, C++ OpenGL, or Three.js  
**Goal:** Build a small Minecraft-style voxel world prototype.

### basicPlan

1. Render a grid of blocks.
2. Add camera movement.
3. Add block placement/removal.
4. Store world as chunks.
5. Generate terrain height map.
6. Optimise by rendering only visible faces.

### 1. Pre-Launch & Discovery

**Problem:** Voxel engines teach chunking, rendering, world data, optimisation, and procedural generation.

**Target Users:** Game dev learners, graphics learners, portfolio builders.

**MVP Success Criteria:**

- First-person/third-person camera
- Render blocks
- Break/place blocks
- Chunk-based world
- Basic terrain generation
- Save/load world

### 2. Planning & Design

**Main UI / Interface Screens:**

- Game Window
- Crosshair
- Block Hotbar
- Debug Overlay: FPS, chunk position
- Pause Menu

**Core Data / Models:**

```text
Block
- type
- solid
- textureId

Chunk
- chunkX
- chunkZ
- blocks[][][]

World
- chunks
- seed

Player
- position
- rotation
- selectedBlock
```

**Architecture:**

```text
Game Loop
→ Input
→ Camera
→ World/Chunk Manager
→ Mesh Builder
→ Renderer
→ Save System
```

### 3. Development

**Recommended Build Order:**

1. Set up rendering library.
2. Render a single cube.
3. Render multiple cubes.
4. Add camera controls.
5. Add block selection.
6. Add place/remove logic.
7. Add chunk structure.
8. Add terrain generation.
9. Add face-culling optimisation.
10. Add save/load.

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

- Cube renders correctly
- Camera moves smoothly
- Blocks can be placed
- Blocks can be removed
- Terrain generates consistently from seed
- FPS remains acceptable for small world

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

Package locally. Upload a demo video, screenshots, and playable build if stable.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add textures
- Add lighting
- Add water
- Add caves
- Add mobs
- Add multiplayer
- Add modding support

**What This Leads To:** Game engines, graphics optimisation, procedural worlds, simulation.

---


## Interactive Sorting Algorithm Visualiser

**Difficulty:** ⭐⭐⭐  
**Languages:** TypeScript or Java  
**Core Stack:** Next.js/React Canvas or JavaFX  
**Goal:** Visualise sorting algorithms step-by-step.

### basicPlan

1. Generate random array.
2. Display bars.
3. Implement bubble sort.
4. Animate swaps.
5. Add selection sort and insertion sort.
6. Add speed control.
7. Add reset button.

### 1. Pre-Launch & Discovery

**Problem:** Algorithms are easier to understand when learners can see them.

**Target Users:** CS students, teachers, interview prep learners.

**MVP Success Criteria:**

- Generate array
- Choose algorithm
- Start/pause animation
- Speed control
- Step-by-step mode
- Compare algorithm statistics

### 2. Planning & Design

**Main UI / Interface Screens:**

- Main Visualiser
- Algorithm Selector
- Speed Slider
- Stats Panel
- Explanation Panel

**Core Data / Models:**

```text
ArrayState
- values
- highlightedIndices
- swaps
- comparisons

AlgorithmRun
- algorithmName
- stepCount
- duration
- status
```

**Architecture:**

```text
UI Controls
→ Algorithm Step Generator
→ Animation Controller
→ Canvas/DOM Renderer
→ Stats Tracker
```

### 3. Development

**Recommended Build Order:**

1. Build static array bars.
2. Add random array generation.
3. Implement bubble sort as steps.
4. Animate each step.
5. Add controls.
6. Add more algorithms.
7. Add stats.
8. Add explanations.
9. Deploy to Vercel/GitHub Pages.

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

- Array generates correctly
- Bubble sort sorts correctly
- Animation can pause/resume
- Speed slider changes speed
- Reset returns unsorted array
- Stats update correctly

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

Deploy web version to Vercel or GitHub Pages. Add screenshots and explanation to README.

**Launch Checklist:**

- Push code to GitHub
- Add setup instructions
- Add architecture diagram
- Add screenshots or demo GIF
- Record a short demo video
- Add future roadmap

### 6. Post-Launch

- Add merge sort
- Add quicksort
- Add pathfinding visualiser
- Add algorithm complexity notes
- Add teaching mode

**What This Leads To:** Educational tools, data structure visualisers, frontend animation.

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
