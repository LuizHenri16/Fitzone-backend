package com.fitzone.FITZONE.Types;

public class Phone {
    private String value;

    public Phone() {}

    public Phone(String value) {
        if (!validate(value)) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    private static boolean validate(String phone) {
        String regex = "^\\([1-9]{2}\\)\\s9\\d{4}-\\d{4}$";
        return phone != null && phone.matches(regex);
    }
}
