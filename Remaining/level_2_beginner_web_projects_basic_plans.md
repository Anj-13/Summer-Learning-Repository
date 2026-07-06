# Level 2 Beginner Web Projects — Professional Basic Plans

These Level 2 projects are designed for a beginner web developer who wants to move from simple programming projects into real frontend/full-stack applications.

Recommended stack for most projects:

```text
Frontend: React or Next.js
Language: JavaScript first, then TypeScript
Styling: Tailwind CSS
Storage: LocalStorage first, then PostgreSQL/Firebase/Supabase later
Deployment: Vercel or Netlify
```

---

# 1. Weather App + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Users want to quickly check the current weather and forecast for a city.

### Target User
Students, commuters, travellers, and anyone who wants a simple weather dashboard.

### Core Value
The app gives a fast, clean weather view without needing to open a complex weather website.

### MVP Scope
Users can:

- Search for a city
- View current temperature
- View weather condition
- View humidity and wind speed
- View a simple 5-day forecast
- Save favourite cities locally

### Out of Scope for MVP

- User accounts
- Severe weather alerts
- Maps
- AI weather advice

---

## 2. Planning & Design

### User Stories

```text
As a user, I want to search for a city so I can see its weather.
As a user, I want to save favourite cities so I can check them quickly.
As a user, I want to see forecast information so I can plan ahead.
```

### UI Pages / Components

| Screen / Component | Purpose |
|---|---|
| Home Page | Search city and show weather result |
| Search Bar | User enters city name |
| Weather Card | Current temperature, condition, icon |
| Forecast Section | Daily forecast cards |
| Favourites Section | Saved cities |
| Error Message | Invalid city or API failure |

### Data Model

```js
const weather = {
  city: "London",
  temperature: 21,
  condition: "Cloudy",
  humidity: 70,
  windSpeed: 12,
  forecast: []
};
```

### Tech Stack

```text
Frontend: React / Next.js
API: OpenWeatherMap API or WeatherAPI
Styling: Tailwind CSS
Storage: LocalStorage
Deployment: Vercel
```

---

## 3. Development

### Suggested Folder Structure

```text
weather-app/
  src/
    app/ or pages/
    components/
      SearchBar.jsx
      WeatherCard.jsx
      ForecastCard.jsx
      FavouriteCities.jsx
    services/
      weatherApi.js
    utils/
      formatWeather.js
```

### Build Order

| Step | Task |
|---|---|
| 1 | Create project with Vite or Next.js |
| 2 | Build static UI first |
| 3 | Add city search input |
| 4 | Connect weather API |
| 5 | Display weather response |
| 6 | Add loading and error states |
| 7 | Add favourites using LocalStorage |
| 8 | Polish responsive design |

### basicPlan

```text
Day 1: Build UI layout and search bar.
Day 2: Connect weather API and display current weather.
Day 3: Add forecast cards and loading/error states.
Day 4: Add favourite cities with LocalStorage.
Day 5: Deploy and write README.
```

---

## 4. Testing & Quality Assurance

### Manual Tests

| Test | Expected Result |
|---|---|
| Search valid city | Weather displays correctly |
| Search invalid city | Error message appears |
| Empty search | User gets validation message |
| Save favourite | City appears in favourites |
| Refresh page | Favourite cities remain |
| Mobile view | Layout remains readable |

### Edge Cases

```text
API key missing
City not found
Network request fails
User searches with extra spaces
Duplicate favourite city
```

---

## 5. Deployment & Launch

### Launch Checklist

```text
[ ] Hide API key in environment variables
[ ] Add README
[ ] Add screenshots
[ ] Test on mobile
[ ] Deploy on Vercel
[ ] Add project link to portfolio
```

### README Sections

```text
Project description
Features
Tech stack
How to run locally
API used
Screenshots
Future improvements
```

---

## 6. Post-Launch

### Improvements

```text
Add geolocation weather
Add dark mode
Add hourly forecast
Add weather-based clothing advice
Add weather alerts
Convert to TypeScript
```

### What This Leads To

```text
Travel dashboard
Smart campus weather widget
AI personal assistant
Location-based applications
```

---

