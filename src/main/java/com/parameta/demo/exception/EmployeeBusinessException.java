package com.parameta.demo.exception;

import com.parameta.demo.common.NotificationCode;

import java.io.Serializable;

public class EmployeeBusinessException extends Exception implements Serializable {
    private final NotificationCode errorCode;


    public EmployeeBusinessException(NotificationCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public NotificationCode getErrorCode() {
        return errorCode;
    }
}
