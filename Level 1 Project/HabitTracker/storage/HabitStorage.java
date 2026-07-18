package storage;

import model.Habit;
import java.io.*;
import java.util.ArrayList;

public class HabitStorage {
    private static final String FILE_NAME = "habits.txt";

    public void saveHabits(ArrayList<Habit> habits) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Habit h : habits) {
                StringBuilder line = new StringBuilder();
                line.append(h.getId()).append("|");
                line.append(h.getName()).append("|");
                ArrayList<String> dates = h.getCompletedDates();
                for (int i = 0; i < dates.size(); i++) {
                    line.append(dates.get(i));
                    if (i < dates.size() - 1) {
                        line.append(",");
                    }
                }
                writer.write(line.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving habits: " + e.getMessage());
        }
    }

    public ArrayList<Habit> loadHabits() {
        ArrayList<Habit> habits = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return habits;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    String[] parts = line.split("\\|", 3);
                    if (parts.length < 2) {
                        System.out.println("Skipping malformed habit line.");
                        continue;
                    }
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    ArrayList<String> dates = new ArrayList<>();
                    if (parts.length > 2 && !parts[2].isEmpty()) {
                        String[] dateArray = parts[2].split(",");
                        for (String d : dateArray) {
                            if (!d.trim().isEmpty()) {
                                dates.add(d.trim());
                            }
                        }
                    }
                    habits.add(new Habit(id, name, dates));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping malformed habit line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading habits: " + e.getMessage());
        }
        return habits;
    }
}
