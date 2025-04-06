package com.desafio.picpay.module.user.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends BusinessException {
    public EmailAlreadyExistsException() {
        super("O email já está cadastrado!");
    }

    public HttpStatus getHttpStatus() {
        return HttpStatus.CONFLICT;
    }
}
