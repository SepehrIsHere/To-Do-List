package org.practice.simpletodo.exception;

public class InvalidUserValues extends RuntimeException {
    public InvalidUserValues(String message) {
        super(message);
    }
}
