package com.nick.hateportal.utils.exception;

public class EmailExistsException extends Exception{

    public EmailExistsException() {
    }

    public EmailExistsException(String message) {
        super(message);
    }

    public EmailExistsException(Throwable cause) {
        super(cause);
    }
}
