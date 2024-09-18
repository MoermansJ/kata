package main.java.kata.tasklist.model;

public final class Task {
    private final TaskId id;
    private final String description;
    private boolean done;

    public Task(TaskId id, String description) {
        this.id = id;
        this.description = description;
    }

    public TaskId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}