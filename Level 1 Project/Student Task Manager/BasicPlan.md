# Student Task Manager
**A Console-Based Task Tracking Application**

## 1. Pre-Launch & Discovery

### Problem Statement
Students frequently forget deadlines, assignments, and revision tasks due to poor organization and lack of a centralized tracking system. This leads to missed submissions, increased stress, and lower academic performance.

### Target User
A student who wants a simple, reliable way to track academic work without the complexity of full project management tools. The user values speed, simplicity, and clarity.

### Core Value Proposition
Help users instantly know:

- What do I need to do?
- When is it due?
- Have I completed it?

This eliminates mental overhead and reduces anxiety about forgotten tasks.

### MVP Scope
Build a console-based application first to establish core functionality before adding complexity.

Users can:

- Add task
- View all tasks
- Mark task complete
- Delete task
- Filter completed/incomplete
- Save tasks to file
- Load tasks from file on startup

### Success Criteria
- User can add a task and see it appear immediately
- User can mark tasks complete and track progress
- Tasks persist between application sessions
- Application handles invalid input gracefully

---

## 2. Planning & Design

### User Stories

> As a student, I want to add a task so I can remember my work.
>
> As a student, I want to mark a task complete so I can track progress.
>
> As a student, I want to view incomplete tasks so I know what to focus on.
>
> As a student, I want to delete tasks I no longer need so my list stays clean.
>
> As a student, I want my tasks to save automatically so I don't lose my work.

### Data Model

```
class Task {
    int id;
    String title;
    String description;
    LocalDate deadline;
    PriorityOption priority;  // HIGH, MEDIUM, LOW
    boolean completed;
}
```

#### Field Descriptions

| Field       | Type      | Description                                    |
|-------------|-----------|------------------------------------------------|
| id          | int       | Unique identifier assigned when task is added  |
| title       | String    | Short name for the task (required)             |
| description | String    | Additional details (optional)                  |
| deadline    | LocalDate  | Due date as LocalDate object                    |
| priority    | PriorityOption | HIGH, MEDIUM, or LOW (enum)                |
| completed   | boolean   | true if task is finished, false otherwise      |

### Menu Design

```
==== Student Task Manager ====
1. Add Task
2. View All Tasks
3. View Incomplete Tasks
4. View Complete Tasks
5. Mark Task Complete
6. Delete Task
7. Load from File
8. Clear All Tasks
9. Exit (Auto-Save)

Choose an option:
```

### File Storage Format

Use a simple pipe-delimited text file for data persistence:

```
1|Math Homework|Finish algebra questions|2026-07-10|HIGH|false
2|Read Chapter 3|Complete comprehension questions|2026-07-12|MEDIUM|false
3|Submit Essay|Final draft with citations|2026-07-15|HIGH|true
```

Each line represents one task with fields separated by the pipe character (|). This format is easy to read, write, and parse.

---

## 3. Development

### Suggested Files

| File           | Purpose                                        |
|----------------|------------------------------------------------|
| Task.java      | Defines the Task data structure                |
| TaskManager.java | Manages task operations (add, delete, complete) |
| FileStorage.java | Handles reading and writing tasks to file    |
| Main.java      | Contains the main loop and user interface      |

### Build Order

| Step | Task                                           |
|------|------------------------------------------------|
| 1    | Create Task class with all fields and getters  |
| 2    | Create TaskManager class with ArrayList<Task>  |
| 3    | Create FileStorage class with save/load methods|
| 4    | Create menu in Main with loop                  |
| 5    | Implement add task functionality               |
| 6    | Implement view all tasks                      |
| 7    | Implement view incomplete tasks               |
| 8    | Implement mark complete functionality         |
| 9    | Implement delete task                         |
| 10   | Implement save to file on exit                |
| 11   | Implement load from file on startup           |
| 12   | Add input validation and error handling       |

### Starter Feature Checklist

- [x] Add task
- [x] View tasks
- [x] Mark complete
- [x] Delete task
- [x] Save to file
- [x] Load from file when app starts
- [x] View incomplete tasks
- [x] Input validation
- [x] Error handling
- [x] User-friendly menu

### Development Tips

- Start with the simplest implementation and add features incrementally
- Test each feature immediately after implementing it
- Commit to version control after each working feature
- Write comments to explain complex logic
- Use meaningful variable and method names
- Keep methods focused on a single responsibility

