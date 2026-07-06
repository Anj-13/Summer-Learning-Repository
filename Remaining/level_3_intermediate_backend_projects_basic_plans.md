# Level 3 Intermediate Backend Projects — Professional Development Plans

These projects are designed for a student who already understands beginner programming and wants to move into serious backend development with Java, Spring Boot, databases, authentication, validation, and API design.

Each project includes:

- Project name
- basicPlan
- 1. Pre-Launch & Discovery
- 2. Planning & Design
- 3. Development
- 4. Testing & Quality Assurance
- 5. Deployment & Launch
- 6. Post-Launch

Recommended default stack:

```text
Language: Java
Backend: Spring Boot
Database: PostgreSQL or MySQL
ORM: Spring Data JPA / Hibernate
Security: Spring Security + JWT
Testing: JUnit, Mockito, Postman
API Docs: Swagger / OpenAPI
Deployment: Docker + Render/Railway/Fly.io/Azure
```

---

## 1. E-Commerce Backend API

### basicPlan

Build the backend for a small online store. Users can register, browse products, add items to a cart, place orders, and admins can manage products.

```text
Main learning: REST APIs, CRUD, database relationships, authentication, roles, order logic
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate
Estimated time: 3-5 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Small shops need a backend system to manage products, users, carts, and orders.

#### Target Users

- Customers
- Store admins
- Backend developer practising real-world API design

#### MVP Features

```text
User registration/login
Product browsing
Product details
Cart management
Checkout/order creation
Admin product CRUD
Order history
```

#### Out of Scope for MVP

```text
Real payment integration
Real delivery tracking
Recommendation engine
Multi-vendor support
```

### 2. Planning & Design

#### User Stories

```text
As a customer, I want to browse products so I can choose what to buy.
As a customer, I want to add products to my cart so I can prepare an order.
As an admin, I want to add products so the shop catalogue stays updated.
As a customer, I want to view past orders so I can track my purchases.
```

#### Core Entities

```text
User
Product
Category
Cart
CartItem
Order
OrderItem
```

#### Database Sketch

```text
User
- id
- name
- email
- passwordHash
- role

Product
- id
- name
- description
- price
- stockQuantity
- categoryId

Cart
- id
- userId

CartItem
- id
- cartId
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

#### API Endpoints

```text
POST /api/auth/register
POST /api/auth/login

GET /api/products
GET /api/products/{id}
POST /api/admin/products
PUT /api/admin/products/{id}
DELETE /api/admin/products/{id}

GET /api/cart
POST /api/cart/items
PUT /api/cart/items/{id}
DELETE /api/cart/items/{id}

POST /api/orders
GET /api/orders
GET /api/orders/{id}
```

### 3. Development

#### Suggested Package Structure

```text
com.example.ecommerce
├── auth
├── user
├── product
├── category
├── cart
├── order
├── config
├── exception
└── common
```

#### Build Steps

```text
1. Create Spring Boot project
2. Connect PostgreSQL
3. Create entities and repositories
4. Build product CRUD
5. Build register/login
6. Add JWT authentication
7. Add customer cart logic
8. Add order creation logic
9. Add admin-only product management
10. Add validation and exception handling
11. Add Swagger documentation
```

#### First Coding Task

Start with product CRUD because it gives quick progress.

```text
Create Product entity
Create ProductRepository
Create ProductService
Create ProductController
Test GET /api/products in Postman
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
Register new user
Login with correct credentials
Login with wrong password
Admin creates product
Customer views product
Customer adds product to cart
Customer checks out
Order total calculates correctly
Stock decreases after order
```

#### Automated Tests

```text
ProductServiceTest
CartServiceTest
OrderServiceTest
AuthServiceTest
```

#### Edge Cases

```text
Product does not exist
Cart item quantity is negative
User orders more than available stock
Unauthorised user tries admin route
Duplicate email registration
```

### 5. Deployment & Launch

#### Deployment Checklist

```text
Create production PostgreSQL database
Add environment variables
Dockerise backend
Deploy backend
Test API with deployed URL
Add Swagger link to README
```

#### README Sections

```text
Project overview
Features
Tech stack
Database schema
API endpoints
How to run locally
Environment variables
Screenshots/Postman examples
Future improvements
```

### 6. Post-Launch

#### Improvements

```text
Stripe payment simulation
Product reviews
Discount codes
Wishlist
Email order confirmation
React/Next.js frontend
Admin dashboard
```

#### What This Leads To

