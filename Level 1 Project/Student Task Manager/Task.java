import java.time.LocalDate;

public class Task {
    public enum PriorityOption {
        HIGH, MEDIUM, LOW
    }

    private int id;
    private String title;
    private String description;
    private LocalDate deadline;
    private PriorityOption priority;
    private boolean completed;

    public Task(String title, String description, LocalDate deadline, PriorityOption priority) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public String getPriority() {
        return priority.name();
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + title + " | " + description + " | " + deadline + " | " + priority + " | " + (completed ? "Completed" : "Incomplete");
    }
}
