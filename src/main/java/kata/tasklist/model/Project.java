package main.java.kata.tasklist.model;

public record Project(String name) {

    @Override
    public String toString() {
        return name;
    }
}
