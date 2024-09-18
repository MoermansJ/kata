package main.java.kata.tasklist.services.command.implementation;


public class HelpCommand implements Command {

    @Override
    public String execute() {
        return """
                Commands:
                		  show
                		  add project <project name>
                		  add task <project name> <task description>
                		  check <task ID>
                		  uncheck <task ID>
                
                """;
    }
}
