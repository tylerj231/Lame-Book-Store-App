package com.tutego.lamebookstoreapp.exceptions;

public class EntityNotFoundException extends jakarta.persistence.EntityNotFoundException {
    private final String message;

    public EntityNotFoundException(String message) {
        this.message = message;
    }
}
