# Level 4 Advanced Full-Stack Project Plans

These projects are designed for a student who already understands basic frontend, backend, APIs, CRUD, authentication basics, and databases. Each project is planned using a professional software-development structure:

1. Pre-Launch & Discovery  
2. Planning & Design  
3. Development  
4. Testing & Quality Assurance  
5. Deployment & Launch  
6. Post-Launch  

Each project also includes a **basicPlan** so you can start coding immediately.

---

# 1. Airbnb Clone

## basicPlan

Build a property booking platform where users can browse listings, view details, book stays, and manage their bookings. Start with simple CRUD, then add authentication, booking validation, image upload, and payment simulation.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS
- Backend: Spring Boot
- Database: PostgreSQL
- Auth: JWT / Spring Security
- Storage: Cloudinary or local image upload
- Deployment: Vercel + Render/Railway

## 1. Pre-Launch & Discovery

### Problem

People need a simple platform to list properties and book short stays.

### Target Users

- Guests searching for accommodation
- Hosts listing properties
- Admins managing reported listings

### Core Value

Allow users to search, compare, and book properties easily.

### MVP Scope

- User registration/login
- Browse listings
- Search by location
- View listing details
- Create booking
- Host can create/edit/delete listings
- User can view booking history

### Out of Scope for MVP

- Real payment processing
- Real-time chat
- Advanced recommendation system
- Reviews moderation system

## 2. Planning & Design

### User Stories

- As a guest, I want to browse listings so I can find accommodation.
- As a guest, I want to book a property so I can reserve a stay.
- As a host, I want to create listings so I can rent out properties.
- As a user, I want to manage my bookings so I can cancel or review them.

### Core Pages

| Page | Purpose |
|---|---|
| Home | Search and featured listings |
| Listings | Filtered property results |
| Listing Detail | Photos, description, price, booking form |
| Login/Register | Authentication |
| Host Dashboard | Manage listings |
| My Bookings | User booking history |
| Admin Dashboard | Manage users/listings |

### Database Tables

```text
User
- id
- name
- email
- passwordHash
- role
- createdAt

Property
- id
- hostId
- title
- description
- location
- pricePerNight
- maxGuests
- imageUrl
- createdAt

Booking
- id
- userId
- propertyId
- checkInDate
- checkOutDate
- totalPrice
- status
- createdAt

Review
- id
- userId
- propertyId
- rating
- comment
- createdAt
```

### API Design

```text
POST /auth/register
POST /auth/login

GET /properties
GET /properties/{id}
POST /properties
PUT /properties/{id}
DELETE /properties/{id}

POST /bookings
GET /bookings/my
DELETE /bookings/{id}

POST /reviews
GET /reviews/property/{propertyId}
```

## 3. Development

### Phase 1: Project Setup

- Create Next.js frontend
- Create Spring Boot backend
- Connect PostgreSQL
- Configure environment variables
- Set up GitHub repository

### Phase 2: Authentication

- Register user
- Login user
- Store password securely
- Add JWT authentication
- Protect private routes

### Phase 3: Listings

- Create property model
- Add listing CRUD
- Build property cards
- Build search/filter UI
- Add listing detail page

### Phase 4: Bookings

- Create booking model
- Validate check-in/check-out dates
- Prevent booking unavailable dates
- Calculate total price
- Show user booking history

### Phase 5: Host Dashboard

- Host can view their listings
- Host can edit/delete listings
- Host can see bookings for their properties

### Phase 6: Polish

- Add loading states
- Add error messages
- Add responsive design
- Add empty states
- Add seed data

## 4. Testing & Quality Assurance

### Manual Tests

| Test | Expected Result |
|---|---|
| User registers | Account created |
| User logs in | JWT returned |
| Guest views listing | Listing details shown |
| Host creates property | Property appears in listings |
| Guest books property | Booking appears in My Bookings |
| Invalid date range | Error shown |
| Unauthenticated user books | Redirect to login |

### Backend Tests

- Auth service tests
- Booking date validation tests
- Property CRUD tests
- Repository tests

### Frontend Tests

