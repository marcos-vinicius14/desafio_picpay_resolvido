package com.desafio.picpay.module.user.model;

import com.desafio.picpay.module.user.model.valueObjects.*;

import java.math.BigDecimal;
import java.util.Objects;

public class UserModel {
   private final Long id;
   private final String userName;
   private final Email email;
   private final Password password;
   private final UserType type;
   private final String documentNumber;
   private final Identifier identifier;
   private final BigDecimal balance;

   private UserModel(Builder builder) {
      this.id = builder.id;
      this.userName = builder.userName;
      this.email = builder.email;
      this.password = builder.password;
      this.type = builder.type;
      this.documentNumber = builder.documentNumber;
      this.identifier = builder.identifier;
      this.balance = builder.balance;

      if (!identifier.getNumber().equals(documentNumber)) {
         throw new IllegalArgumentException("DocumentNumber não corresponde ao Identifier");
      }
   }

   public static class Builder {
      private Long id;
      private Email email;
      private Password password;
      private String userName;
      private UserType type;
      private String documentNumber;
      private Identifier identifier;
      private BigDecimal balance;

      public Builder id(Long id) {
         this.id = id;
         return this;
      }

      public Builder email(Email email) {
         this.email = email;
         return this;
      }

      public Builder password(Password password) {
         this.password = password;
         return this;
      }

      public Builder userName(String userName) {
         this.userName = userName;
         return this;
      }

      public Builder type(UserType type) {
         this.type = type;
         return this;
      }

      public Builder balance(BigDecimal balance) {
         this.balance = balance;
         return this;
      }

      public Builder identifier(String documentNumber, UserType userType) {
         this.documentNumber = documentNumber;
         this.identifier = IdentifierFactory.create(type, documentNumber);
         return this;
      }

      public UserModel build() {
         Objects.requireNonNull(email, "Email can not be null");
         Objects.requireNonNull(password, "Password can not be null");
         Objects.requireNonNull(userName, "UserName can not be null");
         Objects.requireNonNull(identifier, "Identifier can not be null");
         Objects.requireNonNull(balance, "Balance can not be null");
         return new UserModel(this);
      }
   }


   public Long getId() {
      return id;
   }

   public String getUserName() {
      return userName;
   }


   public Email getEmail() {
      return email;
   }

   public Password getPassword() {
      return password;
   }

   public UserType getType() {
      return type;
   }

   public String getDocumentNumber() {
      return documentNumber;
   }

   public Identifier getIdentifier() {
      return identifier;
   }

   public BigDecimal getBalance() {
      return balance;
   }
}


