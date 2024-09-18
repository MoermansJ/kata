package main.java.kata.tasklist.services.command.implementation;

import main.java.kata.tasklist.model.TaskGroup;

public class ShowCommand implements Command {
    private final TaskGroup taskGroup;

    public ShowCommand(final TaskGroup taskGroup) {
        this.taskGroup = taskGroup;
    }

    @Override
    public String execute() {
        return taskGroup.show();
    }
}
