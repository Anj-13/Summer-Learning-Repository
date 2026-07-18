package ui;

import model.Grade;
import model.Module;
import service.GradeService;
import storage.DataStorage;

import java.util.List;
import java.util.Scanner;

public class GradeTrackerUI {
    private static final GradeService service = new GradeService();
    private static final DataStorage storage = new DataStorage();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        storage.load(service);

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addModule();
                    break;
                case 2:
                    addGrade();
                    break;
                case 3:
                    viewModuleAverage();
                    break;
                case 4:
                    viewAllGrades();
                    break;
                case 5:
                    deleteGrade();
                    break;
                case 6:
                    storage.save(service);
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("==== Grade Tracker ====");
        System.out.println("1. Add Module");
        System.out.println("2. Add Grade");
        System.out.println("3. View Module Average");
        System.out.println("4. View All Grades");
        System.out.println("5. Delete Grade");
        System.out.println("6. Exit");
    }

    private static void addModule() {
        System.out.print("Enter module name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Module name cannot be empty.");
            return;
        }
        try {
            Module module = service.addModule(name);
            System.out.println("Module added: " + module);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void addGrade() {
        List<Module> modules = service.getModules();
        if (modules.isEmpty()) {
            System.out.println("No modules available. Please add a module first.");
            return;
        }

        System.out.println("Available modules:");
        for (Module m : modules) {
            System.out.printf("  %d. %s%n", m.getId(), m.getName());
        }

        int moduleId = readInt("Enter module ID: ");
        Module module = service.findModule(moduleId);
        if (module == null) {
            System.out.println("Module not found.");
            return;
        }

        System.out.print("Enter assessment name: ");
        String assessmentName = scanner.nextLine().trim();
        if (assessmentName.isEmpty()) {
            System.out.println("Assessment name cannot be empty.");
            return;
        }

        double score = readDouble("Enter score (0-100): ");
        if (score < 0 || score > 100) {
            System.out.println("Score must be between 0 and 100.");
            return;
        }
        double weight = readDouble("Enter weight (0-100): ");
        if (weight <= 0 || weight > 100) {
            System.out.println("Weight must be between 0 and 100 (exclusive of 0).");
            return;
        }

        try {
            Grade grade = service.addGrade(moduleId, assessmentName, score, weight);
            if (grade == null) {
                System.out.println("Error: Module not found.");
                return;
            }
            System.out.println("Grade added: " + grade);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewModuleAverage() {
        List<Module> modules = service.getModules();
        if (modules.isEmpty()) {
            System.out.println("No modules available.");
            return;
        }

        System.out.println("Available modules:");
        for (Module m : modules) {
            System.out.printf("  %d. %s%n", m.getId(), m.getName());
        }

        int moduleId = readInt("Enter module ID: ");
        Module module = service.findModule(moduleId);
        if (module == null) {
            System.out.println("Module not found.");
            return;
        }

        double average = service.calculateModuleAverage(moduleId);
        System.out.printf("Average for '%s': %.2f%%%n", module.getName(), average);

        Grade highest = service.findHighestGrade(moduleId);
        Grade lowest = service.findLowestGrade(moduleId);

        if (highest != null) {
            System.out.printf("Highest: %s (%.1f)%n", highest.getAssessmentName(), highest.getScore());
        }
        if (lowest != null) {
            System.out.printf("Lowest: %s (%.1f)%n", lowest.getAssessmentName(), lowest.getScore());
        }
    }

    private static void viewAllGrades() {
        List<Module> modules = service.getModules();
        if (modules.isEmpty()) {
            System.out.println("No modules available.");
            return;
        }

        for (Module m : modules) {
            System.out.printf("%nModule: %s (ID: %d)%n", m.getName(), m.getId());
            if (m.getGrades().isEmpty()) {
                System.out.println("  No grades recorded.");
            } else {
                for (Grade g : m.getGrades()) {
                    System.out.printf("  [%d] %s - Score: %.1f, Weight: %.1f%%%n",
                            g.getId(), g.getAssessmentName(), g.getScore(), g.getWeight());
                }
                System.out.printf("  Weighted Average: %.2f%%%n", service.calculateModuleAverage(m.getId()));
            }
        }
    }

    private static void deleteGrade() {
        List<Module> modules = service.getModules();
        if (modules.isEmpty()) {
            System.out.println("No modules available.");
            return;
        }

        System.out.println("Available modules:");
        for (Module m : modules) {
            System.out.printf("  %d. %s%n", m.getId(), m.getName());
        }

        int moduleId = readInt("Enter module ID: ");
        Module module = service.findModule(moduleId);
        if (module == null) {
            System.out.println("Module not found.");
            return;
        }

        if (module.getGrades().isEmpty()) {
            System.out.println("No grades to delete in this module.");
            return;
        }

        System.out.println("Grades in module:");
        for (Grade g : module.getGrades()) {
            System.out.printf("  [%d] %s - Score: %.1f%n", g.getId(), g.getAssessmentName(), g.getScore());
        }

        int gradeId = readInt("Enter grade ID to delete: ");
        if (service.deleteGrade(moduleId, gradeId)) {
            System.out.println("Grade deleted.");
        } else {
            System.out.println("Grade not found.");
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = Double.parseDouble(scanner.nextLine().trim());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
