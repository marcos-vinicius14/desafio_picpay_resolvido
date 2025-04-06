package com.desafio.picpay.module.user.dto;

import com.desafio.picpay.module.user.model.valueObjects.UserType;

import java.math.BigDecimal;

public record UserCreateDTO(
        String userName,
        String email,
        String password,
        String documentNumber,
        UserType userType,
        BigDecimal initialBalance
) {
}
