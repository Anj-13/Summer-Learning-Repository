package ui;

import service.HabitService;
import java.util.Scanner;

public class HabitUI {
    private static Scanner scan;
    private static HabitService habitService;

    public static void start() {
        scan = new Scanner(System.in);
        habitService = new HabitService();

        while (true) {
            menu();
            System.out.println("Enter choice: ");
            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                scan.nextLine();
                handleChoice(choice);
            } else {
                scan.next();
                System.out.println("Invalid input, please enter a number.");
            }
        }
    }

    private static void menu() {
        System.out.println("==== Habit Tracker ====\n"
                + "1. Add Habit\n"
                + "2. View Habits\n"
                + "3. Mark Done Today\n"
                + "4. View Streak\n"
                + "5. Delete Habit\n"
                + "6. Exit");
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1 -> addHabit();
            case 2 -> habitService.viewHabits();
            case 3 -> markDone();
            case 4 -> viewStreak();
            case 5 -> deleteHabit();
            case 6 -> exit();
            default -> System.out.println("Invalid choice, please try again.");
        }
    }

    private static void addHabit() {
        System.out.print("Enter habit name: ");
        String name = scan.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Habit name cannot be empty!");
            return;
        }
        if (name.contains("|")) {
            System.out.println("Habit name cannot contain '|'!");
            return;
        }
        habitService.addHabit(name);
    }

    private static void markDone() {
        habitService.viewHabits();
        System.out.print("Enter habit ID to mark done: ");
        if (scan.hasNextInt()) {
            int id = scan.nextInt();
            habitService.markDone(id);
        } else {
            scan.next();
            System.out.println("Invalid ID!");
        }
    }

    private static void viewStreak() {
        habitService.viewHabits();
        System.out.print("Enter habit ID to view streak: ");
        if (scan.hasNextInt()) {
            int id = scan.nextInt();
            habitService.viewStreak(id);
        } else {
            scan.next();
            System.out.println("Invalid ID!");
        }
    }

    private static void deleteHabit() {
        habitService.viewHabits();
        System.out.print("Enter habit ID to delete: ");
        if (scan.hasNextInt()) {
            int id = scan.nextInt();
            habitService.deleteHabit(id);
        } else {
            scan.next();
            System.out.println("Invalid ID!");
        }
    }

    private static void exit() {
        System.out.println("Goodbye! Keep building those habits!");
        System.exit(0);
    }
}
