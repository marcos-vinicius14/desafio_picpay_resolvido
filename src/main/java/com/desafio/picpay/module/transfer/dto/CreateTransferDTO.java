package com.desafio.picpay.module.transfer.dto;

import java.math.BigDecimal;

public record CreateTransferDTO(Long payerId, Long payeeId, BigDecimal amount) {
}
