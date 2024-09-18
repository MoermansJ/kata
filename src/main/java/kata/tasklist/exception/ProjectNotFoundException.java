package main.java.kata.tasklist.exception;

import main.java.kata.tasklist.model.Project;

public class ProjectNotFoundException extends RuntimeException {
    private final Project project;

    public ProjectNotFoundException(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }
}