---

## 4. Testing & Quality Assurance

### Manual Test Cases

| Test                                        | Expected Result                                 |
|---------------------------------------------|------------------------------------------------|
| Add task with valid title                   | Task appears in list with generated ID         |
| Add task with empty title                   | Show error message, do not add task            |
| Add task with missing deadline              | Set default deadline or prompt user            |
| Mark task complete                          | Status changes to complete in the list         |
| Mark already completed task                 | Show message that task is already complete     |
| Delete task by valid ID                     | Task removed from list                         |
| Delete task by invalid ID                   | Show error message, list unchanged             |
| Save tasks to file                          | File created with all current tasks            |
| Load tasks from file                        | All tasks restored correctly                   |
| Restart app with saved file                 | Saved tasks load automatically                 |
| View incomplete tasks                       | Only show tasks with completed = false         |
| View complete tasks                         | Only show tasks with completed = true          |

### Edge Cases to Handle

- User enters letters instead of numbers for menu choices
- User enters letters instead of ID for task operations
- User deletes a task ID that does not exist
- User marks complete a task that is already complete
- File does not exist when loading (handle gracefully)
- File contains malformed data (handle gracefully)
- Empty task list operations
- Large number of tasks performance
- Special characters in task titles and descriptions

### Defensive Programming Checklist

- [x] Validate all user input
- [x] Handle null and empty values
- [x] Catch and handle exceptions
- [x] Provide clear error messages
- [x] Confirm destructive operations
- [x] Use try-catch blocks for file operations
- [x] Log errors for debugging

---

## 5. Deployment & Launch

### Level 1 Deployment Plan

- Run application in terminal or command prompt
- Package as executable .jar file for distribution
- Upload source code to GitHub repository
- Create comprehensive README file

### README Structure

```markdown
# Student Task Manager

## Project Description
A console-based task management application designed for students to track assignments, deadlines, and revision tasks.

## Features
- Add tasks with title, description, deadline, and priority
- View all tasks or filter by completion status
- Mark tasks complete
- Delete tasks
- Persistent storage with file save/load

## How to Run
1. Clone the repository
2. Compile: javac *.java
3. Run: java Main
4. Or run the .jar file: java -jar student-task-manager.jar

## Requirements
- Java 8 or higher
- Command line / terminal access

## Screenshots
[Add terminal screenshots here]

## What I Learned
- Java fundamentals and OOP principles
- File I/O operations
- User input handling and validation
- Application structure and organization
- Version control with Git
- Debugging and testing strategies

## Future Improvements
- Add due date sorting
- Add priority sorting
- Add search functionality
- Add categories/labels
- Add GUI with JavaFX
- Convert to Spring Boot API
- Add React frontend
- Add reminder notifications
- Add recurring tasks
- Add subtasks
```

---

## 6. Post-Launch & Maintenance

### Feature Improvement Roadmap

| Priority | Improvement                   | Difficulty |
|----------|-------------------------------|------------|
| High     | Add due date sorting          | Easy       |
| High     | Add priority sorting          | Easy       |
| High     | Add search functionality      | Medium     |
| Medium   | Add categories                | Medium     |
| Medium   | Add reminders/notifications   | Medium     |
| Low      | Add GUI with JavaFX           | Hard       |
| Low      | Convert to Spring Boot API    | Hard       |
| Low      | Convert to React frontend     | Hard       |

### What This Project Leads To

This foundational project can evolve into progressively more complex applications:

1. Todo app (current)
2. Project management application
3. Kanban board
4. Jira clone
5. AI-powered task planner
6. Full-stack web application
7. Mobile application
8. Enterprise project management system

## Learned Tech Stack

### Programming Language
- Java (Core)

### Concepts Applied
- Object-Oriented Programming (OOP)
- Encapsulation, Inheritance, Polymorphism
- Collections Framework (ArrayList)
- File I/O Operations
- Exception Handling
- User Interface (Console-based)
- Version Control (Git)

### Tools Used
- Java Development Kit (JDK)
- Integrated Development Environment (IDE)
- Command Line / Terminal
- Git and GitHub
- Text Editor

### Next Technologies to Learn
- JavaFX for GUI development
- SQL and JDBC for database integration
- Spring Boot for web API development
- React for frontend development
- Docker for containerization
- AWS or Azure for cloud deployment
