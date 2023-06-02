package com.books.exceptions;

public class BookError {

    private String errorMessage;
    private String fieldsAvailable;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getFieldsAvailable() {
        return fieldsAvailable;
    }

    public void setFieldsAvailable(String fieldsAvailable) {
        this.fieldsAvailable = fieldsAvailable;
    }

}
