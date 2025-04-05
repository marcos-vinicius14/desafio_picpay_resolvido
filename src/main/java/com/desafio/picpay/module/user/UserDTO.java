package com.desafio.picpay.module.user;

import com.desafio.picpay.module.user.model.valueObjects.UserType;

import java.math.BigDecimal;

public record UserDTO(Long id,
                      String userName,
                      String email,
                      String identifier,
                      String userType,
                      BigDecimal balance
                      ) {}
