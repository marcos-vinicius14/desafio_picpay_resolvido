package com.desafio.picpay.module.transfer.service;

import com.desafio.picpay.module.transfer.dto.CreateTransferDTO;
import com.desafio.picpay.module.transfer.dto.TransferResponseDTO;

public interface TransferServiceInterface {
    TransferResponseDTO createTransfer(CreateTransferDTO createTransferDTO);
}
