import java.util.Scanner;

public class Main {
    private static Calculator calculator;
    private static CalculationHistory history;
    private static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        calculator = new Calculator();
        history = new CalculationHistory("history.txt");
        history.loadFromFile("history.txt");

        while (true) {
            displayMenu();
            int choice = getIntInput("Choose an option: ");

            if (choice == 14) {
                history.saveToFile("history.txt");
                System.out.println("Goodbye!");
                break;
            }
            processChoice(choice);
        }

        scan.close();
    }

    public static int getIntInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                return Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static double getNumberInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("===== Calculator =====");
        System.out.println("1.  Add");
        System.out.println("2.  Subtract");
        System.out.println("3.  Multiply");
        System.out.println("4.  Divide");
        System.out.println("5.  Percentage");
        System.out.println("6.  Power");
        System.out.println("7.  Square Root");
        System.out.println("8.  Factorial");
        System.out.println("9.  Sine");
        System.out.println("10. Cosine");
        System.out.println("11. Tangent");
        System.out.println("12. View History");
        System.out.println("13. Clear History");
        System.out.println("14. Exit");
        System.out.println("======================");
    }

    public static void processChoice(int choice) {
        switch (choice) {
            case 1:
                performBinaryOperation("+");
                break;
            case 2:
                performBinaryOperation("-");
                break;
            case 3:
                performBinaryOperation("*");
                break;
            case 4:
                performBinaryOperation("/");
                break;
            case 5:
                performBinaryOperation("%");
                break;
            case 6:
                performBinaryOperation("^");
                break;
            case 7:
                performUnaryOperation("sqrt");
                break;
            case 8:
                performUnaryOperation("!");
                break;
            case 9:
                performUnaryOperation("sin");
                break;
            case 10:
                performUnaryOperation("cos");
                break;
            case 11:
                performUnaryOperation("tan");
                break;
            case 12:
                viewHistory();
                break;
            case 13:
                clearHistory();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static double performBinaryOperation(String operator) {
        double a = getNumberInput("Enter first number: ");
        double b = getNumberInput("Enter second number: ");
        double result = 0;

        switch (operator) {
            case "+":
                result = calculator.add(a, b);
                break;
            case "-":
                result = calculator.subtract(a, b);
                break;
            case "*":
                result = calculator.multiply(a, b);
                break;
            case "/":
                result = calculator.divide(a, b);
                break;
            case "%":
                result = calculator.percentage(a, b);
                break;
            case "^":
                result = calculator.power(a, b);
                break;
        }

        String entry = a + " " + operator + " " + b + " = " + result;
        history.addEntry(entry);
        displayResult(result);
        return result;
    }

    public static double performUnaryOperation(String operation) {
        double a = getNumberInput("Enter number: ");
        double result = 0;
        String entry = "";

        switch (operation) {
            case "sqrt":
                result = calculator.squareRoot(a);
                entry = "sqrt(" + a + ") = " + result;
                break;
            case "!":
                result = calculator.factorial((int) a);
                entry = (int) a + "! = " + result;
                break;
            case "sin":
                result = calculator.sine(a);
                entry = "sin(" + a + ") = " + result;
                break;
            case "cos":
                result = calculator.cosine(a);
                entry = "cos(" + a + ") = " + result;
                break;
            case "tan":
                result = calculator.tangent(a);
                entry = "tan(" + a + ") = " + result;
                break;
        }

        history.addEntry(entry);
        displayResult(result);
        return result;
    }

    public static void displayResult(double result) {
        System.out.println("Result: " + result);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static String formatHistory(String entry) {
        return "• " + entry;
    }

    private static void viewHistory() {
        if (history.isEmpty()) {
            System.out.println("No history available.");
            return;
        }
        System.out.println("===== History =====");
        for (String entry : history.getHistory()) {
            System.out.println(formatHistory(entry));
        }
        System.out.println("===================");
    }

    private static void clearHistory() {
        System.out.print("Are you sure you want to clear history? (y/n): ");
        String confirm = scan.nextLine();
        if (confirm.equalsIgnoreCase("y")) {
            history.clearHistory();
            System.out.println("History cleared.");
        }
    }
}
