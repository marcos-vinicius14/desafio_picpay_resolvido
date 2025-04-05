package com.desafio.picpay.module.user.model;

import com.desafio.picpay.module.user.model.valueObjects.*;

public class UserModel  {
   private Long id;
   private String userName;
   private Email email;
   private Password password;
   private UserType type;
   private String documentNumber;
   private Identifier identifier;

   public UserModel(Long id, Email email, Password password, String userName, UserType type, String documentNumber) {
      this.id = id;
      this.email = email;
      this.password = password;
      this.userName = userName;
      this.type = type;
      this.documentNumber = documentNumber;

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
}
