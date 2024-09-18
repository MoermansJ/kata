package main.java.kata.tasklist.application;

import main.java.kata.tasklist.exception.CommandNotFoundException;
import main.java.kata.tasklist.model.TaskGroup;
import main.java.kata.tasklist.services.command.factory.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ApplicationRunner implements Runnable {
    private final BufferedReader in;
    private final PrintWriter out;
    private static final String QUIT = "quit";

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        new ApplicationRunner(in, out).run();
    }

    public ApplicationRunner(BufferedReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }

    @Override
    public void run() {
        TaskGroup taskGroup = new TaskGroup();

        while (true) {
            out.print("> ");
            out.flush();
            String command;
            
            try {
                command = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (command.equals(QUIT)) {
                break;
            }

            out.print(execute(taskGroup, command));
        }
    }

    private static String execute(TaskGroup taskGroup, String commandLine) {
        try {
            return CommandFactory.createCommand(taskGroup, commandLine).execute();
        } catch (CommandNotFoundException e) {
            return String.format("I don't know what the command \"%s\" is.%n", e.getCommand());
        }
    }
}
