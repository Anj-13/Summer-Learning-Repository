package service;

import model.Task;
import java.time.LocalDate;
import java.util.ArrayList;

public class TaskManager {
    public ArrayList<Task> tasks = new ArrayList<>();
    private int nextId;

    public TaskManager() {
        this.nextId = 0;
    }

    public Task addTask(String title, String description, LocalDate deadline, Task.PriorityOption priority) {
        Task newTask = new Task(title, description, deadline, priority);
        newTask.setId(nextId);
        nextId++;
        tasks.add(newTask);
        return newTask;
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public ArrayList<Task> getIncompleteTasks() {
        ArrayList<Task> incomplete = new ArrayList<>();
        for (Task a : tasks) {
            if (!a.isCompleted()) {
                incomplete.add(a);
            }
        }
        return incomplete;
    }

    public ArrayList<Task> getCompleteTasks() {
        ArrayList<Task> complete = new ArrayList<>();
        for (Task a : tasks) {
            if (a.isCompleted()) {
                complete.add(a);
            }
        }
        return complete;
    }

    public Task findTaskById(int id) {
        for (Task a : tasks) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    public boolean markTaskComplete(int id) {
        Task current = findTaskById(id);
        if (current != null) {
            current.setCompleted(true);
            return true;
        }
        return false;
    }

    public boolean deleteTask(int id) {
        Task current = findTaskById(id);
        if (current != null) {
            tasks.remove(current);
            return true;
        }
        return false;
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public void clearAllTasks() {
        tasks.clear();
        nextId = 0;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public void syncNextIdFromTasks() {
        int maxId = -1;
        for (Task t : tasks) {
            if (t.getId() > maxId) {
                maxId = t.getId();
            }
        }
        nextId = maxId + 1;
    }
}