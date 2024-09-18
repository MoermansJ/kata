package main.java.kata.tasklist.services.command.implementation;

import main.java.kata.tasklist.exception.ProjectNotFoundException;
import main.java.kata.tasklist.model.Project;
import main.java.kata.tasklist.model.TaskGroup;

public class AddCommand implements Command {
    private final TaskGroup taskGroup;
    private final String commandLine;


    public AddCommand(TaskGroup taskGroup, String commandLine) {
        this.taskGroup = taskGroup;
        this.commandLine = commandLine;
    }

    @Override
    public String execute() {
        try {
            String[] subcommandRest = commandLine.split(" ", 2);
            String subcommand = subcommandRest[0];

            if (subcommand.equals("project")) {
                this.taskGroup.addProject(new Project(subcommandRest[1]));
            } else if (subcommand.equals("task")) {
                String[] projectTask = subcommandRest[1].split(" ", 2);
                this.taskGroup.addTask(new Project(projectTask[0]), projectTask[1]);
            }

            return "";
        } catch (ProjectNotFoundException e) {
            return String.format("Could not find a project with the name \"%s\".%n", e.getProject());
        }
    }


}
