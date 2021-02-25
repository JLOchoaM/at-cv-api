package com.jlochoam.atcvapi.exception;

public class MissingRequiredFieldException extends Exception {
    public MissingRequiredFieldException(String exceptionDetails) {
        super(exceptionDetails);
    }
}
