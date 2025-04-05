package com.desafio.picpay.module.user.model.valueObjects;

import java.util.Objects;
import java.util.regex.Pattern;

public class Password {
    private final String password;
    private final static int MAX_PASSWORD_LENGTH = 60;
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,60}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public Password(String password) {
        this.validate(password);
        this.password = password;
    }

    private void validate(String password) {
        Objects.requireNonNull(password, "Password cannot be null");

        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new IllegalArgumentException("Invalid password");
        }

        if (password.length() > MAX_PASSWORD_LENGTH) {
            throw new IllegalArgumentException("Password exceeds maximum length");
        }

        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        if (password.contains(" ")) {
            throw new IllegalArgumentException("Password contains spaces");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password should be at least 8 characters");
        }

    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "[PROTECTED]";
    }
}
