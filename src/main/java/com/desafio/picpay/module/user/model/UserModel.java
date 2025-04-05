package com.desafio.picpay.module.user.model;

import com.desafio.picpay.module.user.model.valueObjects.*;

public class UserModel  {
   private final Long id;
   private String userName;
   private final Email email;
   private final Password password;
   private final UserType type;
   private final String documentNumber;
   private final Identifier identifier;

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
}
