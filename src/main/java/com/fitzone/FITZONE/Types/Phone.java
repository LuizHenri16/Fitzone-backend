package com.fitzone.FITZONE.Types;

public class Phone {
    private String number;

    public Phone() {}

    public Phone(String value) {
        System.out.println("Recebido: '" + value + "'");
        if (!validate(value)) {
            throw new IllegalArgumentException("Telefone inválido");
        }
        this.number = value;
    }

    public String getNumber() {
        return this.number;
    }

    private static boolean validate(String phone) {
        if (phone == null) {
            return false;
        }
        phone = phone.trim().replaceAll("\\s+", " ");
        String regex = "^\\([1-9]{2}\\)\\s?9\\d{4}-\\d{4}$";
        return phone.matches(regex);
    }
}
