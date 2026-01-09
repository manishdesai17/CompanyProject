package com.login.login.helper;

import java.time.LocalDateTime;

public class APIResponse {
    private int statusCode;
    private String message;
    private LocalDateTime timeStamp;

    public APIResponse(int statusCode, String message, LocalDateTime timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
