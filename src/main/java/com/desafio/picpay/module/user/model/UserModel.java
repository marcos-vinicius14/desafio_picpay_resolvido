package com.desafio.picpay.module.user.model;

import com.desafio.picpay.module.user.model.valueObjects.*;

import java.math.BigDecimal;

public class UserModel  {
   private Long id;
   private String userName;
   private Email email;
   private Password password;
   private UserType type;
   private String documentNumber;
   private Identifier identifier;
   private BigDecimal balance;

   public UserModel(Long id, Email email, Password password, String userName, UserType type, Identifier documentNumber, BigDecimal balance) {
      this.id = id;
      this.email = email;
      this.password = password;
      this.userName = userName;
      this.type = type;
      this.documentNumber = documentNumber;
      this.balance = balance;

      this.identifier = IdentifierFactory.create(type, documentNumber);

   }


   public Long getId() {
      return id;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
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

   public void setId(Long id) {
      this.id = id;
   }

   public void setEmail(Email email) {
      this.email = email;
   }

   public void setPassword(Password password) {
      this.password = password;
   }

   public void setType(UserType type) {
      this.type = type;
   }

   public void setDocumentNumber(String documentNumber) {
      this.documentNumber = documentNumber;
   }

   public void setIdentifier(Identifier identifier) {
      this.identifier = identifier;
   }

   public void setBalance(BigDecimal balance) {
      this.balance = balance;
   }
}