# 2. Movie Search App + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Users want to quickly search for movies and view useful information.

### Target User
Movie fans, students, and users looking for something to watch.

### Core Value
A simple movie discovery app that teaches API fetching, search, and dynamic UI.

### MVP Scope
Users can:

- Search movies by title
- View movie cards
- View movie details
- Save favourite movies
- Filter by year or type

### Out of Scope for MVP

- Streaming links
- User accounts
- Reviews system
- Payments

---

## 2. Planning & Design

### User Stories

```text
As a user, I want to search for a movie so I can find information quickly.
As a user, I want to view details so I can decide whether to watch it.
As a user, I want to favourite movies so I can come back to them later.
```

### UI Pages / Components

| Screen / Component | Purpose |
|---|---|
| Home Page | Search and display movies |
| Movie Grid | Shows movie results |
| Movie Card | Poster, title, year |
| Movie Detail Page | Plot, rating, genre, runtime |
| Favourites Page | Saved movies |
| Empty State | No results or no favourites |

### Data Model

```js
const movie = {
  imdbID: "tt1234567",
  title: "Example Movie",
  year: "2024",
  poster: "poster-url",
  type: "movie"
};
```

### Tech Stack

```text
Frontend: React / Next.js
API: OMDb API or TMDB API
Styling: Tailwind CSS
Storage: LocalStorage
Deployment: Vercel
```

---

## 3. Development

### Suggested Folder Structure

```text
movie-search-app/
  src/
    components/
      MovieCard.jsx
      SearchBar.jsx
      MovieGrid.jsx
      FavouriteButton.jsx
    pages/ or app/
      index.jsx
      movie/[id].jsx
      favourites.jsx
    services/
      movieApi.js
```

### Build Order

| Step | Task |
|---|---|
| 1 | Build homepage layout |
| 2 | Add search input |
| 3 | Fetch movie results from API |
| 4 | Display movie grid |
| 5 | Add detail page |
| 6 | Add favourite button |
| 7 | Save favourites to LocalStorage |
| 8 | Add loading, error, and empty states |

### basicPlan

```text
Day 1: Build homepage, search bar, and movie card UI.
Day 2: Connect movie API and show search results.
Day 3: Create movie detail page.
Day 4: Add favourites with LocalStorage.
Day 5: Deploy and document.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Search existing movie | Results appear |
| Search random text | No results message |
| Click movie card | Detail page opens |
| Favourite movie | Movie appears on favourites page |
| Refresh page | Favourites remain |
| Missing poster | Placeholder image appears |

### Edge Cases

```text
API rate limit
Movie has no poster
Movie details missing
Empty search input
Duplicate favourites
```

---

## 5. Deployment & Launch

```text
[ ] Add API key to environment variables
[ ] Deploy on Vercel
[ ] Add README
[ ] Add screenshots
[ ] Add live demo link
```

---

## 6. Post-Launch

### Improvements

```text
Add watchlist categories
Add genre filters
Add pagination
Add user login
Add movie recommendations
Add AI movie recommender
```

### What This Leads To

```text
Netflix-style clone
Recommendation systems
Media discovery platforms
AI entertainment assistant
```

---

# 3. Recipe Finder App + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Users often have ingredients but do not know what to cook.

### Target User
Students, beginner cooks, busy people, and health-conscious users.

### Core Value
Users can search recipes by ingredient, cuisine, or meal type.

### MVP Scope
Users can:

- Search recipes
- View recipe cards
- View ingredients and instructions
- Save favourite recipes
- Filter by cuisine or diet

---

## 2. Planning & Design

### User Stories

```text
As a student, I want to search recipes by ingredient so I can cook with what I have.
As a user, I want to save favourite recipes so I can reuse them.
As a user, I want to see ingredients clearly so I can shop easily.
```

### UI Pages / Components

| Screen / Component | Purpose |
|---|---|
| Home Page | Search recipes |
| Recipe Grid | Display recipe cards |
| Recipe Detail | Ingredients, method, time |
| Favourites Page | Saved recipes |
| Filter Bar | Cuisine, diet, time |

### Data Model

```js
const recipe = {
  id: 1,
  title: "Chicken Pasta",
  image: "image-url",
  readyInMinutes: 25,
  ingredients: [],
  instructions: ""
};
```

### Tech Stack

```text
Frontend: React / Next.js
API: Spoonacular API, Edamam API, or TheMealDB
Styling: Tailwind CSS
Storage: LocalStorage
Deployment: Vercel
```

---

## 3. Development

### Build Order

| Step | Task |
|---|---|
| 1 | Build recipe card UI |
| 2 | Add search input |
| 3 | Connect recipe API |
| 4 | Display results |
| 5 | Add recipe detail page |
| 6 | Add favourites |
| 7 | Add filters |
| 8 | Add responsive design |

### basicPlan

```text
Day 1: Build homepage and recipe cards.
Day 2: Connect API and display recipe search results.
Day 3: Build recipe detail page.
Day 4: Add favourites and filters.
Day 5: Deploy and write README.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Search chicken | Chicken recipes show |
| Empty search | Validation message |
| Click recipe | Detail opens |
| Save favourite | Recipe saved |
| Refresh page | Favourite remains |
| API error | Friendly error shown |

