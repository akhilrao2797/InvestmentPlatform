package com.akhilrao2797.invest.models.exception;

import com.akhilrao2797.invest.utils.ErrorCodeMapper;

public class UserNotFoundException extends RuntimeException{
    private int messageId;
    private String message;

    public UserNotFoundException(String message) {
        super(message);
        this.messageId = ErrorCodeMapper.getValue(message);
    }

    public int getMessageId() {
        return messageId;
    }
}
