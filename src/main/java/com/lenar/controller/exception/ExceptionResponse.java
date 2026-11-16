package com.lenar.controller.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private final int status;
    private final String message;
    private final LocalDateTime timeStamp;

    public ExceptionResponse(int status, String message, LocalDateTime timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }
}
