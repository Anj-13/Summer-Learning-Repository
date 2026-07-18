package model;

import java.util.ArrayList;

public class Habit {
    private int id;
    private String name;
    private ArrayList<String> completedDates;

    public Habit(int id, String name) {
        this.id = id;
        this.name = name;
        this.completedDates = new ArrayList<>();
    }

    public Habit(int id, String name, ArrayList<String> completedDates) {
        this.id = id;
        this.name = name;
        this.completedDates = completedDates;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getCompletedDates() {
        return completedDates;
    }

    public void addCompletedDate(String date) {
        completedDates.add(date);
    }

    public boolean hasCompletedOnDate(String date) {
        return completedDates.contains(date);
    }

    public void removeCompletedDate(String date) {
        completedDates.remove(date);
    }
}
