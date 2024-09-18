package main.java.kata.tasklist.services.command.implementation;

import main.java.kata.tasklist.model.TaskGroup;
import main.java.kata.tasklist.model.TaskId;

public class UncheckCommand implements Command {
    private final TaskGroup taskGroup;
    private final TaskId id;

    public UncheckCommand(final TaskGroup taskGroup, final TaskId id) {
        this.taskGroup = taskGroup;
        this.id = id;
    }

    @Override
    public String execute() {
        return this.taskGroup.setDone(this.id, false);
    }
}