---

## 5. Deployment & Launch

```text
[ ] Store API key safely
[ ] Deploy frontend
[ ] Add README
[ ] Add screenshots
[ ] Test mobile layout
```

---

## 6. Post-Launch

### Improvements

```text
Meal planner
Shopping list generator
Nutrition calculator
AI recipe generator
Fridge ingredient scanner
```

### What This Leads To

```text
Health apps
Meal planning SaaS
AI food assistant
Computer vision food recognition
```

---

# 4. Real-Time Chat App + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Users need simple real-time messaging.

### Target User
Friends, small teams, student groups, hackathon teams.

### Core Value
Learn real-time communication, authentication, and message storage.

### MVP Scope
Users can:

- Join a chat room
- Send messages
- Receive messages live
- See sender name
- See message timestamp
- Leave room

### Out of Scope for MVP

- End-to-end encryption
- Voice/video calls
- File sharing
- Message reactions

---

## 2. Planning & Design

### User Stories

```text
As a user, I want to join a room so I can chat with others.
As a user, I want messages to appear instantly so the chat feels live.
As a user, I want to see who sent a message so I understand the conversation.
```

### UI Pages / Components

| Screen / Component | Purpose |
|---|---|
| Join Room Page | Enter username and room name |
| Chat Room | Messages and input box |
| Message Bubble | Single message |
| User List | Online users |
| System Message | Join/leave notifications |

### Data Model

```js
const message = {
  id: "uuid",
  room: "general",
  sender: "Anj",
  text: "Hello",
  timestamp: "2026-07-06T12:00:00"
};
```

### Tech Stack Option A

```text
Frontend: React / Next.js
Backend: Node.js + Express
Realtime: Socket.IO
Storage: In-memory first, then MongoDB/PostgreSQL
Deployment: Render/Railway + Vercel
```

### Tech Stack Option B

```text
Frontend: React / Next.js
Backend: Spring Boot
Realtime: Spring WebSocket/STOMP
Database: PostgreSQL
Deployment: Render/Railway
```

---

## 3. Development

### Build Order

| Step | Task |
|---|---|
| 1 | Build join room page |
| 2 | Build chat room UI |
| 3 | Create backend WebSocket server |
| 4 | Connect frontend to socket |
| 5 | Send and receive messages |
| 6 | Add rooms |
| 7 | Add online users |
| 8 | Save messages later |

### basicPlan

