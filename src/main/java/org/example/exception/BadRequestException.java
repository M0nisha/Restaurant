package org.example.exception;

import java.util.List;

public class BadRequestException extends RuntimeException{

  public List<java.lang.Error> errors;

    public List<java.lang.Error> getErrors() {
        return errors;
    }

    public void setErrors(List<java.lang.Error> errors) {
        this.errors = errors;
    }

    public BadRequestException(String message, List<java.lang.Error> errors) {
        super(message);
        this.errors = errors;
    }
}
