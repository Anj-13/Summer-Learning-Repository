package storage;

import model.Task;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileStorage {
    private String filename;
    private String delimiter;

    public FileStorage(String filename) {
        this.filename = filename;
        this.delimiter = "|";
    }

    public boolean fileExists(File filename) {
        return filename.exists();
    }

    public void saveTasks(ArrayList<Task> tasks) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename + "_temp.txt"));
            for (Task t : tasks) {
                writer.write(t.getId() + delimiter + t.getTitle() + delimiter + t.getDescription() + delimiter + t.getDeadline() + delimiter + t.getPriority() + delimiter + (t.isCompleted() ? "true" : "false"));
                writer.newLine();
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }

        Path temp = Paths.get(filename + "_temp.txt");
        Path target = Paths.get(filename);

        try {
            Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.out.println("Error moving temp file: " + e.getMessage());
        }
    }

    public ArrayList<Task> loadTasks() {
        ArrayList<Task> load = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\" + delimiter);
                if (parts.length == 6) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String description = parts[2];
                    LocalDate deadline = LocalDate.parse(parts[3]);
                    Task.PriorityOption priority = Task.PriorityOption.valueOf(parts[4]);
                    boolean completed = parts[5].equals("true");
                    Task t = new Task(title, description, deadline, priority);
                    t.setId(id);
                    t.setCompleted(completed);
                    load.add(t);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found.");
        } catch (Exception e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return load;
    }
}