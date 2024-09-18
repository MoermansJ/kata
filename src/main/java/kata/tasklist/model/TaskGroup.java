package main.java.kata.tasklist.model;

import main.java.kata.tasklist.exception.ProjectNotFoundException;
import main.java.kata.tasklist.exception.TaskNotFoundException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskGroup {
    private final Map<Project, List<Task>> tasks = new LinkedHashMap<>();
    private long lastId = 0;

    public String show() {
        var sb = new StringBuilder();

        tasks.forEach((key, value) -> {
            sb.append(key).append(System.lineSeparator());

            value.forEach(task -> sb.append(
                            String.format("    [%c] %s: %s", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription()))
                    .append(System.lineSeparator()));

            sb.append(System.lineSeparator());
        });

        return sb.toString();
    }

    public void addProject(Project name) {
        tasks.put(name, new ArrayList<>());
    }

    public void addTask(Project project, String description) {
        List<Task> projectTasks = tasks.get(project);

        if (projectTasks == null) {
            throw new ProjectNotFoundException(project);
        }

        projectTasks.add(new Task(nextId(), description));
    }

    public String setDone(TaskId id, boolean done) {
        for (Map.Entry<Project, List<Task>> project : tasks.entrySet()) {
            for (Task task : project.getValue()) {
                if (task.getId().equals(id)) {
                    task.setDone(done);
                    return "";
                }
            }
        }

        throw new TaskNotFoundException(id);
    }

    private TaskId nextId() {
        return new TaskId(++lastId + "");
    }
}