```text
Enterprise backend development
FinTech transaction logic
Inventory systems
Full e-commerce platforms
Microservices architecture
```

---

## 2. Banking API

### basicPlan

Build a secure banking simulation backend where users can create accounts, deposit, withdraw, transfer money, and view transaction history.

```text
Main learning: transactions, validation, security, database consistency
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate+
Estimated time: 3-5 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Banking systems need secure and accurate handling of balances and transactions.

#### Target Users

- Bank customers
- Admin staff
- Backend learners practising business-critical logic

#### MVP Features

```text
Register/login
Create bank account
Deposit money
Withdraw money
Transfer between accounts
View balance
View transaction history
```

#### Out of Scope for MVP

```text
Real payment rails
Open Banking integration
Credit scoring
Fraud detection
```

### 2. Planning & Design

#### User Stories

```text
As a user, I want to deposit money so my account balance increases.
As a user, I want to transfer money so I can send money to another account.
As a user, I want to view transactions so I can track account activity.
```

#### Entities

```text
User
BankAccount
Transaction
```

#### Database Sketch

```text
User
- id
- fullName
- email
- passwordHash
- role

BankAccount
- id
- accountNumber
- userId
- balance
- accountType
- status
- createdAt

Transaction
- id
- fromAccountId
- toAccountId
- type
- amount
- description
- createdAt
```

#### API Endpoints

```text
POST /api/auth/register
POST /api/auth/login

POST /api/accounts
GET /api/accounts
GET /api/accounts/{accountNumber}

POST /api/accounts/{accountNumber}/deposit
POST /api/accounts/{accountNumber}/withdraw
POST /api/accounts/transfer
GET /api/accounts/{accountNumber}/transactions
```

### 3. Development

#### Suggested Package Structure

```text
com.example.banking
├── auth
├── user
├── account
├── transaction
├── security
├── exception
└── config
```

#### Build Steps

```text
1. Setup Spring Boot and PostgreSQL
2. Create User entity and auth
3. Create BankAccount entity
4. Generate unique account numbers
5. Implement deposit
6. Implement withdraw
7. Implement transfer using @Transactional
8. Implement transaction history
9. Add validation and error handling
10. Add JWT protection
```

#### First Coding Task

```text
Create BankAccount entity
Create account number generator
Create POST /api/accounts endpoint
Test account creation in Postman
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
Create account
Deposit £100
Withdraw £30
Transfer £20 to another user
View transaction history
Try withdrawing more than balance
Try accessing another user's account
```

#### Automated Tests

```text
Deposit increases balance
Withdraw decreases balance
Transfer updates both accounts
Transfer fails if insufficient funds
Transaction record is created
```

#### Edge Cases

```text
Negative deposit
Negative withdrawal
Insufficient balance
Invalid account number
User attempts to access account they do not own
Concurrent transfers
```

### 5. Deployment & Launch

#### Deployment Checklist

```text
Use production database
Hide JWT secret in environment variables
Add Dockerfile
Deploy backend
Test all endpoints with Postman collection
```

#### README Sections

```text
Banking API overview
Security notes
Transaction flow
API endpoints
How to run locally
Testing guide
Future improvements
```

### 6. Post-Launch

#### Improvements

```text
Admin dashboard
Account freezing
Monthly statements
PDF statement generation
Interest calculation
Fraud rule alerts
React frontend
```

#### What This Leads To

```text
FinTech systems
Payment platforms
Transaction-safe backend design
Database consistency skills
```

---

## 3. Inventory Management System

### basicPlan

Build a backend for tracking products, suppliers, stock levels, and stock movements.

```text
Main learning: CRUD, stock logic, reporting, relational databases
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate
Estimated time: 2-4 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Businesses need to know what stock they have, what is running low, and when items move in or out.

#### Target Users

- Shop owners
- Warehouse staff
- Admin users

#### MVP Features

```text
Add products
Update product details
Track stock quantity
Record stock-in
Record stock-out
View low-stock products
Manage suppliers
```

### 2. Planning & Design

#### Entities

```text
Product
Supplier
StockMovement
User
```

#### Database Sketch

```text
Product
- id
- name
- sku
- description
- quantity
- reorderLevel
- supplierId

Supplier
- id
- name
- email
- phone

StockMovement
- id
- productId
- type
- quantity
- reason
- createdAt
```

#### API Endpoints

```text
GET /api/products
POST /api/products
PUT /api/products/{id}
DELETE /api/products/{id}

POST /api/products/{id}/stock-in
POST /api/products/{id}/stock-out
GET /api/products/low-stock

GET /api/suppliers
POST /api/suppliers
```

