package com.desafio.picpay.module.transfer.dto;

import java.math.BigDecimal;

public record CreateTransferDTO(String documentNumber, BigDecimal amount) {
}
