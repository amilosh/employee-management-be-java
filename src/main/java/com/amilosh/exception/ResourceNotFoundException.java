package com.amilosh.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    // e.g. throw new ResourceNotFoundException("Employee with id: %s not found", employee.getId())
    public ResourceNotFoundException(String format, Object... args) {
        super(String.format(format, args));
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
