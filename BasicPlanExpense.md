5. Expense Tracker
1. Pre-Launch & Discovery
Problem

Students need to track spending.

MVP Scope
Add expense
View expenses
View total spending
Filter by category
Delete expense
Save to file
2. Planning & Design
Data Model
class Expense {
    int id;
    String title;
    String category;
    double amount;
    String date;
}
Categories
Food
Transport
Rent
Shopping
Entertainment
Other
Menu
==== Expense Tracker ====
1. Add Expense
2. View Expenses
3. View Total
4. Filter By Category
5. Delete Expense
6. Exit
3. Development
Files
Expense.java
ExpenseService.java
FileStorage.java
Main.java
Build Order
Step	Task
1	Create Expense class
2	Add expense
3	View expenses
4	Calculate total
5	Filter by category
6	Save/load file
4. Testing & QA
Test	Expected
Add £10 food	Expense saved
Add negative amount	Error
View total	Correct sum
Filter food	Only food expenses
Delete expense	Removed from list
Restart app	Expenses load
5. Deployment & Launch
GitHub repo
README
Example terminal output
6. Post-Launch
Improvements
Monthly budget
Charts
CSV export
JavaFX dashboard
React frontend
Banking API integration
Leads To
Finance dashboard
Budgeting SaaS
Analytics apps