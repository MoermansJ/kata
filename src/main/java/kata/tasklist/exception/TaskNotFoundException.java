package main.java.kata.tasklist.exception;

import main.java.kata.tasklist.model.TaskId;

public class TaskNotFoundException extends RuntimeException {
    private final TaskId id;

    public TaskNotFoundException(TaskId id) {
        this.id = id;
    }

    public TaskId getId() {
        return this.id;
    }
}
