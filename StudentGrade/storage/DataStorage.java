package storage;

import model.Grade;
import model.Module;
import service.GradeService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static final String FILE_NAME = "grade_data.dat";

    public void save(GradeService service) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(service.getModules());
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void load(GradeService service) {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("No saved data found. Starting fresh.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            List<Module> modules = (List<Module>) ois.readObject();
            service.setModules(modules);
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}
