package com.jlochoam.atcvapi.exception;

public class CVNotFoundException extends Exception {
    public CVNotFoundException(String exceptionDetails) {
        super(exceptionDetails);
    }
}
