package com.desafio.picpay.module.user.dto;

import java.math.BigDecimal;

public record UserResponseDTO(Long id,
                              String userName,
                              String email,
                              String identifier,
                              String userType,
                              BigDecimal balance
                      ) {}
