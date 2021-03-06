package com.parameta.demo.common;

import org.springframework.http.HttpStatus;

public enum NotificationCode {
    NULL_DATE("BAD BUILT DATE, EXAMPLE OF A VALID DATE (YYYY-MM-DD)", HttpStatus.INTERNAL_SERVER_ERROR),
    MENOR_AGE("NOT OF AGE", HttpStatus.INTERNAL_SERVER_ERROR);


    private String description;
    private HttpStatus httpStatus;

    NotificationCode(String description, HttpStatus httpStatus) {
        this.description = description;
        this.httpStatus = httpStatus;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
