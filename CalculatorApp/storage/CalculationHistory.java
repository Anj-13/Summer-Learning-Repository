package storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
    private ArrayList<String> history;
    private String filename;

    public CalculationHistory(String filename) {
        this.history = new ArrayList<>();
        this.filename = filename;
    }

    public void addEntry(String entry) {
        history.add(entry);
    }

    public List<String> getHistory() {
        return history;
    }

    public String getLastEntry() {
        if (history.isEmpty()) {
            return "No history available";
        }
        return history.get(history.size() - 1);
    }

    public void clearHistory() {
        history.clear();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public int getHistoryCount() {
        return history.size();
    }

    public void saveToFile(String filename) {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(filename))) {
            for (String a : history) {
                w.write(a);
                w.newLine();
            }
            System.out.println("History saved to " + filename);
        } catch (Exception e) {
            System.out.println("Error saving history: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        File f = new File(filename);

        if (!f.exists()) {
            return;
        }
        try (BufferedReader r = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = r.readLine()) != null) {
                history.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error loading history: " + e.getMessage());
        }

    }

}