- Form validation
- Route protection
- Search/filter behaviour
- Booking form behaviour

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend to Vercel
- Deploy backend to Render/Railway/Fly.io
- Use managed PostgreSQL
- Add production environment variables
- Test deployed authentication
- Test booking flow end-to-end

### README Checklist

- Project overview
- Features
- Tech stack
- Screenshots
- API endpoints
- How to run locally
- Future improvements

## 6. Post-Launch

### Improvements

- Real Stripe payments
- Reviews and ratings
- Availability calendar
- Map search
- Messaging between host and guest
- Admin moderation
- Recommendation system

### What This Leads To

- Booking systems
- Marketplace apps
- Real estate platforms
- SaaS product architecture

---

# 2. Uber Clone

## basicPlan

Build a ride-booking app where riders request rides, drivers accept rides, and the system tracks trip status. Start without real GPS, then add maps and location simulation.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS
- Backend: Spring Boot
- Database: PostgreSQL
- Maps: Google Maps API or Mapbox
- Realtime: WebSockets
- Auth: Spring Security + JWT

## 1. Pre-Launch & Discovery

### Problem

Users need to request rides and drivers need to accept ride jobs.

### Target Users

- Riders
- Drivers
- Admins

### MVP Scope

- Rider registration/login
- Driver registration/login
- Rider creates ride request
- Driver views available requests
- Driver accepts ride
- Ride status updates
- Rider sees current ride status

### Out of Scope for MVP

- Real payment
- Real driver background checks
- Advanced route optimisation
- Surge pricing

## 2. Planning & Design

### User Stories

- As a rider, I want to request a ride so I can travel somewhere.
- As a driver, I want to accept a ride so I can earn money.
- As a rider, I want to see my ride status so I know what is happening.
- As an admin, I want to view all rides so I can monitor activity.

### Core Pages

| Page | Purpose |
|---|---|
| Rider Home | Request a ride |
| Driver Dashboard | Available ride requests |
| Ride Detail | Pickup, destination, status |
| Login/Register | Auth |
| Admin Dashboard | View users and rides |

### Database Tables

```text
User
- id
- name
- email
- passwordHash
- role

DriverProfile
- id
- userId
- vehicleName
- plateNumber
- available

Ride
- id
- riderId
- driverId
- pickupLocation
- destinationLocation
- priceEstimate
- status
- createdAt
```

### Ride Status Flow

```text
REQUESTED
→ ACCEPTED
→ DRIVER_ARRIVING
→ IN_PROGRESS
→ COMPLETED
→ CANCELLED
```

## 3. Development

### Phase 1: Setup

- Create frontend and backend
- Connect PostgreSQL
- Add authentication
- Add roles: RIDER, DRIVER, ADMIN

### Phase 2: Rider Flow

- Build ride request form
- Save pickup and destination
- Create ride request
- Show rider active ride

### Phase 3: Driver Flow

- Driver dashboard lists open ride requests
- Driver accepts ride
- Backend assigns driver to ride
- Ride status changes to ACCEPTED

### Phase 4: Realtime Updates

- Add WebSocket connection
- Notify rider when driver accepts
- Notify driver when ride is cancelled
- Update ride status live

### Phase 5: Maps

- Add map UI
- Show pickup and destination markers
- Optional route line

### Phase 6: Admin

- Admin views all rides
- Admin views users
- Admin can cancel suspicious rides

## 4. Testing & Quality Assurance

### Manual Tests

| Test | Expected Result |
|---|---|
| Rider creates ride | Ride status is REQUESTED |
| Driver accepts ride | Ride assigned to driver |
| Another driver tries same ride | Error shown |
| Rider cancels ride | Status becomes CANCELLED |
| Driver completes ride | Status becomes COMPLETED |
| Non-driver accesses driver page | Access denied |

### Backend Tests

- Ride status transition tests
- Role permission tests
- Driver assignment tests
- Authentication tests

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend
- Deploy backend
- Deploy PostgreSQL database
- Add CORS config
- Add WebSocket production URL
- Test rider and driver accounts

### Launch Demo

Prepare two browser windows:

- One as rider
- One as driver

Show live ride acceptance and status updates.

## 6. Post-Launch

### Improvements

