package com.jlochoam.atcvapi.controller;

import com.jlochoam.atcvapi.exception.CVNotFoundException;
import com.jlochoam.atcvapi.exception.GlobalExceptionBody;
import com.jlochoam.atcvapi.exception.MissingRequiredFieldException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    protected static final String URI_LABEL = "uri=";

    @ExceptionHandler(value = { CVNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(
            CVNotFoundException exception, WebRequest request) {
        GlobalExceptionBody body = new GlobalExceptionBody();
        body.setTimestamp(LocalDateTime.now());
        body.setStatusCode(HttpStatus.NOT_FOUND.value());
        body.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
        body.setMessage(exception.getMessage());
        body.setPath(request.getDescription(false).replace(URI_LABEL, ""));
        return handleExceptionInternal(
                exception, body, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = { MissingRequiredFieldException.class })
    protected ResponseEntity<Object> handleMissingRequiredField(
            MissingRequiredFieldException exception, WebRequest request) {
        GlobalExceptionBody body = new GlobalExceptionBody();
        body.setTimestamp(LocalDateTime.now());
        body.setStatusCode(HttpStatus.BAD_REQUEST.value());
        body.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        body.setMessage(exception.getMessage());
        body.setPath(request.getDescription(false).replace(URI_LABEL, ""));
        return handleExceptionInternal(
                exception, body, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
