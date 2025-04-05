package com.desafio.picpay.module.user.model.valueObjects;

public interface Identifier {
    String getNumber();
    String getFormatNumber();
    void validate(String number);
}
