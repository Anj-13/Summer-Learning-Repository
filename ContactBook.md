9. Contact Book
1. Pre-Launch & Discovery
Problem

Users need to store and search contacts.

MVP Scope
Add contact
View contacts
Search contact
Edit contact
Delete contact
Save contacts
2. Planning & Design
Data Model
class Contact {
    int id;
    String name;
    String phone;
    String email;
}
Menu
==== Contact Book ====
1. Add Contact
2. View Contacts
3. Search Contact
4. Edit Contact
5. Delete Contact
6. Exit
3. Development
Build Order
Step	Task
1	Create Contact class
2	Add contact
3	View contacts
4	Search by name
5	Edit contact
6	Delete contact
7	Save/load file
4. Testing & QA
Test	Expected
Add contact	Contact appears
Empty name	Error
Invalid email	Warning
Search existing name	Contact found
Delete contact	Removed
Restart app	Contacts load
5. Deployment & Launch
GitHub repo
README
Example data
6. Post-Launch
Improvements
Groups
Birthday reminders
CSV import/export
JavaFX UI
Spring Boot contact API
Leads To
CRM systems
User management
Messaging apps