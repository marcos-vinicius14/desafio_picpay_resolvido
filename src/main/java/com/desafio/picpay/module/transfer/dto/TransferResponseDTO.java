package com.desafio.picpay.module.transfer.dto;

import java.math.BigDecimal;

public record TransferResponseDTO(BigDecimal value, String payer, String payee) {
}
