8. Quiz App
1. Pre-Launch & Discovery
Problem

A quiz app helps users practise topics and helps you learn control flow.

MVP Scope
Show questions
Accept answers
Calculate score
Show correct answers
Restart quiz
2. Planning & Design
Data Model
class Question {
    int id;
    String questionText;
    String[] options;
    int correctAnswerIndex;
}
Menu
==== Quiz App ====
1. Start Quiz
2. View High Score
3. Exit
3. Development
Files
Question.java
QuizService.java
ScoreManager.java
Main.java
Build Order
Step	Task
1	Create question list
2	Display question
3	Accept answer
4	Calculate score
5	Show final result
6	Save high score
4. Testing & QA
Test	Expected
Correct answer	Score increases
Wrong answer	Score unchanged
Invalid option	Ask again
Finish quiz	Final score shown
Restart quiz	Score resets
5. Deployment & Launch
Push to GitHub
Add sample quiz questions
Add README
6. Post-Launch
Improvements
Categories
Difficulty levels
Timer
Leaderboard
Question file import
Web version
Leads To
Learning platforms
Interview prep apps
AI quiz generator