### 3. Development

#### Build Steps

```text
1. Create Product entity
2. Create Supplier entity
3. Create product CRUD
4. Create supplier CRUD
5. Implement stock-in logic
6. Implement stock-out logic
7. Record stock movements
8. Add low-stock endpoint
9. Add validation
10. Add Swagger docs
```

#### First Coding Task

```text
Build Product CRUD first.
Then add stock-in and stock-out methods.
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
Create product
Update product quantity
Stock-in increases quantity
Stock-out decreases quantity
Stock-out fails if not enough stock
Low-stock endpoint returns correct products
```

#### Edge Cases

```text
Duplicate SKU
Negative stock movement
Product without supplier
Deleting product with stock history
```

### 5. Deployment & Launch

#### Checklist

```text
Create cloud PostgreSQL database
Deploy Spring Boot API
Publish API docs
Add Postman collection
```

### 6. Post-Launch

#### Improvements

```text
Barcode scanning
CSV import/export
Supplier order generation
Analytics dashboard
Frontend admin panel
```

#### What This Leads To

```text
ERP systems
Warehouse systems
Supply chain software
Business backend development
```

---

## 4. Booking System API

### basicPlan

Build a backend where users can book time slots for services such as study rooms, gym sessions, barber appointments, or tutoring sessions.

```text
Main learning: availability, scheduling, time validation, conflict prevention
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate+
Estimated time: 3-5 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Services need a way to manage bookings without double-booking the same time slot.

#### Target Users

- Customers/students
- Service providers/admins

#### MVP Features

```text
Register/login
View available slots
Create booking
Cancel booking
Admin creates services/resources
Admin views all bookings
Prevent double booking
```

### 2. Planning & Design

#### Entities

```text
User
ServiceResource
TimeSlot
Booking
```

#### Database Sketch

```text
ServiceResource
- id
- name
- description
- location

TimeSlot
- id
- resourceId
- startTime
- endTime
- available

Booking
- id
- userId
- resourceId
- startTime
- endTime
- status
- createdAt
```

#### API Endpoints

```text
POST /api/auth/register
POST /api/auth/login

GET /api/resources
POST /api/admin/resources

GET /api/resources/{id}/availability
POST /api/bookings
GET /api/bookings/my
DELETE /api/bookings/{id}
GET /api/admin/bookings
```

### 3. Development

#### Build Steps

```text
1. Setup auth
2. Create resource CRUD
3. Create booking entity
4. Build availability query
5. Implement booking creation
6. Prevent time conflicts
7. Implement cancellation
8. Add admin routes
```

#### First Coding Task

```text
Create Resource entity and CRUD.
Then create Booking entity and test creating bookings manually.
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
User creates booking
User cancels booking
Two users try same slot
Admin views all bookings
Unavailable slot does not show as free
```

#### Edge Cases

```text
End time before start time
Booking in the past
Overlapping booking
User cancels someone else's booking
```

### 5. Deployment & Launch

#### Checklist

```text
Deploy backend
Create production database
Add sample resources
Document booking rules
Add Postman examples
```

### 6. Post-Launch

#### Improvements

```text
Email reminders
Calendar integration
Recurring bookings
Payment deposit
React frontend
Smart campus room booking version
```

#### What This Leads To

```text
Calendar systems
Hotel reservation platforms
Healthcare appointment systems
Smart campus platforms
```

---

## 5. Hotel Reservation API

### basicPlan

Build a hotel booking backend where users can search rooms, book stays, cancel reservations, and admins can manage rooms.

```text
Main learning: date ranges, availability logic, pricing, reservation workflow
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate+
Estimated time: 4-6 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Hotels need to manage room availability and reservations across date ranges.

#### Target Users

- Guests
- Hotel admins

#### MVP Features

```text
User registration/login
View rooms
Search available rooms by dates
Create reservation
Cancel reservation
Admin manages rooms
View booking history
```

### 2. Planning & Design

#### Entities

```text
User
Room
Reservation
PaymentRecord optional
```

#### Database Sketch

```text
Room
- id
- roomNumber
- type
- pricePerNight
- capacity
- status

Reservation
- id
- userId
- roomId
- checkInDate
- checkOutDate
- totalPrice
- status
- createdAt
```

#### API Endpoints

```text
GET /api/rooms
GET /api/rooms/available?checkIn=&checkOut=
POST /api/admin/rooms
PUT /api/admin/rooms/{id}
DELETE /api/admin/rooms/{id}

POST /api/reservations
GET /api/reservations/my
DELETE /api/reservations/{id}
```

