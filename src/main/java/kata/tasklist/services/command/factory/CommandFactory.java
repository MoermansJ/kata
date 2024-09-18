package main.java.kata.tasklist.services.command.factory;

import main.java.kata.tasklist.exception.CommandNotFoundException;
import main.java.kata.tasklist.model.TaskGroup;
import main.java.kata.tasklist.model.TaskId;
import main.java.kata.tasklist.services.command.implementation.*;

public class CommandFactory {
    public static Command createCommand(TaskGroup taskGroup, String commandLine) {
        String[] splitCommandLine = commandLine.split(" ", 2);
        String commandType = splitCommandLine[0];

        return switch (commandType) {
            case "show" -> new ShowCommand(taskGroup);
            case "add" -> new AddCommand(taskGroup, splitCommandLine[1]);
            case "check" -> new CheckCommand(taskGroup, new TaskId(splitCommandLine[1]));
            case "uncheck" -> new UncheckCommand(taskGroup, new TaskId(splitCommandLine[1]));
            case "help" -> new HelpCommand();
            default -> throw new CommandNotFoundException(commandType);
        };
    }
}