- Real-time driver location
- Payment simulation
- Ride ratings
- Price algorithm
- Driver availability toggle
- Mobile app version

### What This Leads To

- Logistics apps
- Delivery platforms
- Real-time systems
- Location-based services

---

# 3. Spotify Clone

## basicPlan

Build a music streaming-style app where users can browse songs, create playlists, and play audio previews. Use local audio files first, then move to cloud storage.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS
- Backend: Spring Boot
- Database: PostgreSQL
- Audio Storage: local files or Cloudinary/S3
- Auth: JWT

## 1. Pre-Launch & Discovery

### Problem

Users want to browse, organise, and play music.

### Target Users

- Listeners
- Admins uploading songs

### MVP Scope

- Browse songs
- Search songs
- Play/pause audio
- Create playlists
- Add/remove songs from playlist
- User login/register

## 2. Planning & Design

### Core Pages

| Page | Purpose |
|---|---|
| Home | Featured songs/playlists |
| Search | Search songs/artists |
| Song Detail | Song metadata |
| Playlist Detail | Songs inside playlist |
| Library | User playlists |
| Admin Upload | Upload songs |

### Database Tables

```text
User
- id
- name
- email
- passwordHash

Song
- id
- title
- artist
- album
- duration
- audioUrl
- coverImageUrl

Playlist
- id
- userId
- name
- description

PlaylistSong
- playlistId
- songId
- position
```

## 3. Development

### Phase 1: Setup

- Create frontend/backend
- Connect database
- Add auth

### Phase 2: Song System

- Create song entity
- Seed songs manually
- Build song list UI
- Add audio player component

### Phase 3: Search

- Search by title
- Search by artist
- Add frontend search bar

### Phase 4: Playlists

- Create playlist
- Add song to playlist
- Remove song from playlist
- Display user library

### Phase 5: Admin Upload

- Add upload form
- Save audio URL
- Save cover image URL

### Phase 6: Polish

- Add mini-player
- Add currently playing state
- Add responsive layout

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| User plays song | Audio starts |
| User pauses song | Audio pauses |
| User creates playlist | Playlist appears |
| Add song to playlist | Song appears inside playlist |
| Search song | Correct results appear |
| Unauthenticated user creates playlist | Redirect to login |

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend to Vercel
- Deploy backend to Render/Railway
- Use cloud-hosted database
- Store audio files externally
- Add demo account

## 6. Post-Launch

### Improvements

- Queue system
- Like songs
- Recently played
- Recommendations
- Artist pages
- Lyrics support
- Collaborative playlists

### What This Leads To

- Media apps
- Streaming platforms
- Recommendation systems
- Audio engineering basics

---

# 4. Discord Clone

## basicPlan

Build a real-time messaging platform with servers, channels, and direct messages. Start with text chat only, then add WebRTC voice later.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS
- Backend: Spring Boot
- Database: PostgreSQL
- Realtime: WebSockets
- Auth: JWT

## 1. Pre-Launch & Discovery

### Problem

Groups need a place to chat in organised channels.

### Target Users

- Students
- Gaming communities
- Project teams

### MVP Scope

- Register/login
- Create server
- Join server
- Create text channels
- Send real-time messages
- View message history

## 2. Planning & Design

### Core Pages

| Page | Purpose |
|---|---|
| Login/Register | Auth |
| Server List | User's servers |
| Server View | Channels and messages |
| Channel Chat | Real-time messaging |
| Server Settings | Manage channels/members |
| Direct Messages | One-to-one chats |

### Database Tables

```text
User
- id
- username
- email
- passwordHash

Server
- id
- name
- ownerId

ServerMember
- serverId
- userId
- role

Channel
- id
- serverId
- name
- type

Message
- id
- channelId
- senderId
- content
- createdAt
```

## 3. Development

### Phase 1: Setup

- Create frontend/backend
- Configure PostgreSQL
- Add authentication

### Phase 2: Servers

- Create server
- List user's servers
- Join server using invite code

### Phase 3: Channels

- Create text channels
- List channels inside server
- Select active channel

### Phase 4: Messaging

- Create message API
- Store messages in database
- Add WebSocket broadcasting
- Display live messages

### Phase 5: Direct Messages

