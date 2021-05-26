package com.jlochoam.atcvapi.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class GlobalExceptionBody {
    private LocalDateTime timestamp;
    private Integer statusCode;
    private String error;
    private String message;
    private String path;
    private List<ErrorDetails> details;

    @Data
    public static class ErrorDetails {
        private String fieldName;
        private String errorMessage;
    }
}
