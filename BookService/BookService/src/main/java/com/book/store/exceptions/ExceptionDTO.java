package com.book.store.exceptions;

public class ExceptionDTO {
    private String message;
    private boolean isSuccess;

    public ExceptionDTO(String message) {
        this.message = message;
        this.isSuccess = false;
    }

    public ExceptionDTO(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public ExceptionDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
