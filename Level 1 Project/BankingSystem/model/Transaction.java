package model;

public class Transaction {
    public enum Type {
        Deposit, Withdrawal
    }

    private int id;
    private Type type;
    private double amount;
    private String date;

    public Transaction(int id, Type type, double amount, String date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
