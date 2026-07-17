package service;

import model.BankAccount;
import model.Transaction;
import java.util.ArrayList;
import java.io.*;

public class BankService {
    private ArrayList<BankAccount> accounts;
    private int accountNumberCounter;

    public BankService() {
        accounts = new ArrayList<>();
        accountNumberCounter = 1001;
        loadAccounts();
    }

    public int createAccount(String ownerName) {
        int accountNumber = generateAccountNumber();
        BankAccount account = new BankAccount(accountNumber, ownerName);
        accounts.add(account);
        return accountNumber;
    }

    private BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public boolean depositToAccount(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null)
            return false;
        return account.deposit(amount);
    }

    public boolean withdrawFromAccount(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account == null)
            return false;
        return account.withdraw(amount);
    }

    public double getAccountBalance(int accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account == null)
            return -1.0;
        return account.getBalance();
    }

    public ArrayList<Transaction> getAccountTransactions(int accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account == null)
            return null;
        return account.getTransactionHistory();
    }

    private int generateAccountNumber() {
        return accountNumberCounter++;
    }

    public void saveAccounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("accounts.txt"))) {
            for (BankAccount account : accounts) {
                writer.println(account.getAccountNumber() + "|" + account.getOwnerName() + "|" + account.getBalance());
                ArrayList<Transaction> transactions = account.getTransactionHistory();
                for (Transaction t : transactions) {
                    writer.println(t.getId() + "|" + t.getType().name() + "|" + t.getAmount() + "|" + t.getDate());
                }
                writer.println("---");
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    public void loadAccounts() {
        File file = new File("accounts.txt");
        if (!file.exists())
            return;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            BankAccount currentAccount = null;
            while ((line = reader.readLine()) != null) {
                if (line.equals("---")) {
                    if (currentAccount != null) {
                        accounts.add(currentAccount);
                        currentAccount = null;
                    }
                    continue;
                }
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int accNum = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    double bal = Double.parseDouble(parts[2]);
                    currentAccount = new BankAccount(accNum, name);
                    currentAccount.restoreBalance(bal);
                    if (accNum >= accountNumberCounter) {
                        accountNumberCounter = accNum + 1;
                    }
                } else if (parts.length == 4 && currentAccount != null) {
                    int id = Integer.parseInt(parts[0]);
                    try {
                        Transaction.Type type = Transaction.Type.valueOf(parts[1]);
                        double amount = Double.parseDouble(parts[2]);
                        String date = parts[3];
                        currentAccount.restoreTransaction(new Transaction(id, type, amount, date));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Skipping invalid transaction type: " + parts[1]);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
        }
    }
}