- Search users
- Start DM conversation
- Send private messages

### Phase 6: Polish

- Typing indicators
- Online status
- Message timestamps
- Responsive sidebar

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| User creates server | Server appears in sidebar |
| User joins server | Server appears for user |
| User sends message | Message appears live |
| Refresh page | Message history loads |
| Non-member opens server | Access denied |
| Empty message sent | Error shown |

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend
- Deploy backend
- Configure WebSocket URL
- Add database migration
- Create demo users
- Test two-user chat in separate browsers

## 6. Post-Launch

### Improvements

- Voice channels with WebRTC
- File uploads
- Message reactions
- Threaded replies
- Moderation tools
- Bot system

### What This Leads To

- Real-time systems
- Team communication tools
- Multiplayer infrastructure
- WebRTC apps

---

# 5. Trello Clone

## basicPlan

Build a Kanban board app with workspaces, boards, columns, tasks, comments, and drag-and-drop.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS, dnd-kit
- Backend: Spring Boot
- Database: PostgreSQL
- Auth: JWT

## 1. Pre-Launch & Discovery

### Problem

Students and teams need to organise work visually.

### Target Users

- Students
- Hackathon teams
- Developers
- Project managers

### MVP Scope

- Register/login
- Create workspace
- Create board
- Create columns
- Create tasks
- Drag tasks between columns
- Add task comments

## 2. Planning & Design

### Core Pages

| Page | Purpose |
|---|---|
| Dashboard | User workspaces and boards |
| Board Page | Kanban columns and tasks |
| Task Modal | Task details/comments |
| Workspace Settings | Members and permissions |
| Login/Register | Auth |

### Database Tables

```text
User
- id
- name
- email
- passwordHash

Workspace
- id
- name
- ownerId

WorkspaceMember
- workspaceId
- userId
- role

Board
- id
- workspaceId
- name

BoardColumn
- id
- boardId
- name
- position

Task
- id
- columnId
- title
- description
- position
- dueDate
- assigneeId

Comment
- id
- taskId
- userId
- content
- createdAt
```

## 3. Development

### Phase 1: Setup

- Create frontend/backend
- Add auth
- Connect PostgreSQL

### Phase 2: Workspaces and Boards

- Create workspace
- Create board
- List user's boards

### Phase 3: Columns and Tasks

- Create columns
- Create tasks
- Edit/delete tasks
- Open task modal

### Phase 4: Drag and Drop

- Add dnd-kit
- Drag task within same column
- Drag task between columns
- Persist new task position

### Phase 5: Collaboration Features

- Add comments
- Assign users
- Add due dates
- Add labels

### Phase 6: Polish

- Add skeleton loading
- Add error toasts
- Add empty board state
- Improve mobile layout

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| User creates board | Board appears |
| User creates column | Column appears |
| User creates task | Task appears |
| Drag task | Task position updates |
| Refresh board | New order stays |
| Non-member accesses board | Access denied |

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend to Vercel
- Deploy backend to Render/Railway
- Set database connection
- Add production CORS
- Add demo workspace

## 6. Post-Launch

### Improvements

- Real-time collaboration
- Activity log
- File attachments
- Calendar view
- Sprint planning
- AI task breakdown

### What This Leads To

- Jira clone
- Project management SaaS
- AI project manager
- Internal developer tools

---

# 6. GitHub Clone

## basicPlan

Build a simplified GitHub-style platform where users can create repositories, upload code files, view files, create issues, and comment. Do not implement real Git at first.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS
- Backend: Spring Boot
- Database: PostgreSQL
- File Storage: local storage or S3
- Auth: JWT

## 1. Pre-Launch & Discovery

### Problem

Developers need a place to manage code, issues, and project documentation.

### Target Users

- Students
- Developers
- Hackathon teams

### MVP Scope

- User registration/login
- Create repository
- Upload files
- Browse repository files
- Create issues
- Comment on issues
- Star repositories

### Out of Scope for MVP

- Real Git commits
- Pull requests
- Branching
- CI/CD

## 2. Planning & Design

### Core Pages

| Page | Purpose |
|---|---|
| Dashboard | User repositories |
| Repository Page | Files, README, issues |
| File Viewer | View code file |
| Issues Page | List/create issues |
| Issue Detail | Comments and status |
| Profile | User repositories |

