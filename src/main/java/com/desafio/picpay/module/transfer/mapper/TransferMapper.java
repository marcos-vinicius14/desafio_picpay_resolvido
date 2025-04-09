package com.desafio.picpay.module.transfer.mapper;

import com.desafio.picpay.module.transfer.dto.TransferResponseDTO;
import com.desafio.picpay.module.transfer.entity.TransferEntity;
import com.desafio.picpay.module.transfer.model.TransferModel;
import com.desafio.picpay.module.user.mapper.UserMapper;

import java.util.Objects;


public class TransferMapper {
    public static TransferEntity toEntity(TransferModel transferModel) {
        return TransferEntity.builder()
                .id(transferModel.getId())
                .value(transferModel.getValue())
                .createdAt(transferModel.getCreatedAt())
                .user(UserMapper.toEntity(transferModel.getUser()))
                .build();
    }

    public static TransferEntity toEntity(TransferResponseDTO transferDTO) {
        Objects.requireNonNull(transferDTO, "TransferDTO não pode ser nulo");

        return TransferEntity.builder()
                .payeeId(transferDTO.payeeId())
                .payerId(transferDTO.payerId())
                .value(transferDTO.value())
                .build();
    }

    public static TransferModel toModel(TransferEntity transferEntity) {
        return new TransferModel.Builder()
                .setId(transferEntity.getId())
                .setCretedAt(transferEntity.getCreatedAt())
                .setUser(UserMapper.toDomainModel(transferEntity.getUser()))
                .setValue(transferEntity.getValue())
                .build();
    }
}
