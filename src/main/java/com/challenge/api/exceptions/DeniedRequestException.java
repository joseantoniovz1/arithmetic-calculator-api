package com.challenge.api.exceptions;

public class DeniedRequestException extends RuntimeException {

    public DeniedRequestException(String message) {
        super(message);
    }

}
