package com.desafio.picpay.module.transfer.model;

import com.desafio.picpay.module.user.model.UserModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class TransferModel {
    private final Long id;
    private final BigDecimal value;
    private final UserModel user;
    private final LocalDateTime createdAt = LocalDateTime.now();

    private TransferModel(Builder builder) {
        this.id = builder.id;
        this.value = builder.value;
        this.user = builder.user;
    }


    public static class Builder {
        private BigDecimal value;
        private LocalDateTime cretedAt;
        private UserModel user;
        private Long id;


        public Builder setValue (BigDecimal value) {
            this.value = value;
            return this;
        }

        public Builder setCretedAt (LocalDateTime cretedAt) {
            this.cretedAt = cretedAt;
            return this;
        }


        public Builder setUser (UserModel payee) {
            this.user = payee;
            return this;
        }

        public Builder setId (Long id) {
            this.id = id;
            return this;
        }

        public TransferModel build() {
            Objects.requireNonNull(value, "value is required");
            Objects.requireNonNull(cretedAt, "cretedAt is required");
            Objects.requireNonNull(user, "payer is required");
            return new TransferModel(this);
        }
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }


    public UserModel getUser() {
        return user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
