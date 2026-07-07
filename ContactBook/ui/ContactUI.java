package ui;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import model.Contact;
import service.ContactService;
import storage.FileStorage;

public class ContactUI {
    private ContactService service;
    private FileStorage fs;
    private Scanner scan;

    public ContactUI() {
        this.scan = new Scanner(System.in);
        this.service = new ContactService();
        this.fs = new FileStorage("data/contacts.txt", "|");
        
        // Load existing contacts
        List<Contact> loadedContacts = fs.loadContacts();
        if (!loadedContacts.isEmpty()) {
            // Set the contacts in service
            service.setContacts(loadedContacts);
            // Set nextId to highest ID + 1
            int maxId = loadedContacts.stream()
                .mapToInt(Contact::getId)
                .max()
                .orElse(-1);
            service.setNextId(maxId + 1);
            System.out.println("Loaded " + loadedContacts.size() + " contacts.");
        }
    }

     public void start(){
        System.out.println("Welcome to Contact Book!");
        
        while (true) {
            displayMenu();
            int choice = getIntInput("Enter your choice: ");
            handleChoice(choice);
        }
     }

     private void displayMenu() {
        System.out.print("==== Contact Book ====\r\n" + //
                        "1. Add Contact\r\n" + //
                        "2. View Contacts\r\n" + //
                        "3. Search Contact\r\n" + //
                        "4. Edit Contact\r\n" + //
                        "5. Delete Contact\r\n" + //
                        "6. Exit");
     }

     private void handleChoice(int choice) {
        switch (choice) {
            case 1: addContactUI(); break;
            case 2: viewContactsUI(); break;
            case 3: searchContactUI(); break;
            case 4: editContactUI(); break;
            case 5: deleteContactUI(); break;
            case 6: saveAndExitUI(); break;
             default: System.out.println("Invalid choice. Please try again.");
        }
     }

     private void addContactUI(){
         System.out.println("\n--- Add New Contact ---");
        try {
            String name = getStringInput("Enter name: ");
            String phone = getStringInput("Enter phone number: ");
            String email = getStringInput("Enter email: ");

if (!email.contains("@") || !email.contains(".")) {
                System.out.println("Warning: Email format seems invalid.");
            }

            Contact newContact = service.addContact(name, phone, email);
            System.out.println("Contact added successfully! ID: " + newContact.getId());
        } catch (Exception e) {
            System.out.println("Error adding contact: " + e.getMessage());
        }
     }
     
     private void viewContactsUI() {
         System.out.println("\n--- All Contacts ---");
        List<Contact> allContacts = service.getAllContacts();
        
        if (allContacts.isEmpty()) {
            System.out.println("📭 No contacts in the book.");
        } else {
            System.out.println("Total contacts: " + allContacts.size());
            System.out.println("------------------------");
            
            for (Contact contact : allContacts) {
                System.out.println("ID: " + contact.getId());
                System.out.println("  Name: " + contact.getName());
                System.out.println("  Phone: " + contact.getPhone());
                System.out.println("  Email: " + contact.getEmail());
                System.out.println("------------------------");
            }
        }
     }

     private void searchContactUI(){
          System.out.println("\n--- Search Contact ---");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        
        int searchChoice = getIntInput("Enter search option: ");
        
        switch (searchChoice) {
            case 1:
                int id = getIntInput("Enter contact ID: ");
                Contact contactById = service.searchContactById(id);
                if (contactById != null) {
                    System.out.println("Contact found:");
                    System.out.println(contactById);
                } else {
                    System.out.println("No contact found with ID: " + id);
                }
                break;
                
            case 2:
                String name = getStringInput("Enter name to search: ");
                List<Contact> contactsByName = service.searchByName(name);
                if (!contactsByName.isEmpty()) {
                    System.out.println("Found " + contactsByName.size() + " contact(s):");
                    for (Contact c : contactsByName) {
                        System.out.println(c);
                        System.out.println("------------------------");
                    }
                } else {
                    System.out.println("No contacts found with name containing: " + name);
                }
                break;
                
            default:
                System.out.println("Invalid search option.");
        }
    }
    
    private void editContactUI(){
         System.out.println("\n--- Edit Contact ---");
        int id = getIntInput("Enter ID of contact to edit: ");
        
        // First, check if contact exists
        Contact existingContact = service.searchContactById(id);
        if (existingContact == null) {
            System.out.println("No contact found with ID: " + id);
            return;
        }
        
        // Show current details
        System.out.println("Current contact details:");
        System.out.println("  Name: " + existingContact.getName());
        System.out.println("  Phone: " + existingContact.getPhone());
        System.out.println("  Email: " + existingContact.getEmail());
        
        System.out.println("\nEnter new details (press Enter to keep current value):");
        
        String name = getStringInputOptional("New name [" + existingContact.getName() + "]: ", existingContact.getName());
        String phone = getStringInputOptional("New phone [" + existingContact.getPhone() + "]: ", existingContact.getPhone());
        String email = getStringInputOptional("New email [" + existingContact.getEmail() + "]: ", existingContact.getEmail());
        
        boolean updated = service.editContact(id, name, phone, email);
        if (updated) {
            System.out.println("Contact updated successfully!");
        } else {
            System.out.println("Failed to update contact.");
        }
     }
     
     private void deleteContactUI(){
        System.out.println("\n--- Delete Contact ---");
        int id = getIntInput("Enter ID of contact to delete: ");
        
        // Confirm deletion
        Contact contactToDelete = service.searchContactById(id);
        if (contactToDelete == null) {
            System.out.println("No contact found with ID: " + id);
            return;
        }
        
        System.out.println("Contact to delete:");
        System.out.println(contactToDelete);
        
        String confirm = getStringInput("Are you sure you want to delete this contact? (y/n): ");
        if (confirm.equalsIgnoreCase("y") || confirm.equalsIgnoreCase("yes")) {
            boolean deleted = service.deleteContact(id);
            if (deleted) {
                System.out.println("Contact deleted successfully!");
            } else {
                System.out.println("Failed to delete contact.");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }
     
     private void saveAndExitUI() {
        System.out.println("\n--- Saving and Exiting ---");
        List<Contact> contacts = service.getAllContacts();
        if (fs.saveContacts(contacts)) {
            System.out.println("✅ " + contacts.size() + " contacts saved successfully.");
        } else {
            System.out.println("❌ Error saving contacts. Check file permissions.");
        }
        System.out.println("👋 Goodbye!");
        scan.close();
        System.exit(0);
     }

     private String getStringInput(String prompt) {
          while (true) {
            System.out.print(prompt);
            try {
                String input = scan.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                }
                System.out.println("Input cannot be empty.");
            } catch (NoSuchElementException e) {
                System.out.println("No input available. Exiting.");
                System.exit(1);
            }
        }
    }

    private String getStringInputOptional(String prompt, String defaultValue) {
        System.out.print(prompt);
        try {
            String input = scan.nextLine().trim();
            return input.isEmpty() ? defaultValue : input;
        } catch (NoSuchElementException e) {
            return defaultValue;
        }
    }

     private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String input = scan.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty.");
                    continue;
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (NoSuchElementException e) {
                System.out.println("No input available. Exiting.");
                System.exit(1);
            }
        }
    }

}