### Database Tables

```text
User
- id
- username
- email
- passwordHash

Repository
- id
- ownerId
- name
- description
- visibility
- createdAt

RepoFile
- id
- repositoryId
- path
- fileName
- content
- language

Issue
- id
- repositoryId
- authorId
- title
- description
- status
- createdAt

IssueComment
- id
- issueId
- authorId
- content
- createdAt

Star
- userId
- repositoryId
```

## 3. Development

### Phase 1: Setup

- Create frontend/backend
- Add authentication
- Connect PostgreSQL

### Phase 2: Repository System

- Create repository
- List user repositories
- View repository details
- Add visibility: public/private

### Phase 3: File System

- Upload file content
- Store path and content
- Display file tree
- Display code content

### Phase 4: Issues

- Create issue
- List issues
- Add issue detail page
- Add comments
- Open/close issue

### Phase 5: Social Features

- Star repository
- User profile page
- Public repository search

### Phase 6: Polish

- Syntax highlighting
- README rendering
- Pagination
- Search repositories

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| User creates repo | Repo appears on dashboard |
| User uploads file | File appears in repo |
| User opens file | Content displays |
| User creates issue | Issue appears |
| User comments | Comment appears |
| Private repo accessed by stranger | Access denied |

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend
- Deploy backend
- Configure storage
- Add production environment variables
- Seed public demo repos

## 6. Post-Launch

### Improvements

- Real Git integration
- Pull requests
- Branches
- Code review comments
- GitHub OAuth
- AI code explanation

### What This Leads To

- Developer platforms
- Code intelligence tools
- AI Developer OS
- Internal engineering tools

---

# 7. Notion Clone

## basicPlan

Build a note-taking and workspace app where users can create pages, nested pages, rich text blocks, and simple databases.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS
- Editor: TipTap or Lexical
- Backend: Spring Boot
- Database: PostgreSQL
- Auth: JWT

## 1. Pre-Launch & Discovery

### Problem

Users need a flexible place for notes, documents, planning, and knowledge management.

### Target Users

- Students
- Developers
- Project teams

### MVP Scope

- Register/login
- Create workspace
- Create pages
- Edit page content
- Nested pages
- Save automatically
- Search pages

## 2. Planning & Design

### Core Pages

| Page | Purpose |
|---|---|
| Dashboard | Workspaces/pages |
| Editor Page | Rich text editing |
| Search | Find pages |
| Workspace Settings | Manage workspace |
| Trash | Deleted pages |

### Database Tables

```text
User
- id
- name
- email
- passwordHash

Workspace
- id
- name
- ownerId

Page
- id
- workspaceId
- parentPageId
- title
- icon
- coverImage
- contentJson
- createdAt
- updatedAt
- deletedAt
```

## 3. Development

### Phase 1: Setup

- Create frontend/backend
- Configure auth
- Connect database

### Phase 2: Page CRUD

- Create page
- Rename page
- Delete page
- Restore from trash

### Phase 3: Editor

- Add rich text editor
- Save content JSON
- Auto-save every few seconds
- Load saved content

### Phase 4: Nested Pages

- Add parentPageId
- Display sidebar tree
- Move page under another page

### Phase 5: Search

- Search by title
- Search by content later
- Add quick command menu

### Phase 6: Polish

- Add icons
- Add cover images
- Add dark mode
- Add loading and error states

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Create page | Page appears in sidebar |
| Type content | Content auto-saves |
| Refresh page | Content still exists |
| Delete page | Page moves to trash |
| Search page title | Page appears |
| User opens another user's page | Access denied |

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend/backend
- Deploy database
- Configure environment variables
- Create demo workspace
- Test auto-save in production

## 6. Post-Launch

### Improvements

- Collaborative editing
- Templates
- Tables/databases
- Comments
- AI summarisation
- PDF export

### What This Leads To

- Knowledge management systems
- Collaborative editors
- AI knowledge brain
- Productivity SaaS

---

# 8. Jira Clone

## basicPlan

