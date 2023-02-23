package com.stc.clinic.exceptions;


public class APIException extends RuntimeException{

    public APIException(String message) {
        super(message);
    }
}
