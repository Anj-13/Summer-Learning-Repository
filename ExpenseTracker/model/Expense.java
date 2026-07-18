package model;

public class Expense {
    private int id;
    private String title;
    private String category;
    private double amount;
    private String date;

    public Expense(int id, String title, String category, double amount, String date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }
    
    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense [id=" + id + ", title=" + title + ", category=" + category + ", amount=" + amount + ", date=" + date + "]";
    }
}