Build a software project management platform with projects, epics, tickets, sprints, statuses, comments, and team roles.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS, dnd-kit
- Backend: Spring Boot
- Database: PostgreSQL
- Auth: JWT / Spring Security

## 1. Pre-Launch & Discovery

### Problem

Software teams need to track work, bugs, features, and sprints.

### Target Users

- Developers
- Product managers
- Student project teams
- Hackathon teams

### MVP Scope

- Create project
- Create tickets
- Assign tickets
- Set status
- Sprint board
- Comments
- Basic reporting

## 2. Planning & Design

### Core Pages

| Page | Purpose |
|---|---|
| Project Dashboard | Project overview |
| Backlog | All tickets |
| Sprint Board | Drag tickets across statuses |
| Ticket Detail | Description, comments, assignee |
| Reports | Burndown/basic stats |
| Settings | Members and roles |

### Database Tables

```text
User
- id
- name
- email
- passwordHash

Project
- id
- name
- key
- ownerId

ProjectMember
- projectId
- userId
- role

Sprint
- id
- projectId
- name
- startDate
- endDate
- status

Ticket
- id
- projectId
- sprintId
- title
- description
- type
- status
- priority
- assigneeId
- reporterId
- storyPoints

TicketComment
- id
- ticketId
- userId
- content
- createdAt
```

## 3. Development

### Phase 1: Setup

- Create frontend/backend
- Add auth
- Connect PostgreSQL

### Phase 2: Projects

- Create project
- Invite/add members
- Set roles
- Display project dashboard

### Phase 3: Tickets

- Create ticket
- Edit ticket
- Assign ticket
- Set priority/type/status

### Phase 4: Sprint Board

- Create sprint
- Add tickets to sprint
- Drag tickets across statuses
- Save new status

### Phase 5: Comments and Reports

- Add comments
- Add ticket activity log
- Show basic report: completed vs remaining

### Phase 6: Polish

- Add filters
- Add search
- Add labels
- Add keyboard shortcuts

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Create project | Project appears |
| Create ticket | Ticket appears in backlog |
| Assign ticket | Assignee updates |
| Drag ticket | Status changes |
| Add comment | Comment appears |
| Non-member opens project | Access denied |

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend
- Deploy backend
- Configure production database
- Add sample project
- Test full sprint workflow

## 6. Post-Launch

### Improvements

- GitHub integration
- AI ticket generation
- Sprint planning assistant
- Notifications
- Time tracking
- Advanced reports

### What This Leads To

- Project management SaaS
- AI project manager
- Engineering productivity tools
- Developer operating system

---

# 9. E-Commerce Marketplace

## basicPlan

Build a marketplace where sellers list products, buyers add products to cart, and users can simulate checkout.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS
- Backend: Spring Boot
- Database: PostgreSQL
- Auth: JWT
- Payments: Stripe test mode later

## 1. Pre-Launch & Discovery

### Problem

Buyers need a place to discover products and sellers need a way to sell items.

### Target Users

- Buyers
- Sellers
- Admins

### MVP Scope

- Browse products
- Search/filter products
- Product detail page
- Cart
- Checkout simulation
- Seller product management
- Order history

## 2. Planning & Design

### Core Pages

| Page | Purpose |
|---|---|
| Home | Featured products |
| Product Listing | Search/filter products |
| Product Detail | Product info and add to cart |
| Cart | Cart items and total |
| Checkout | Address and payment simulation |
| Seller Dashboard | Manage products/orders |
| Admin Dashboard | Manage platform |

### Database Tables

```text
User
- id
- name
- email
- passwordHash
- role

Product
- id
- sellerId
- name
- description
- price
- stock
- category
- imageUrl

CartItem
- id
- userId
- productId
- quantity

Order
- id
- userId
- totalAmount
- status
- createdAt

OrderItem
- id
- orderId
- productId
- quantity
- priceAtPurchase
```

## 3. Development

### Phase 1: Setup

- Create frontend/backend
- Add auth and roles
- Connect database

### Phase 2: Products

- Seller creates products
- Product listing page
- Product detail page
- Search/filter products

### Phase 3: Cart

- Add to cart
- Update quantity
- Remove item
- Calculate total

### Phase 4: Checkout