```text
Day 1: Build chat UI and join room form.
Day 2: Create WebSocket server.
Day 3: Send and receive messages live.
Day 4: Add rooms and online users.
Day 5: Deploy frontend and backend.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Two users join same room | Both can see messages |
| User sends message | Message appears instantly |
| User joins different room | Messages are separated |
| Empty message | Message not sent |
| Refresh page | User can rejoin room |
| Backend disconnects | Error or reconnect shown |

### Edge Cases

```text
Duplicate usernames
Very long messages
User disconnects suddenly
Room name is empty
Socket reconnect issues
```

---

## 5. Deployment & Launch

```text
[ ] Deploy frontend to Vercel
[ ] Deploy backend to Render/Railway
[ ] Configure CORS
[ ] Test WebSocket URL in production
[ ] Add README and demo GIF
```

---

## 6. Post-Launch

### Improvements

```text
User authentication
Message database
Typing indicator
Read receipts
Private messages
File sharing
Voice chat
```

### What This Leads To

```text
Discord clone
Slack clone
Real-time collaboration apps
WebRTC video apps
```

---

# 5. Portfolio Website + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Students need a professional place to show projects, skills, and experience.

### Target User
You, recruiters, hackathon judges, internship reviewers, collaborators.

### Core Value
A polished portfolio makes your work easier to understand and share.

### MVP Scope
Portfolio includes:

- Hero section
- About section
- Skills section
- Projects section
- Hackathon experience
- Contact links
- Resume download

---

## 2. Planning & Design

### User Stories

```text
As a recruiter, I want to quickly understand the student's skills.
As a visitor, I want to view projects with links and tech stacks.
As the owner, I want to update projects easily.
```

### UI Pages / Sections

| Section | Purpose |
|---|---|
| Hero | Name, role, short intro, CTA buttons |
| About | Your background and interests |
| Skills | Tech stack grouped by category |
| Projects | Cards with GitHub/demo links |
| Hackathons | Team projects and sponsors |
| Contact | Email, LinkedIn, GitHub |

### Content Model

```js
const project = {
  title: "AI Hackathon Project",
  description: "Short project summary",
  techStack: ["React", "Spring Boot", "AI"],
  githubUrl: "",
  demoUrl: ""
};
```

### Tech Stack

```text
Frontend: Next.js
Styling: Tailwind CSS
Animation: Framer Motion optional
Deployment: Vercel
Content: JSON file or Markdown
```

---

## 3. Development

### Build Order

| Step | Task |
|---|---|
| 1 | Create wireframe |
| 2 | Build hero section |
| 3 | Build about and skills sections |
| 4 | Build project cards |
| 5 | Add responsive layout |
| 6 | Add animations |
| 7 | Add SEO metadata |
| 8 | Deploy |

### basicPlan

```text
Day 1: Create Next.js app and build hero/about sections.
Day 2: Add skills and projects section.
Day 3: Add hackathon and contact sections.
Day 4: Improve responsive design and animations.
Day 5: Deploy and add custom domain later.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Open on desktop | Layout looks professional |
| Open on mobile | Sections stack correctly |
| Click GitHub links | Correct repos open |
| Click resume | Resume downloads/opens |
| Lighthouse test | Good performance score |
| SEO title | Correct browser title appears |

---

## 5. Deployment & Launch

```text
[ ] Deploy on Vercel
[ ] Add GitHub link
[ ] Add LinkedIn link
[ ] Add project screenshots
[ ] Check mobile layout
[ ] Add portfolio link to GitHub profile
```

---

## 6. Post-Launch

### Improvements

```text
Blog section
Project case studies
Dark mode
CMS integration
Analytics
Custom domain
```

### What This Leads To

```text
Personal branding
Freelance website
Technical blog
Developer documentation site
```

---

# 6. Blog CMS + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Developers need a place to write technical notes, tutorials, and project logs.

### Target User
You, students, junior developers, and readers learning from your journey.

### Core Value
A blog CMS helps you document learning and build public proof of skill.

### MVP Scope
Users can:

- View blog posts
- View single post page
- Filter posts by tag
- Search posts
- Write posts in Markdown

### Out of Scope for MVP

- Multi-user admin dashboard
- Comments
- Payments
- Newsletter

---

## 2. Planning & Design

### User Stories

```text
As a reader, I want to browse posts so I can learn from them.
As a reader, I want to search posts so I can find specific topics.
As the owner, I want to write posts in Markdown so updates are simple.
```

### UI Pages / Components

| Page / Component | Purpose |
|---|---|
| Blog Home | List posts |
| Post Detail | Full article |
| Tag Filter | Filter by topic |
| Search Bar | Search titles/content |
| Author Card | About the writer |

### Content Model

```md
---
title: "Learning Spring Boot"
date: "2026-07-06"
tags: ["Java", "Spring Boot"]
summary: "My notes from learning Spring Boot."
---

Post content here.
```

