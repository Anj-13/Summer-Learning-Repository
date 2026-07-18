package service;

import model.Expense;
import java.util.List;
import java.util.ArrayList;

public class ExpenseService {
    private List<Expense> expenses;
    private int nextID;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
        this.nextID = 1;
    }

    public List<Expense> getExpense() {
        return expenses;
    }

    public void setExpense(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public void setNextID(int nextID) {
        this.nextID = nextID;
    }

    public int generateid() {
        int currentID = nextID;
        nextID++;
        return currentID;
    }

    public void addExpense(String title, String category, double amount, String date) {
        int id = generateid();
        Expense newExpense = new Expense(id, title, category, amount, date);
        expenses.add(newExpense);
        System.out.println("Expense added successfully");
    }

    public boolean deleteExpense(int id) {
        /*
         * removeIf(Predicate condition)
         * numbers.removeIf( n -> n % 2 == 0 );
         */
        return expenses.removeIf(expense -> expense.getId() == id);
    }

    public List<Expense> viewAllExpenses() {
        return expenses;
    }

    public double calculateTotal() {
        double total = 0;

        for (Expense a : expenses) {
            total += a.getAmount();
        }

        return total;
    }

    public List<Expense> filterCategory(String category) {
        List<Expense> filteredExpenses = new ArrayList<>();
        for (Expense a : expenses) {
            if (a.getCategory().equalsIgnoreCase(category)) {
                filteredExpenses.add(a);
            }
        }
        return filteredExpenses;
    }

    // public List<Expense> filter(double amount){
    // return expenses.stream().filter(expense -> expense.getAmount() > amount)
    // .collect(Collectors.toList());
    // }

}