- Create order
- Reduce stock
- Clear cart
- Show order confirmation

### Phase 5: Seller Dashboard

- Seller sees orders for their products
- Seller edits products
- Seller updates stock

### Phase 6: Admin

- Admin views users/products/orders
- Admin can remove products

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| Seller adds product | Product appears publicly |
| Buyer adds to cart | Cart updates |
| Buyer changes quantity | Total updates |
| Checkout | Order created |
| Product out of stock | Cannot buy |
| Buyer accesses seller dashboard | Access denied |

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend and backend
- Set production DB
- Seed demo products
- Add test seller and buyer accounts
- Record demo checkout flow

## 6. Post-Launch

### Improvements

- Stripe payments
- Product reviews
- Wishlist
- Recommendations
- Seller analytics
- Order tracking

### What This Leads To

- Marketplace platforms
- Payment systems
- Inventory systems
- SaaS products

---

# 10. Social Media App

## basicPlan

Build a social platform where users create profiles, post updates, follow others, like posts, and comment.

**Recommended stack:**

- Frontend: Next.js, TypeScript, Tailwind CSS
- Backend: Spring Boot
- Database: PostgreSQL
- Auth: JWT
- Storage: Cloudinary/S3 for images

## 1. Pre-Launch & Discovery

### Problem

Users want to share updates and connect with others.

### Target Users

- Students
- Communities
- Creators

### MVP Scope

- Register/login
- Create profile
- Create posts
- Like posts
- Comment on posts
- Follow users
- Feed page

## 2. Planning & Design

### Core Pages

| Page | Purpose |
|---|---|
| Feed | Posts from followed users |
| Explore | Discover users/posts |
| Profile | User profile and posts |
| Post Detail | Comments and likes |
| Settings | Edit profile |
| Login/Register | Auth |

### Database Tables

```text
User
- id
- username
- email
- passwordHash
- bio
- avatarUrl

Post
- id
- authorId
- content
- imageUrl
- createdAt

Follow
- followerId
- followingId

Like
- userId
- postId

Comment
- id
- postId
- userId
- content
- createdAt
```

## 3. Development

### Phase 1: Setup

- Create frontend/backend
- Add auth
- Connect database

### Phase 2: Profiles

- Create profile page
- Edit bio/avatar
- Show user's posts

### Phase 3: Posts

- Create post
- Upload image optional
- Display posts
- Delete own post

### Phase 4: Social Features

- Follow/unfollow
- Like/unlike
- Comment
- Show counts

### Phase 5: Feed

- Show posts from followed users
- Add explore page
- Add pagination

### Phase 6: Polish

- Add loading states
- Add image previews
- Add notifications placeholder

## 4. Testing & Quality Assurance

| Test | Expected Result |
|---|---|
| User creates post | Post appears |
| User likes post | Like count updates |
| User unlikes post | Like removed |
| User comments | Comment appears |
| User follows someone | Their posts appear in feed |
| User deletes another user's post | Access denied |

## 5. Deployment & Launch

### Deployment Steps

- Deploy frontend/backend
- Configure image storage
- Seed demo users
- Test feed with multiple accounts

## 6. Post-Launch

### Improvements

- Notifications
- Direct messages
- Hashtags
- Repost/share
- Content moderation
- AI caption generator

### What This Leads To

- Community platforms
- Creator tools
- Realtime apps
- Recommendation feeds

---

# Recommended Build Order for Level 4

If you want to build these in the best learning order:

```text
1. Trello Clone
2. E-Commerce Marketplace
3. Airbnb Clone
4. Social Media App
5. Spotify Clone
6. Notion Clone
7. Discord Clone
8. Jira Clone
9. GitHub Clone
10. Uber Clone
```

This order grows your skills from standard full-stack CRUD into real-time systems, collaborative apps, platform engineering, and location-based products.

# Best First Level 4 Project

Start with **Trello Clone**.

It teaches:

```text
Authentication
CRUD
Nested data models
Drag and drop
Team workspaces
Task assignment
Comments
Permissions
Deployment
```

It also leads naturally into:

```text
Jira Clone
AI Project Manager
Developer Operating System
Hackathon Team Planner
Startup Task Platform
```
