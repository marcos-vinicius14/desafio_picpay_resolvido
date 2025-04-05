package com.desafio.picpay.module.user.model;

import com.desafio.picpay.module.user.model.valueObjects.CNPJ;
import com.desafio.picpay.module.user.model.valueObjects.Email;
import com.desafio.picpay.module.user.model.valueObjects.Password;
import com.desafio.picpay.module.user.model.valueObjects.TypeUser;

public class UserLojistaModel extends BasedUser {
    private CNPJ cnpj;

    public UserLojistaModel(String username, Password password, Email email, TypeUser typeUser, Double balance) {
        super(username, password, email, typeUser, balance);
    }

    public CNPJ getCnpj() {
        return cnpj;
    }
}
