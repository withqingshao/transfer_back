package com.zsq.datatransfer.gloab;

public class CustomException extends Exception {

    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }
}
