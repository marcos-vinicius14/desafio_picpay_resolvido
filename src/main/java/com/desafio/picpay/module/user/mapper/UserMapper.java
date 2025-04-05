package com.desafio.picpay.module.user.mapper;

import com.desafio.picpay.module.user.UserDTO;
import com.desafio.picpay.module.user.entity.UserEntity;
import com.desafio.picpay.module.user.model.UserModel;
import com.desafio.picpay.module.user.model.valueObjects.*;

import java.util.Objects;

public class UserMapper {

    public static UserEntity toEntity(UserModel model) {
        Objects.requireNonNull(model);

        UserEntity entity = new UserEntity();
        entity.setId(model.getId());
        entity.setEmail(model.getEmail().getEmail());
        entity.setPassword(model.getPassword().getPassword());
        entity.setUserName(model.getUserName());
        entity.setType(model.getType());
        entity.setDocumentNumber(model.getIdentifier().getNumber()); // Extrai número do Identifier
        entity.setBalance(model.getBalance());
        return entity;
    }

    public static UserModel toDomainModel(UserEntity entity) {
        Objects.requireNonNull(entity);

        UserType type = entity.getType();
        Identifier identifier = type == UserType.COMUM
                ? new CPF(entity.getDocumentNumber())
                : new CNPJ(entity.getDocumentNumber());

        return new UserModel(
                entity.getId(),
                new Email(entity.getEmail()),
                new Password(entity.getPassword()),
                entity.getUserName(),
                type,
                identifier, // Usa o Identifier
                entity.getBalance()
        );
    }

    public static UserDTO toDTO(UserModel model) {
        Objects.requireNonNull(model);
        return new UserDTO(
                model.getId(),
                model.getUserName(),
                model.getEmail().getEmail(),
                model.getIdentifier().getFormatNumber(), // Assume método getFormatted()
                model.getType().toString(),
                model.getBalance()
        );
    }
}