package com.desafio.picpay.module.transfer.mapper;

import com.desafio.picpay.module.transfer.entity.TransferEntity;
import com.desafio.picpay.module.transfer.model.TransferModel;
import com.desafio.picpay.module.user.mapper.UserMapper;


public class TransferMapper {
    public static TransferEntity toEntity(TransferModel transferModel) {
        TransferEntity transferEntity = new TransferEntity();

        transferEntity.setId(transferModel.getId());
        transferEntity.setValue(transferModel.getValue());
        transferEntity.setCreatedAt(transferModel.getCreatedAt());
        transferEntity.setUser(UserMapper.toEntity(transferModel.getUser()));

        return transferEntity;
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
