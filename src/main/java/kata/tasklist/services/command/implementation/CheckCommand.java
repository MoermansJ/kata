package main.java.kata.tasklist.services.command.implementation;

import main.java.kata.tasklist.exception.TaskNotFoundException;
import main.java.kata.tasklist.model.TaskGroup;
import main.java.kata.tasklist.model.TaskId;

public class CheckCommand implements Command {
    private final TaskGroup taskGroup;
    private final TaskId id;

    public CheckCommand(TaskGroup taskGroup, TaskId id) {
        this.taskGroup = taskGroup;
        this.id = id;
    }

    @Override
    public String execute() {
        try {
            return this.taskGroup.setDone(this.id, true);
        } catch (TaskNotFoundException e) {
            return String.format("Could not find a task with an ID of %s.%n", e.getId());
        }
    }
}
