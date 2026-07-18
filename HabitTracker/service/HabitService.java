package service;

import model.Habit;
import storage.HabitStorage;
import java.time.LocalDate;
import java.util.ArrayList;

public class HabitService {
    private ArrayList<Habit> habits;
    private HabitStorage storage;
    private int nextId;

    public HabitService() {
        habits = new ArrayList<>();
        storage = new HabitStorage();
        nextId = 1;
        loadHabits();
    }

    private void loadHabits() {
        habits = storage.loadHabits();
        if (!habits.isEmpty()) {
            nextId = habits.stream().mapToInt(Habit::getId).max().orElse(0) + 1;
        }
    }

    public void addHabit(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Habit name cannot be empty!");
            return;
        }
        if (name.contains("|")) {
            System.out.println("Habit name cannot contain '|'!");
            return;
        }
        Habit habit = new Habit(nextId++, name.trim());
        habits.add(habit);
        storage.saveHabits(habits);
        System.out.println("Habit '" + name.trim() + "' added successfully!");
    }

    public void viewHabits() {
        if (habits.isEmpty()) {
            System.out.println("\nNo habits yet. Add one first!\n");
            return;
        }
        System.out.println("\n--- Your Habits ---");
        for (Habit h : habits) {
            System.out.println(h.getId() + ". " + h.getName()
                    + " (Completed: " + h.getCompletedDates().size() + " days)");
        }
        System.out.println();
    }

    public boolean markDone(int habitId) {
        String today = LocalDate.now().toString();
        Habit habit = findHabitById(habitId);
        if (habit == null) {
            System.out.println("Habit not found!");
            return false;
        }
        if (habit.hasCompletedOnDate(today)) {
            System.out.println("Already marked done for today!");
            return false;
        }
        habit.addCompletedDate(today);
        storage.saveHabits(habits);
        System.out.println("Habit '" + habit.getName() + "' marked done for today!");
        return true;
    }

    public void viewStreak(int habitId) {
        Habit habit = findHabitById(habitId);
        if (habit == null) {
            System.out.println("Habit not found!");
            return;
        }
        int streak = calculateStreak(habit);
        System.out.println("\nHabit: " + habit.getName());
        System.out.println("Current Streak: " + streak + " day(s)");
        System.out.println("Total Completions: " + habit.getCompletedDates().size() + "\n");
    }

    private int calculateStreak(Habit habit) {
        ArrayList<String> dates = habit.getCompletedDates();
        if (dates.isEmpty()) {
            return 0;
        }
        ArrayList<String> sorted = new ArrayList<>(dates);
        sorted.sort((a, b) -> b.compareTo(a));

        LocalDate today = LocalDate.now();
        LocalDate mostRecent = LocalDate.parse(sorted.get(0));
        // Current streak only counts if the latest completion is today or yesterday
        if (!mostRecent.equals(today) && !mostRecent.equals(today.minusDays(1))) {
            return 0;
        }

        int streak = 1;
        LocalDate current = mostRecent;
        for (int i = 1; i < sorted.size(); i++) {
            LocalDate prev = LocalDate.parse(sorted.get(i));
            if (current.minusDays(1).equals(prev)) {
                streak++;
                current = prev;
            } else {
                break;
            }
        }
        return streak;
    }

    public boolean deleteHabit(int habitId) {
        Habit habit = findHabitById(habitId);
        if (habit == null) {
            System.out.println("Habit not found!");
            return false;
        }
        habits.remove(habit);
        storage.saveHabits(habits);
        System.out.println("Habit '" + habit.getName() + "' deleted successfully!");
        return true;
    }

    private Habit findHabitById(int id) {
        for (Habit h : habits) {
            if (h.getId() == id) {
                return h;
            }
        }
        return null;
    }
}