### 3. Development

#### Build Steps

```text
1. Create Room CRUD
2. Create Reservation entity
3. Build date availability query
4. Calculate total price
5. Prevent overlapping reservations
6. Add auth and user reservation history
7. Add admin role
```

#### First Coding Task

```text
Build Room entity and RoomController.
Then create available rooms endpoint.
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
Search available room
Book room for valid dates
Try booking same room for overlapping dates
Cancel booking
Check room becomes available again
```

#### Edge Cases

```text
Check-out before check-in
Same-day booking rules
Overlapping date ranges
Room under maintenance
User cancels another user's reservation
```

### 5. Deployment & Launch

#### Checklist

```text
Deploy with cloud database
Seed sample rooms
Publish Swagger docs
Add README with booking examples
```

### 6. Post-Launch

#### Improvements

```text
Payment simulation
Room images
Discount codes
Admin analytics
Review system
Frontend booking website
```

#### What This Leads To

```text
Travel tech
Booking platforms
Calendar availability systems
Enterprise reservation software
```

---

## 6. Social Media API

### basicPlan

Build a backend for a small social media app where users can create posts, follow others, like posts, and comment.

```text
Main learning: user relationships, feeds, pagination, content APIs
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate+
Estimated time: 4-6 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Users want to share updates and interact with friends/followers.

#### Target Users

- Social users
- Students building a backend similar to Twitter/LinkedIn basics

#### MVP Features

```text
Register/login
Create profile
Create posts
View feed
Like posts
Comment on posts
Follow/unfollow users
```

### 2. Planning & Design

#### Entities

```text
User
Profile
Post
Comment
Like
Follow
```

#### Database Sketch

```text
Post
- id
- userId
- content
- createdAt

Comment
- id
- postId
- userId
- content
- createdAt

Like
- id
- postId
- userId

Follow
- id
- followerId
- followingId
```

#### API Endpoints

```text
POST /api/auth/register
POST /api/auth/login

GET /api/users/{id}
POST /api/posts
GET /api/posts/feed
GET /api/posts/{id}
DELETE /api/posts/{id}

POST /api/posts/{id}/likes
DELETE /api/posts/{id}/likes
POST /api/posts/{id}/comments
GET /api/posts/{id}/comments

POST /api/users/{id}/follow
DELETE /api/users/{id}/follow
```

### 3. Development

#### Build Steps

```text
1. Build auth
2. Build profile system
3. Build post CRUD
4. Build comments
5. Build likes
6. Build follow system
7. Build feed endpoint
8. Add pagination
```

#### First Coding Task

```text
Build user auth first.
Then create Post entity and POST /api/posts.
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
User creates post
Another user likes post
User comments on post
User follows another user
Feed shows followed users' posts
User cannot delete another user's post
```

#### Edge Cases

```text
Duplicate like
Following yourself
Empty post content
Very long comments
Pagination with no posts
```

### 5. Deployment & Launch

#### Checklist

```text
Deploy API
Seed demo users and posts
Add Swagger docs
Add Postman collection
```

### 6. Post-Launch

#### Improvements

```text
Image uploads
Hashtags
Notifications
Direct messages
Search
Recommendation feed
React/Next.js frontend
```

#### What This Leads To

```text
Large-scale APIs
Recommendation systems
Real-time apps
Community platforms
```

---

## 7. Food Delivery Backend

### basicPlan

Build a backend for a mini Deliveroo/Uber Eats-style app with restaurants, menus, carts, orders, and delivery status.

```text
Main learning: multi-entity business workflows, order status, role-based access
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate+
Estimated time: 5-7 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Food delivery apps need to connect customers, restaurants, menus, and orders.

#### Target Users

- Customers
- Restaurant admins
- Platform admins

#### MVP Features

```text
Register/login
Browse restaurants
View menu items
Add items to cart
Place order
Track order status
Restaurant updates order status
```

### 2. Planning & Design

#### Entities

```text
User
Restaurant
MenuItem
Cart
CartItem
Order
OrderItem
```

#### Database Sketch

```text
Restaurant
- id
- name
- address
- cuisineType
- ownerId

MenuItem
- id
- restaurantId
- name
- description
- price
- available

Order
- id
- userId
- restaurantId
- totalAmount
- status
- createdAt
```

#### API Endpoints

