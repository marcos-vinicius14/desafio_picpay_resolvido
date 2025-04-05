package com.desafio.picpay.module.user.model.valueObjects;

public class IdentifierFactory {
    public static Identifier create(UserType type, String documentNumber) {
        return switch (type) {
            case COMUM -> new CPF(documentNumber);
            case LOJISTA -> new CNPJ(documentNumber);
        };
    }
}
