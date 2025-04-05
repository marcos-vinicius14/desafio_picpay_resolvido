package com.desafio.picpay.module.user.model.valueObjects;

import java.util.Objects;
import java.util.regex.Pattern;

public class CNPJ {
    private final String cnpj;
    private static final String CNPJ_REGEX = "^(\\d{2}\\.?\\d{3}\\.?\\d{3}/?\\d{4}-?\\d{2}|\\d{14})$";
    private static final Pattern CNPJ_PATTERN = Pattern.compile(CNPJ_REGEX);

    public CNPJ(String cnpj) {
        Objects.requireNonNull(cnpj, "CNPJ should not be null");
        String numericCnpj = cnpj.replaceAll("[^\\d]", "");
        validate(numericCnpj);
        this.cnpj = numericCnpj;
    }

    private void validate(String cnpj) {
        if (cnpj.isEmpty()) {
            throw new IllegalArgumentException("CNPJ cannot be empty");
        }
        if (!CNPJ_PATTERN.matcher(cnpj).matches()) {
            throw new IllegalArgumentException("Invalid CNPJ format");
        }
        if (cnpj.length() != 14) {
            throw new IllegalArgumentException("CNPJ must have 14 digits");
        }
        if (isAllDigitsEqual(cnpj)) {
            throw new IllegalArgumentException("CNPJ cannot have all digits equal");
        }
        if (!isValidVerificationDigits(cnpj)) {
            throw new IllegalArgumentException("Invalid CNPJ verification digits");
        }
    }

    private boolean isValidVerificationDigits(String cnpj) {
        int[] weightsFirst = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weightsFirst[i];
        }
        int digit1 = (sum % 11) < 2 ? 0 : 11 - (sum % 11);

        int[] weightsSecond = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        sum = 0;
        for (int i = 0; i < 13; i++) {
            sum += Character.getNumericValue(cnpj.charAt(i)) * weightsSecond[i];
        }
        int digit2 = (sum % 11) < 2 ? 0 : 11 - (sum % 11);

        return digit1 == Character.getNumericValue(cnpj.charAt(12)) &&
                digit2 == Character.getNumericValue(cnpj.charAt(13));
    }

    private boolean isAllDigitsEqual(String cnpj) {
        return cnpj.matches("(\\d)\\1{13}");
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getFormattedCnpj() {
        return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }
}
