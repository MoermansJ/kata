package main.java.kata.tasklist.exception;

public class CommandNotFoundException extends RuntimeException {
    private final String command;

    public CommandNotFoundException(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
