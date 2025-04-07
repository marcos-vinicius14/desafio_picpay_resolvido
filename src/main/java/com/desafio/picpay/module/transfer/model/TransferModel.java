package com.desafio.picpay.module.transfer.model;

import com.desafio.picpay.module.user.model.UserModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class TransferModel {
    private final Long id;
    private final BigDecimal value;
    private final UserModel payer;
    private final UserModel payee;
    private final LocalDateTime createdAt = LocalDateTime.now();

    private TransferModel(TransferBuilder builder) {
        this.id = builder.id;
        this.value = builder.value;
        this.payer = builder.payer;
        this.payee = builder.payee;
    }


    public static class TransferBuilder {
        private BigDecimal value;
        private LocalDateTime cretedAt;
        private UserModel payer;
        private UserModel payee;
        private Long id;

        public  TransferBuilder (Long id, BigDecimal value, LocalDateTime cretedAt, UserModel payer, UserModel payee) {
            this.value = value;
            this.cretedAt = cretedAt;
            this.payer = payer;
            this.payee = payee;
            this.id = id;
        }

        public TransferBuilder setValue (BigDecimal value) {
            this.value = value;
            return this;
        }

        public TransferBuilder setCretedAt (LocalDateTime cretedAt) {
            this.cretedAt = cretedAt;
            return this;
        }

        public TransferBuilder setPayer (UserModel payer) {
            this.payer = payer;
            return this;
        }

        public TransferBuilder setPayee (UserModel payee) {
            this.payee = payee;
            return this;
        }

        public TransferBuilder setId (Long id) {
            this.id = id;
            return this;
        }

        public TransferModel build() {
            Objects.requireNonNull(value, "value is required");
            Objects.requireNonNull(cretedAt, "cretedAt is required");
            Objects.requireNonNull(payer, "payer is required");
            Objects.requireNonNull(payee, "payee is required");
            return new TransferModel(this);
        }
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public UserModel getPayer() {
        return payer;
    }

    public UserModel getPayee() {
        return payee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