```text
GET /api/restaurants
GET /api/restaurants/{id}/menu
POST /api/restaurants
POST /api/restaurants/{id}/menu

POST /api/cart/items
GET /api/cart
POST /api/orders
GET /api/orders/my
PUT /api/restaurant/orders/{id}/status
```

### 3. Development

#### Build Steps

```text
1. Build auth and roles
2. Build restaurant CRUD
3. Build menu item CRUD
4. Build cart
5. Build order creation
6. Build order status updates
7. Add validation and access control
```

#### First Coding Task

```text
Create Restaurant and MenuItem entities.
Build endpoint to list restaurants and menu items.
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
Customer views restaurants
Restaurant owner adds menu item
Customer adds item to cart
Customer places order
Restaurant updates order status
Customer views updated order
```

#### Edge Cases

```text
Cart contains items from multiple restaurants
Unavailable menu item
Restaurant owner edits another restaurant
Invalid order status transition
```

### 5. Deployment & Launch

#### Checklist

```text
Deploy backend
Seed sample restaurants
Document roles
Add Postman collection
```

### 6. Post-Launch

#### Improvements

```text
Delivery driver role
Live tracking simulation
Payments
Ratings/reviews
Notifications
Frontend app
Microservices version
```

#### What This Leads To

```text
Marketplace platforms
Distributed systems
Order management systems
Uber-style apps
```

---

## 8. Event Management API

### basicPlan

Build a backend where users can create events, register for events, manage attendees, and search upcoming events.

```text
Main learning: event workflows, registration limits, search/filtering, role permissions
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate
Estimated time: 3-5 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Organisers need a system for creating events and managing attendance.

#### Target Users

- Event organisers
- Attendees
- Admin users

#### MVP Features

```text
Register/login
Create event
View events
Search events
Register for event
Cancel registration
View attendee list
```

### 2. Planning & Design

#### Entities

```text
User
Event
EventRegistration
```

#### Database Sketch

```text
Event
- id
- title
- description
- location
- startTime
- endTime
- capacity
- organiserId

EventRegistration
- id
- eventId
- userId
- status
- registeredAt
```

#### API Endpoints

```text
POST /api/events
GET /api/events
GET /api/events/{id}
PUT /api/events/{id}
DELETE /api/events/{id}

POST /api/events/{id}/register
DELETE /api/events/{id}/register
GET /api/events/{id}/attendees
```

### 3. Development

#### Build Steps

```text
1. Build auth
2. Build event CRUD
3. Build event search/filtering
4. Build registration logic
5. Prevent over-capacity registration
6. Add organiser-only attendee list
```

#### First Coding Task

```text
Create Event entity and GET /api/events endpoint.
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
Organiser creates event
User registers
User cancels registration
Capacity limit blocks extra users
Only organiser sees attendee list
```

#### Edge Cases

```text
Event in the past
End time before start time
Duplicate registration
Capacity reached
Unauthorised event editing
```

### 5. Deployment & Launch

#### Checklist

```text
Deploy API
Seed sample events
Publish Swagger docs
Add README
```

### 6. Post-Launch

#### Improvements

```text
QR code tickets
Email confirmations
Calendar export
Payment tickets
Frontend event website
```

#### What This Leads To

```text
Ticketing platforms
University society event tools
Conference management systems
```

---

## 9. Job Application Tracker API

### basicPlan

Build a backend where users can track job applications, statuses, notes, contacts, deadlines, and interviews.

```text
Main learning: CRUD, filtering, reminders, personal productivity backend
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate
Estimated time: 2-4 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Students applying for internships need to track many applications and deadlines.

#### Target Users

- Students
- Job seekers

#### MVP Features

```text
Register/login
Add job application
Update status
Add notes
Add interview date
Filter by status
View upcoming deadlines
```

### 2. Planning & Design

#### Entities

```text
User
JobApplication
ApplicationNote
```

#### Database Sketch

```text
JobApplication
- id
- userId
- company
- role
- location
- applicationUrl
- status
- deadline
- interviewDate
- createdAt

ApplicationNote
- id
- applicationId
- content
- createdAt
```

#### API Endpoints

```text
POST /api/applications
GET /api/applications
GET /api/applications/{id}
PUT /api/applications/{id}
DELETE /api/applications/{id}

POST /api/applications/{id}/notes
GET /api/applications/status/{status}
GET /api/applications/upcoming
```

### 3. Development

#### Build Steps

```text
1. Build auth
2. Create application CRUD
3. Add status enum
4. Add notes
5. Add filtering by status
6. Add upcoming deadline endpoint
```

#### First Coding Task

