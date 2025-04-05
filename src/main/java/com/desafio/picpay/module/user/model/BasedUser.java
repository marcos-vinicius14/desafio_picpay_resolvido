package com.desafio.picpay.module.user.model;

import com.desafio.picpay.module.user.model.valueObjects.Email;
import com.desafio.picpay.module.user.model.valueObjects.Password;
import com.desafio.picpay.module.user.model.valueObjects.TypeUser;
import lombok.Getter;

@Getter
public abstract class BasedUser {
    private final String username;
    private final Password password;
    private final Email email;
    private final TypeUser typeUser;
    private  double balance;

    public BasedUser(String username, Password password, Email email, TypeUser typeUser, double balance) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.typeUser = typeUser;
        this.balance = balance;
    }

}
