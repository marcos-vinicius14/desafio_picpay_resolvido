package com.desafio.picpay.module.transfer.service;

import com.desafio.picpay.module.transfer.dto.CreateTransferDTO;
import com.desafio.picpay.module.transfer.dto.TransferResponseDTO;
import com.desafio.picpay.module.transfer.mapper.TransferMapper;
import com.desafio.picpay.module.transfer.repository.TransferRepository;
import com.desafio.picpay.module.user.dto.UserResponseDTO;
import com.desafio.picpay.module.user.model.valueObjects.UserType;
import com.desafio.picpay.module.user.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferServiceInterface {
    private final TransferRepository transferRepository;
    private final UserServiceImpl userService;

    @Override
    public TransferResponseDTO createTransfer(CreateTransferDTO createTransferDTO) {
        UserResponseDTO payer = userService.findUserById(createTransferDTO.payerId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payer not found"));

        UserResponseDTO payee = userService.findUserById(createTransferDTO.payeeId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payee not found"));

        BigDecimal amount = createTransferDTO.amount();

        validateTransfer(payer, amount);

        payer.balance().subtract(amount);
        payee.balance().add(amount);


        TransferResponseDTO transfer = new TransferResponseDTO(
                payee.id(),
                payee.id(),
                amount
        );



        return transfer;

    }


    private void validateTransfer(UserResponseDTO payer, BigDecimal value) {
        // 1. Valida se o tipo de usuário é LOJISTA (convertendo String para enum)
        try {
            UserType userType = UserType.valueOf(payer.userType());
            if (userType == UserType.LOJISTA) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Lojistas não podem transferir");
            }
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Tipo de usuário inválido: " + payer.userType());
        }

        // 2. Valida saldo suficiente
        if (payer.balance().compareTo(value) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente");
        }
    }

}
