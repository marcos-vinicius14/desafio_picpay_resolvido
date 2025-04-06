package com.desafio.picpay.module.user.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException{
    public UserNotFoundException(String message) {
        super(message);
    }

}
