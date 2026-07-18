package ui;

import model.Transaction;
import service.BankService;
import java.util.Scanner;
import java.util.ArrayList;

public class BankSystem {
    private Scanner scan;
    private BankService bankService;

    public void start() {
        scan = new Scanner(System.in);
        bankService = new BankService();

        while (true) {
            displayMenu();
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 6) {
                exit();
            }
            handleChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\n==== Banking System ====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Check Balance");
        System.out.println("5. View Transactions");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdrawal();
                break;
            case 4:
                checkBalance();
                break;
            case 5:
                viewTransaction();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void createAccount() {
        System.out.print("Enter owner name: ");
        String name = scan.nextLine();
        int accNum = bankService.createAccount(name);
        System.out.println("Account created successfully! Account Number: " + accNum);
    }

    private void deposit() {
        System.out.print("Enter account number: ");
        int depAcc = scan.nextInt();
        System.out.print("Enter deposit amount: ");
        double depAmt = scan.nextDouble();
        scan.nextLine();
        if (bankService.depositToAccount(depAcc, depAmt)) {
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Deposit failed. Check account number and amount.");
        }
    }

    private void withdrawal() {
        System.out.print("Enter account number: ");
        int withAcc = scan.nextInt();
        System.out.print("Enter withdrawal amount: ");
        double withAmt = scan.nextDouble();
        scan.nextLine();
        if (bankService.withdrawFromAccount(withAcc, withAmt)) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Withdrawal failed. Check account number, amount, and balance.");
        }
    }

    private void checkBalance() {
        System.out.print("Enter account number: ");
        int balAcc = scan.nextInt();
        scan.nextLine();
        double balance = bankService.getAccountBalance(balAcc);
        if (balance == -1.0) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Current Balance: $" + balance);
        }
    }

    private void viewTransaction() {
        System.out.print("Enter account number: ");
        int txAcc = scan.nextInt();
        scan.nextLine();
        ArrayList<Transaction> transactions = bankService.getAccountTransactions(txAcc);
        if (transactions == null) {
            System.out.println("Account not found.");
        } else if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction t : transactions) {
                System.out
                        .println(t.getId() + " | " + t.getType().name() + " | $" + t.getAmount() + " | " + t.getDate());
            }
        }
    }

    private void exit() {
        bankService.saveAccounts();
        System.out.println("Thank you for using the Banking System!");
        System.exit(0);
    }
}
