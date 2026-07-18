package model;

import java.util.ArrayList;

public class BankAccount {
    private int accountNumber;
    private String ownerName;
    private double balance;
    private ArrayList<Transaction> transactions;
    private int transactionCounter;

    public BankAccount(int accountNumber, String ownerName) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
        this.transactionCounter = 1;
    }

    public boolean deposit(double amount) {
        if (amount <= 0)
            return false;
        balance += amount;
        addTransaction(Transaction.Type.Deposit, amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0)
            return false;
        if (balance < amount)
            return false;
        balance -= amount;
        addTransaction(Transaction.Type.Withdrawal, amount);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return transactions;
    }

    private void addTransaction(Transaction.Type type, double amount) {
        int id = generateTransactionId();
        String date = java.time.LocalDateTime.now().toString();
        transactions.add(new Transaction(id, type, amount, date));
    }

    private int generateTransactionId() {
        return transactionCounter++;
    }

    public void restoreBalance(double balance) {
        this.balance = balance;
    }

    public void restoreTransaction(Transaction t) {
        transactions.add(t);
        if (t.getId() >= transactionCounter) {
            transactionCounter = t.getId() + 1;
        }
    }
}
