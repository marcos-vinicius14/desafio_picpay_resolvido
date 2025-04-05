package com.desafio.picpay.module.user.model.valueObjects;

import java.util.Objects;
import java.util.regex.Pattern;

public class Email  {
    private final String email;
    private final static String EMAIL_REGEX =
            "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z]{2,})+$";
    private final static Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public Email(String email) {
        this.validate(email);
        this.email = email;
    }

    private void validate(String email) {
        Objects.requireNonNull(email, "Email cannot be null");

        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email");
        }
        if (email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if (email.contains(" ")) {
            throw new IllegalArgumentException("Email cannot contain spaces");
        }
    }

    public String getEmail() {
        return email;
    }
}
