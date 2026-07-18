package service;

import model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    public List<Contact> contacts;
    private int nextId;

    public ContactService() {
        this.contacts = new ArrayList<>();
        this.nextId = 1;
    }

    public void setContacts(List<Contact> loadedContacts) {
        this.contacts = loadedContacts;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public Contact addContact(String name, String phone, String email) {
        int id = generateId();
        Contact contact = new Contact(id, name, phone, email);

        contacts.add(contact);

        return contact;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }

    public List<Contact> searchByName(String name) {
        List<Contact> matches = new ArrayList<>();
        String searchLower = name.toLowerCase().trim();
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchLower)) {
                matches.add(contact);
            }
        }
        return matches;
    }

    public boolean editContact(int id, String name, String phone, String email) {
        Contact newContact = new Contact(id, name, phone, email);
        Contact oldContact = searchContactById(id);

        if (oldContact != null) {
            contacts.remove(oldContact);
            contacts.add(newContact);

            return true;
        }

        return false;
    }

    public Contact searchContactById(int id) {
        for (Contact a : contacts) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public boolean deleteContact(int id) {
        Contact deleteContact = searchContactById(id);

        if (deleteContact != null) {
            contacts.remove(deleteContact);
            return true;
        }

        return false;
    }

    private int generateId() {
        int currentId = nextId;
        nextId++;
        return currentId;
    }
}