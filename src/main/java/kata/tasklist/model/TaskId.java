package main.java.kata.tasklist.model;

public record TaskId(String value) {

    @Override
    public String toString() {
        return value;
    }
}
