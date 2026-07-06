10. Habit Tracker
1. Pre-Launch & Discovery
Problem

Users want to build habits and track streaks.

MVP Scope
Add habit
Mark habit done today
View streak
View habit list
Delete habit
Save data
2. Planning & Design
Data Model
class Habit {
    int id;
    String name;
    ArrayList<String> completedDates;
}
Menu
==== Habit Tracker ====
1. Add Habit
2. View Habits
3. Mark Done Today
4. View Streak
5. Delete Habit
6. Exit
3. Development
Build Order
Step	Task
1	Create Habit class
2	Add habits
3	Mark done
4	Prevent duplicate completion for same day
5	Calculate streak
6	Save/load file
4. Testing & QA
Test	Expected
Add habit	Habit appears
Mark done today	Date saved
Mark same habit twice	Error
View streak	Correct count
Delete habit	Removed
Restart app	Habits load
5. Deployment & Launch
Push to GitHub
Add README
Add future roadmap
6. Post-Launch
Improvements
Calendar view
Weekly analytics
Reminder system
React dashboard
AI habit coach
Leads To
Productivity apps
Health apps
Personal analytics