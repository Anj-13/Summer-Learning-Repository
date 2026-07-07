package storage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import model.Contact;

public class FileStorage {
    private String filename;
    private String space;

    public FileStorage(String filename, String space) {
        this.filename = filename;
        this.space = space;
    }

    public boolean saveContacts(List<Contact> contacts) {
        try {
              File file = new File(filename);
        file.getParentFile().mkdirs();
        
            BufferedWriter w = new BufferedWriter(new FileWriter(filename + "_temp.txt"));
            for (Contact a : contacts) {
                w.write(a.getId() + space + a.getName() + space + a.getPhone() + space + a.getEmail());
                w.newLine();
            }

            w.close();
        } catch (Exception e) {
            System.out.println("Error saving contacts: " + e.getMessage());
            return false;
        }

        Path temp = Paths.get(filename + "_temp.txt");
        Path target = Paths.get(filename);

        try {
            Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING);
        return true;
        } catch (Exception e) {
            System.out.println("Error moving temp file: " + e.getMessage());
            return false;
        }
    }

    public List<Contact> loadContacts() {
        List<Contact> load = new ArrayList<>();
        try {
            BufferedReader r = new BufferedReader(new FileReader(filename));
            String line;

            while ((line = r.readLine()) != null) {
                String[] parts = line.split("\\" + space);
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String phone = parts[2];
                    String email = parts[3];
                    Contact c = new Contact(id, name, phone, email);
                    load.add(c);
                }
            }

            r.close();
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found.");
        } catch (Exception e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return load;
    }
}