```text
Create JobApplication entity and CRUD endpoints.
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
Add application
Update status from Applied to Interview
Add note
Filter by status
View upcoming deadlines
User cannot access another user's applications
```

#### Edge Cases

```text
Invalid status
Deadline in the past
Empty company name
Invalid URL
```

### 5. Deployment & Launch

#### Checklist

```text
Deploy API
Add Swagger docs
Add README with sample workflow
```

### 6. Post-Launch

#### Improvements

```text
Email reminders
CV version tracking
Company contact management
Kanban board frontend
AI cover letter helper
```

#### What This Leads To

```text
CRM systems
Productivity SaaS
Recruitment platforms
Student career tools
```

---

## 10. Online Course Platform Backend

### basicPlan

Build the backend for a mini Udemy/Coursera-style platform where instructors create courses and students enrol.

```text
Main learning: role-based access, enrolments, progress tracking, content structure
Language: Java
Backend: Spring Boot
Database: PostgreSQL
Difficulty: Level 3 Intermediate+
Estimated time: 4-6 weeks
```

### 1. Pre-Launch & Discovery

#### Problem

Online learning platforms need to manage courses, lessons, enrolments, and progress.

#### Target Users

- Students
- Instructors
- Admins

#### MVP Features

```text
Register/login
Instructor creates course
Instructor adds lessons
Student browses courses
Student enrols in course
Student marks lessons complete
View course progress
```

### 2. Planning & Design

#### Entities

```text
User
Course
Lesson
Enrollment
LessonProgress
```

#### Database Sketch

```text
Course
- id
- title
- description
- instructorId
- category
- createdAt

Lesson
- id
- courseId
- title
- contentUrl
- lessonOrder

Enrollment
- id
- userId
- courseId
- enrolledAt

LessonProgress
- id
- enrollmentId
- lessonId
- completed
- completedAt
```

#### API Endpoints

```text
POST /api/courses
GET /api/courses
GET /api/courses/{id}
POST /api/courses/{id}/lessons

POST /api/courses/{id}/enrol
GET /api/enrolments/my
POST /api/lessons/{id}/complete
GET /api/courses/{id}/progress
```

### 3. Development

#### Build Steps

```text
1. Build auth with roles
2. Build course CRUD
3. Build lesson CRUD
4. Build enrolment logic
5. Build lesson progress
6. Add access control
7. Add progress calculation
```

#### First Coding Task

```text
Create Course and Lesson entities.
Build GET /api/courses and POST /api/courses.
```

### 4. Testing & Quality Assurance

#### Manual Tests

```text
Instructor creates course
Instructor adds lessons
Student enrols
Student completes lesson
Progress percentage updates
Student cannot edit instructor content
```

#### Edge Cases

```text
Duplicate enrolment
Lesson from another course
Course without lessons
Unauthorised lesson access
```

### 5. Deployment & Launch

#### Checklist

```text
Deploy backend
Seed demo courses
Add API documentation
Create Postman collection
```

### 6. Post-Launch

#### Improvements

```text
Video upload
Quizzes
Certificates
Course reviews
Payment simulation
React frontend
AI tutor assistant
```

#### What This Leads To

```text
EdTech platforms
Learning management systems
AI study assistants
Student analytics dashboards
```

---

# Recommended Build Order

If you want the smoothest learning curve, build them in this order:

```text
1. Job Application Tracker API
2. Inventory Management System
3. Event Management API
4. E-Commerce Backend API
5. Booking System API
6. Hotel Reservation API
7. Banking API
8. Social Media API
9. Online Course Platform Backend
10. Food Delivery Backend
```

# Universal Backend Checklist For Every Level 3 Project

Use this checklist for any project you pick:

```text
[ ] Create GitHub repository
[ ] Create Spring Boot project
[ ] Connect PostgreSQL
[ ] Create entities
[ ] Create repositories
[ ] Create services
[ ] Create controllers
[ ] Add DTOs
[ ] Add validation
[ ] Add exception handling
[ ] Add authentication
[ ] Add role-based permissions if needed
[ ] Test with Postman
[ ] Add unit tests
[ ] Add Swagger/OpenAPI
[ ] Add Dockerfile
[ ] Deploy backend
[ ] Write README
```

# Best First Level 3 Project

Start with:

```text
Job Application Tracker API
```

Why:

```text
It is useful for you personally.
It teaches CRUD, auth, filtering, ownership rules, notes, status workflows, and deployment.
It can later become a React/Next.js dashboard.
It can grow into an AI internship assistant.
```

