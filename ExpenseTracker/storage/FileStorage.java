package storage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Expense;

public class FileStorage {
    private static final String EXPENSE_FILE = "expense.txt";

    private String expenseToString(Expense a) {
        return (a.getId() + "|"
                + a.getTitle() + "|"
                + a.getCategory() + "|"
                + a.getAmount() + "|"
                + a.getDate());
    }

    private Expense stringToExpense(String line) {
        if (line == null || line.trim().isEmpty()) {
            return null;
        }

        String[] parts = line.split("\\|");
        if (parts.length != 5) {
            return null;
        }

        try {
            int id = Integer.parseInt(parts[0].trim());
            String title = parts[1].trim();
            String category = parts[2].trim();
            double amount = Double.parseDouble(parts[3].trim());
            String date = parts[4].trim();
            return new Expense(id, title, category, amount, date);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public boolean save(List<Expense> expense) {
        Path temp = Paths.get(EXPENSE_FILE + "_temp.txt");

        try {
            BufferedWriter w = new BufferedWriter(new FileWriter(temp.toFile()));

            for (Expense a : expense) {
                String line = expenseToString(a);
                w.write(line);
                w.newLine();
            }

            w.close();
        } catch (Exception e) {
            System.out.println("Error saving expense");
            return false;
        }

        try {
            Files.move(temp, Paths.get(EXPENSE_FILE), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Error moving expense file: " + e.getMessage());
            return false;
        }
    }

    public List<Expense> load() {
        List<Expense> load = new ArrayList<>();
        File f = new File(EXPENSE_FILE);

        if (!f.exists())
            return load;

        try {
            BufferedReader r = new BufferedReader(new FileReader(f));
            String line;

            while ((line = r.readLine()) != null) {
                Expense loadExpense = stringToExpense(line);
                if (loadExpense != null) {
                    load.add(loadExpense);
                }
            }

            r.close();
        } catch (Exception e) {
            System.out.println("Error loading Expense: " + e.getMessage());
        }

        return load;
    }
}
