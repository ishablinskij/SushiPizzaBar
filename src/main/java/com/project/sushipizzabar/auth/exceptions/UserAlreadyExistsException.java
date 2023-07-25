package com.project.sushipizzabar.auth.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException() {
        super("This user are already registered");
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
