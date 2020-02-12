package org.model;
//this is message class
public class Message {
    private boolean Success;
    private String errorMessage;
    private User data;

    public boolean isSuccess() {
        return Success;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
