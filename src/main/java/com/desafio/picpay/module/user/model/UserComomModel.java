package com.desafio.picpay.module.user.model;

import com.desafio.picpay.module.user.model.valueObjects.CPF;
import com.desafio.picpay.module.user.model.valueObjects.Email;
import com.desafio.picpay.module.user.model.valueObjects.Password;
import com.desafio.picpay.module.user.model.valueObjects.TypeUser;

public class UserComomModel extends BasedUser {
    private CPF cpf;

    public UserComomModel(String username, Password password, Email email, TypeUser typeUser, double balance) {
        super(username, password, email, typeUser, balance);
    }

    public CPF getCpf() {
        return cpf;
    }
}