### Tech Stack

```text
Frontend: Next.js
Content: Markdown / MDX
Styling: Tailwind CSS
Search: Client-side search first
Deployment: Vercel
```

---

## 3. Development

### Build Order

| Step | Task |
|---|---|
| 1 | Create Next.js project |
| 2 | Add Markdown posts folder |
| 3 | Parse Markdown metadata |
| 4 | Render blog list |
| 5 | Render post detail page |
| 6 | Add tags |
| 7 | Add search |
| 8 | Deploy |

### basicPlan

```text
Day 1: Build blog homepage and post card UI.
Day 2: Add Markdown parsing and post detail pages.
Day 3: Add tags and search.
Day 4: Add styling and responsive design.
Day 5: Deploy and publish first 3 posts.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Add new Markdown post | Post appears on blog home |
| Click post | Full post opens |
| Filter by tag | Correct posts show |
| Search keyword | Matching posts show |
| Broken slug | 404 page appears |
| Mobile view | Article is readable |

---

## 5. Deployment & Launch

```text
[ ] Add at least 3 posts
[ ] Deploy to Vercel
[ ] Add SEO metadata
[ ] Add README
[ ] Link blog from portfolio
```

---

## 6. Post-Launch

### Improvements

```text
MDX components
Newsletter signup
Comments
Admin editor
Series pages
AI post summariser
```

### What This Leads To

```text
Documentation sites
Knowledge bases
Developer education platforms
CMS products
```

---

# 7. URL Shortener + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Long links are hard to share and track.

### Target User
Students, creators, developers, and small teams.

### Core Value
Create short links and track basic clicks.

### MVP Scope
Users can:

- Paste long URL
- Generate short link
- Copy short link
- Redirect short link to original URL
- View basic click count

---

## 2. Planning & Design

### User Stories

```text
As a user, I want to shorten a URL so it is easier to share.
As a user, I want to copy the short URL quickly.
As a user, I want to see click count so I know if people used it.
```

### UI Pages / Components

| Page / Component | Purpose |
|---|---|
| Home Page | URL input and generated result |
| Short Link Result | Copyable link |
| Stats Page | Click count and original URL |
| Error Page | Invalid or expired link |

### Data Model

```js
const link = {
  id: "uuid",
  originalUrl: "https://example.com/long-url",
  shortCode: "abc123",
  clickCount: 0,
  createdAt: "2026-07-06"
};
```

### Tech Stack Option A

```text
Frontend + Backend: Next.js API routes
Database: SQLite / PostgreSQL / Supabase
Deployment: Vercel
```

### Tech Stack Option B

```text
Frontend: React / Next.js
Backend: Spring Boot
Database: PostgreSQL
Deployment: Vercel + Render/Railway
```

---

## 3. Development

### Build Order

| Step | Task |
|---|---|
| 1 | Build homepage UI |
| 2 | Add URL input validation |
| 3 | Generate random short code |
| 4 | Save link to database or file/local mock |
| 5 | Create redirect route |
| 6 | Increment click count |
| 7 | Add stats page |
| 8 | Deploy |

### basicPlan

```text
Day 1: Build UI and URL validation.
Day 2: Create short-code generation logic.
Day 3: Add backend route/API for saving links.
Day 4: Add redirect and click count.
Day 5: Deploy and document.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Submit valid URL | Short URL generated |
| Submit invalid URL | Error shown |
| Visit short URL | Redirects correctly |
| Visit unknown code | Error page shown |
| Click short link twice | Count increases by 2 |
| Copy button | Link copied to clipboard |

---

## 5. Deployment & Launch

```text
[ ] Set production base URL
[ ] Deploy frontend/backend
[ ] Test redirect in production
[ ] Add README
[ ] Add architecture diagram
```

---

## 6. Post-Launch

### Improvements

```text
Custom aliases
Expiry dates
User accounts
QR code generation
Analytics dashboard
Rate limiting
```

### What This Leads To

```text
Scalable backend services
Analytics platforms
Distributed systems
System design interview projects
```

---

# 8. Notes App + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Users need a simple place to save and organise notes.

### Target User
Students, developers, and people taking quick notes.

