package org.practice.simpletodo.exception;

public class InvalidTaskValues extends RuntimeException {
    public InvalidTaskValues(String message) {
        super(message);
    }
}
