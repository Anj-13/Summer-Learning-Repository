7. Student Grade Tracker
1. Pre-Launch & Discovery
Problem

Students want to calculate grades and averages.

MVP Scope
Add module
Add assignment grade
View average
View highest/lowest grade
Delete grade
Save data
2. Planning & Design
Data Models
class Module {
    int id;
    String name;
    ArrayList<Grade> grades;
}
class Grade {
    int id;
    String assessmentName;
    double score;
    double weight;
}
3. Development
Menu
==== Grade Tracker ====
1. Add Module
2. Add Grade
3. View Module Average
4. View All Grades
5. Delete Grade
6. Exit
Build Order
Step	Task
1	Create Module and Grade classes
2	Add modules
3	Add grades
4	Calculate average
5	Save/load data
4. Testing & QA
Test	Expected
Add grade 80	Saved
Add negative score	Error
Add score over 100	Error
Weighted average	Correct calculation
Delete grade	Removed
5. Deployment & Launch
GitHub README
Explain grade calculation
Show sample data
6. Post-Launch
Improvements
Grade prediction
What-if calculator
Charts
React dashboard
AI study recommendation
Leads To
Student dashboard
Learning analytics
AI tutor