### Core Value
Fast note creation, editing, searching, and organisation.

### MVP Scope
Users can:

- Create note
- Edit note
- Delete note
- Search notes
- Pin important notes
- Save notes locally

---

## 2. Planning & Design

### User Stories

```text
As a user, I want to create notes quickly so I do not forget ideas.
As a user, I want to search notes so I can find information later.
As a user, I want to pin notes so important information stays visible.
```

### UI Pages / Components

| Page / Component | Purpose |
|---|---|
| Notes Dashboard | List of notes |
| Note Editor | Create/edit notes |
| Search Bar | Find notes |
| Sidebar | Categories or pinned notes |
| Empty State | No notes yet |

### Data Model

```js
const note = {
  id: "uuid",
  title: "Project Idea",
  content: "Build an AI assistant...",
  pinned: false,
  createdAt: "2026-07-06",
  updatedAt: "2026-07-06"
};
```

### Tech Stack

```text
Frontend: React / Next.js
Styling: Tailwind CSS
Storage: LocalStorage first
Optional DB: Supabase/Firebase/PostgreSQL
Deployment: Vercel
```

---

## 3. Development

### Build Order

| Step | Task |
|---|---|
| 1 | Build dashboard layout |
| 2 | Add note card component |
| 3 | Add note editor form |
| 4 | Create note state management |
| 5 | Add edit/delete |
| 6 | Add search |
| 7 | Add pinning |
| 8 | Save to LocalStorage |

### basicPlan

```text
Day 1: Build notes dashboard and note card UI.
Day 2: Add create/edit/delete note functionality.
Day 3: Add search and pinning.
Day 4: Add LocalStorage persistence.
Day 5: Deploy and write README.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Create note | Note appears |
| Edit note | Changes save |
| Delete note | Note removed |
| Search title | Matching notes show |
| Pin note | Note appears at top |
| Refresh page | Notes remain |

---

## 5. Deployment & Launch

```text
[ ] Deploy on Vercel
[ ] Add README
[ ] Add screenshots
[ ] Test in Chrome and mobile
[ ] Add to portfolio
```

---

## 6. Post-Launch

### Improvements

```text
Markdown editor
Tags and folders
Authentication
Cloud sync
Rich text editor
AI note summariser
```

### What This Leads To

```text
Notion clone
Knowledge brain
AI study assistant
Personal productivity SaaS
```

---

# 9. Habit Tracker Web App + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Users want to build habits and stay consistent.

### Target User
Students, gym users, learners, and productivity-focused people.

### Core Value
The app helps users track daily actions and see streaks.

### MVP Scope
Users can:

- Add habit
- Mark habit complete for today
- View daily habit list
- View streak count
- Delete habit
- Save progress locally

---

## 2. Planning & Design

### User Stories

```text
As a user, I want to create habits so I can track routines.
As a user, I want to mark habits as done so I can build consistency.
As a user, I want to see streaks so I feel motivated.
```

### UI Pages / Components

| Page / Component | Purpose |
|---|---|
| Dashboard | Today's habits |
| Habit Card | Habit name, streak, done button |
| Add Habit Modal | Create new habit |
| Progress Section | Weekly completion view |
| Empty State | No habits yet |

### Data Model

```js
const habit = {
  id: "uuid",
  name: "Code for 1 hour",
  completedDates: ["2026-07-06"],
  createdAt: "2026-07-01"
};
```

### Tech Stack

```text
Frontend: React / Next.js
Styling: Tailwind CSS
Storage: LocalStorage
Date Handling: date-fns
Deployment: Vercel
```

---

## 3. Development

### Build Order

| Step | Task |
|---|---|
| 1 | Build dashboard UI |
| 2 | Add habit creation form |
| 3 | Display habit cards |
| 4 | Mark habit done today |
| 5 | Prevent duplicate completion |
| 6 | Calculate streak |
| 7 | Save to LocalStorage |
| 8 | Add weekly progress UI |

### basicPlan

```text
Day 1: Build dashboard and habit card UI.
Day 2: Add habit creation and deletion.
Day 3: Add mark-done logic and duplicate prevention.
Day 4: Add streak calculation and LocalStorage.
Day 5: Deploy and document.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Add habit | Habit appears |
| Mark done | Today is recorded |
| Mark same habit twice | No duplicate date |
| Refresh page | Habit data remains |
| Delete habit | Habit removed |
| Streak view | Correct streak shown |

