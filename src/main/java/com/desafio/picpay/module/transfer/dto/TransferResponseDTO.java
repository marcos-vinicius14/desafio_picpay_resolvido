package com.desafio.picpay.module.transfer.dto;

import java.math.BigDecimal;

public record TransferResponseDTO( Long payerId, Long payeeId, BigDecimal value) {
}
