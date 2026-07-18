package ui;

import model.Expense;
import service.ExpenseService;
import storage.FileStorage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExpenseUI {
    private static final List<String> CATEGORIES = Arrays.asList(
            "Food", "Transport", "Rent", "Shopping", "Entertainment", "Other");

    private static Scanner scan;
    private static FileStorage fileStorage;
    private static ExpenseService expenseService;

    public static void start() {
        scan = new Scanner(System.in);
        fileStorage = new FileStorage();
        expenseService = new ExpenseService();

        List<Expense> expenses = fileStorage.load();
        expenseService.setExpense(expenses);

        if (!expenses.isEmpty()) {
            int maxID = 0;
            for (Expense a : expenses) {
                if (a.getId() > maxID) {
                    maxID = a.getId();
                }
            }
            expenseService.setNextID(maxID + 1);
        }

        while (true) {
            menu();
            System.out.print("Enter your choice: ");
            if (!scan.hasNextInt()) {
                System.out.println("Invalid choice. Please try again");
                scan.nextLine();
                continue;
            }
            int choice = scan.nextInt();
            scan.nextLine();

            choice(choice);
        }
    }

    private static void menu() {
        System.out.println("==== Expense Tracker ====");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. View Total");
        System.out.println("4. Filter By Category");
        System.out.println("5. Delete Expense");
        System.out.println("6. Exit");
    }

    private static void choice(int choice) {
        switch (choice) {
            case 1 -> ExpenseAdd();
            case 2 -> ExpenseView();
            case 3 -> ExpenseTotal();
            case 4 -> SearchExpense();
            case 5 -> ExpenseDelete();
            case 6 -> exit();
            default -> System.out.println("Invalid choice. Please try again");
        }
    }

    private static void ExpenseAdd() {
        System.out.print("Enter title: ");
        String title = scan.nextLine().trim();
        if (title.isEmpty()) {
            System.out.println("Error: Title cannot be blank.");
            return;
        }

        System.out.println("Categories: " + String.join(", ", CATEGORIES));
        System.out.print("Enter category: ");
        String category = scan.nextLine().trim();
        String matchedCategory = matchCategory(category);
        if (matchedCategory == null) {
            System.out.println("Error: Category not found. Use one of: " + String.join(", ", CATEGORIES));
            return;
        }

        System.out.print("Enter amount: ");
        if (!scan.hasNextDouble()) {
            System.out.println("Error: Amount must be a number.");
            scan.nextLine();
            return;
        }
        double amount = scan.nextDouble();
        scan.nextLine();
        if (amount <= 0) {
            System.out.println("Error: Amount must be greater than zero.");
            return;
        }

        System.out.print("Enter date: ");
        String date = scan.nextLine().trim();
        if (date.isEmpty()) {
            System.out.println("Error: Date cannot be blank.");
            return;
        }

        expenseService.addExpense(title, matchedCategory, amount, date);
    }

    private static String matchCategory(String input) {
        for (String c : CATEGORIES) {
            if (c.equalsIgnoreCase(input)) {
                return c;
            }
        }
        return null;
    }


    private static void ExpenseView() {
        List<Expense> expense = expenseService.viewAllExpenses();
        if (expense.isEmpty()) {
            System.out.println("No Expense tracked");
        } else {
            for (Expense e : expense) {
                System.out.println(e + "\n----------------------------");
            }
        }
    }

    private static void ExpenseTotal() {
        double a = expenseService.calculateTotal();
        System.out.println("==== Expense Total ===="
                + "\nTotal: " + a
                + "\n=====================");
    }

    private static void SearchExpense() {
        System.out.print("Enter category: ");
        String cate = scan.nextLine();

        List<Expense> list = expenseService.filterCategory(cate);

        if (list.isEmpty()) {
            System.out.println("No " + cate + " expense found");
        } else {
            for (Expense e : list) {
                System.out.println(e + "\n----------------------------");
            }
        }
    }

    private static void ExpenseDelete() {
        System.out.print("Enter Expense ID: ");
        if (!scan.hasNextInt()) {
            System.out.println("Error: ID must be a number.");
            scan.nextLine();
            return;
        }
        int expID = scan.nextInt();
        scan.nextLine();
        boolean check = expenseService.deleteExpense(expID);
        if (check) {
            System.out.println("Expense deleted successfully");
        } else {
            System.out.println("Error: Expense not found");
        }
    }

    private static void exit() {
        fileStorage.save(expenseService.getExpense());
        System.out.println("GoodBye!");
        System.exit(0);
    }
}
