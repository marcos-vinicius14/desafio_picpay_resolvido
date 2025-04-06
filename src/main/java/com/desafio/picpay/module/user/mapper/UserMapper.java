package com.desafio.picpay.module.user.mapper;

import com.desafio.picpay.module.user.dto.UserCreateDTO;
import com.desafio.picpay.module.user.dto.UserResponseDTO;
import com.desafio.picpay.module.user.entity.UserEntity;
import com.desafio.picpay.module.user.model.UserModel;
import com.desafio.picpay.module.user.model.valueObjects.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
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

        return new UserModel.Builder()
                .email(new Email(entity.getEmail()))
                .password(new Password(entity.getPassword()))
                .identifier(entity.getDocumentNumber(), entity.getType())
                .balance(entity.getBalance())
                .type(entity.getType())
                .userName(entity.getUserName())
                .build();
    }

    public static UserResponseDTO toDTO(UserModel model) {
        Objects.requireNonNull(model);
        return new UserResponseDTO(
                model.getId(),
                model.getUserName(),
                model.getEmail().getEmail(),
                model.getIdentifier().getFormatNumber(), // Assume método getFormatted()
                model.getType().toString(),
                model.getBalance()
        );
    }

    public static UserModel toCreateDtoToModel(UserCreateDTO dto) {
        Objects.requireNonNull(dto, "DTO não pode ser nulo");

        return new UserModel.Builder()
                .userName(dto.userName())
                .email(new Email(dto.email()))
                .password(new Password(dto.password()))
                .identifier(dto.documentNumber(), dto.userType())
                .balance(dto.initialBalance())
                .build();
    }


}