---

## 5. Deployment & Launch

```text
[ ] Deploy on Vercel
[ ] Add README
[ ] Add screenshots
[ ] Test local storage after refresh
[ ] Add to portfolio
```

---

## 6. Post-Launch

### Improvements

```text
Calendar heatmap
Reminder notifications
User login
Analytics dashboard
AI habit coach
Mobile app version
```

### What This Leads To

```text
Productivity apps
Health apps
Personal analytics tools
AI coaching apps
```

---

# 10. Kanban Board + basicPlan

## 1. Pre-Launch & Discovery

### Problem
Users need a simple way to organise tasks visually.

### Target User
Students, solo developers, small hackathon teams.

### Core Value
A visual workflow board helps users manage work from idea to completion.

### MVP Scope
Users can:

- Create task cards
- Move tasks between columns
- Edit task title/description
- Delete tasks
- Save board locally

### Columns

```text
Todo
In Progress
Done
```

---

## 2. Planning & Design

### User Stories

```text
As a student, I want to create tasks so I can organise my work.
As a user, I want to move tasks between columns so I can track progress.
As a user, I want my board saved so I can continue later.
```

### UI Pages / Components

| Component | Purpose |
|---|---|
| Board Page | Main Kanban view |
| Column | Todo/In Progress/Done |
| Task Card | Individual task |
| Task Modal | Add/edit task |
| Drag Area | Move cards between columns |

### Data Model

```js
const board = {
  columns: {
    todo: [{ id: "1", title: "Build UI", description: "Create layout" }],
    inProgress: [],
    done: []
  }
};
```

### Tech Stack

```text
Frontend: React / Next.js
Styling: Tailwind CSS
Drag and Drop: dnd-kit or react-beautiful-dnd
Storage: LocalStorage
Deployment: Vercel
```

---

## 3. Development

### Build Order

| Step | Task |
|---|---|
| 1 | Build static board layout |
| 2 | Add task cards |
| 3 | Add task creation modal |
| 4 | Add edit/delete |
| 5 | Add drag-and-drop |
| 6 | Save board to LocalStorage |
| 7 | Add responsive design |
| 8 | Deploy |

### basicPlan

```text
Day 1: Build static Kanban board UI.
Day 2: Add task creation, editing, and deletion.
Day 3: Add drag-and-drop movement.
Day 4: Add LocalStorage and responsive design.
Day 5: Deploy and write README.
```

---

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Add task | Task appears in Todo |
| Edit task | Card updates |
| Delete task | Card disappears |
| Drag to In Progress | Card moves correctly |
| Refresh page | Board remains saved |
| Empty column | Column still displays properly |

---

## 5. Deployment & Launch

```text
[ ] Deploy on Vercel
[ ] Add README
[ ] Add screenshots
[ ] Test drag-and-drop on mobile
[ ] Add to portfolio
```

---

## 6. Post-Launch

### Improvements

```text
Multiple boards
User authentication
Team collaboration
Comments
Deadlines
Labels
Spring Boot backend
AI task breakdown
```

### What This Leads To

```text
Trello clone
Jira clone
AI project manager
Full-stack productivity SaaS
```

---

# Recommended Build Order

```text
1. Portfolio Website
2. Weather App
3. Movie Search App
4. Recipe Finder App
5. Notes App
6. Habit Tracker Web App
7. Blog CMS
8. URL Shortener
9. Real-Time Chat App
10. Kanban Board
```

This order gradually builds skills:

```text
HTML/CSS layout
→ React components
→ API fetching
→ routing
→ local storage
→ forms and validation
→ CRUD
→ backend APIs
→ real-time communication
→ drag-and-drop interaction
```

# Best First Level 2 Project To Start Today

Start with the **Portfolio Website** if you want something useful immediately.

Start with the **Weather App** if you want to practise API calls.

Start with the **Notes App** if you want to practise CRUD, state management, and LocalStorage.

