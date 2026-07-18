import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import model.Task;
import service.TaskManager;
import storage.FileStorage;

public class Main {
    private static TaskManager TM;
    private static FileStorage FS;
    private static Scanner scan;

    public static void main(String[] args) {
        TM = new TaskManager();
        FS = new FileStorage("tasks.txt");
        scan = new Scanner(System.in);

        ArrayList<Task> loaded = FS.loadTasks();
        if (loaded != null && !loaded.isEmpty()) {
            TM.tasks = loaded;
            TM.syncNextIdFromTasks();
            System.out.println("Loaded " + loaded.size() + " tasks from file");
        } else {
            System.out.println("No saved tasks found. Starting fresh.");
        }

        while (true) {
            displayMenu();
            int choice = getIntInput("Choose an option: ");
            processChoice(choice);
        }
    }

    public static void displayMenu() {
        System.out.println("\n==== Student Task Manager ====");
        System.out.println("1. Add Task");
        System.out.println("2. View All Tasks");
        System.out.println("3. View Incomplete Tasks");
        System.out.println("4. View Complete Tasks");
        System.out.println("5. Mark Task Complete");
        System.out.println("6. Delete Task");
        System.out.println("7. Load from File");
        System.out.println("8. Clear All Tasks");
        System.out.println("9. Exit (Auto-Save)");
        System.out.println("========================");
    }

    public static void processChoice(int choice) {
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                viewAllTasks();
                break;
            case 3:
                viewIncompleteTasks();
                break;
            case 4:
                viewCompleteTasks();
                break;
            case 5:
                markTaskComplete();
                break;
            case 6:
                deleteTask();
                break;
            case 7:
                loadFromFile();
                break;
            case 8:
                clearAllTasks();
                break;
            case 9:
                saveAndExit();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void addTask() {
        try {
            String title = getStringInput("Enter title: ");
            String description = getStringInput("Enter description: ");
            String deadlineStr = getStringInput("Enter deadline (YYYY-MM-DD): ");
            LocalDate deadline = LocalDate.parse(deadlineStr);
            String priorityStr = getStringInput("Enter priority (HIGH, MEDIUM, LOW): ");
            Task.PriorityOption priority = Task.PriorityOption.valueOf(priorityStr.toUpperCase());

            Task newTask = TM.addTask(title, description, deadline, priority);
            System.out.println("Task added successfully! ID: " + newTask.getId());
        } catch (Exception e) {
            System.out.println("Error adding task: " + e.getMessage());
        }
    }

    public static void viewAllTasks() {
        ArrayList<Task> allTasks = TM.getAllTasks();
        if (allTasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task t : allTasks) {
                System.out.println(t);
            }
        }
    }

    public static void viewIncompleteTasks() {
        ArrayList<Task> incomplete = TM.getIncompleteTasks();
        if (incomplete.isEmpty()) {
            System.out.println("No incomplete tasks found.");
        } else {
            for (Task t : incomplete) {
                System.out.println(t);
            }
        }
    }

    public static void viewCompleteTasks() {
        ArrayList<Task> complete = TM.getCompleteTasks();
        if (complete.isEmpty()) {
            System.out.println("No completed tasks found.");
        } else {
            for (Task t : complete) {
                System.out.println(t);
            }
        }
    }

    public static void markTaskComplete() {
        int id = getIntInput("Enter task ID to mark complete: ");
        Task t = TM.findTaskById(id);
        if (t == null) {
            System.out.println("Task with ID " + id + " not found.");
        } else if (t.isCompleted()) {
            System.out.println("Task is already completed.");
        } else {
            TM.markTaskComplete(id);
            System.out.println("Task " + id + " marked as completed.");
        }
    }

    public static void deleteTask() {
        int id = getIntInput("Enter task ID to delete: ");
        Task t = TM.findTaskById(id);
        if (t == null) {
            System.out.println("Task with ID " + id + " not found.");
            return;
        }
        System.out.println("Task details: " + t);
        System.out.print("Are you sure you want to delete this task? (y/n): ");
        String confirm = scan.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            if (TM.deleteTask(id)) {
                System.out.println("Task " + id + " deleted.");
            }
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    public static void saveAndExit() {
        FS.saveTasks(TM.tasks);
        System.out.println("Tasks saved. Goodbye!");
        System.exit(0);
    }

    public static void loadFromFile() {
        ArrayList<Task> loaded = FS.loadTasks();
        if (loaded != null && !loaded.isEmpty()) {
            TM.tasks.clear();
            TM.tasks.addAll(loaded);
            TM.syncNextIdFromTasks();
            System.out.println("Loaded " + loaded.size() + " tasks from file.");
        } else {
            System.out.println("No tasks found in file.");
        }
    }

    public static void clearAllTasks() {
        System.out.print("Are you sure you want to clear all tasks? (y/n): ");
        String confirm = scan.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            TM.clearAllTasks();
            System.out.println("All tasks cleared.");
        } else {
            System.out.println("Clear cancelled.");
        }
    }

    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            } catch (NoSuchElementException e) {
                System.out.println("No input available. Exiting.");
                System.exit(1);
            }
        }
    }

    public static String getStringInput(String prompt) {
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
}
