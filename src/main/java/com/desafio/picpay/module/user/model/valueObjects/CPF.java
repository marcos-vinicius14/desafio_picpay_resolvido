package com.desafio.picpay.module.user.model.valueObjects;

import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.regex.Pattern;

@EqualsAndHashCode
public class CPF implements Identifier {
    private final String number;
    private final static String CPF_REGEX =
            "^(\\d{3}\\.?\\d{3}\\.?\\d{3}-?\\d{2}|\\d{11})$";

    private final static Pattern CPF_PATTERN = Pattern.compile(CPF_REGEX);

    public CPF(String cpf) {
        Objects.requireNonNull(cpf);
        String numericCpf = cpf.replaceAll("[^\\d]", ""); // Limpa apenas uma vez
        validate(numericCpf);
        this.number = numericCpf;
    }




    private boolean isValidVerificationDigits(String cpf) {
        //TODO: calculates the first check digit
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
        }

        int digit1 = (sum % 11) < 2 ? 0 : 11 - (sum % 11);

        //TODO: calculates the second check digit
        sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
        }
        int digit2 = (sum % 11) < 2 ? 0 : 11 - (sum % 11);

        return digit1 == Character.getNumericValue(cpf.charAt(9))
                && digit2 == Character.getNumericValue(cpf.charAt(10));
    }

    private boolean isAllDigitsEqual(String cpf) {
        return cpf.matches("(\\d)\\1{10}");
    }


    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getFormatNumber() {
        return number.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    @Override
    public void validate(String number) {
        Objects.requireNonNull(number, "CPF should not be null");

        if (number.isEmpty()) {
            throw new IllegalArgumentException("CPF cannot be empty");
        }
        if (!CPF_PATTERN.matcher(number).matches()) {
            throw new IllegalArgumentException("Invalid CPF format");
        }
        if (number.length() != 11) {
            throw new IllegalArgumentException("CPF must have 11 digits");
        }
        if (isAllDigitsEqual(number)) {
            throw new IllegalArgumentException("CPF cannot have all digits equal");
        }
        if (!isValidVerificationDigits(number)) {
            throw new IllegalArgumentException("Invalid CPF verification digits");
        }
    }
}



