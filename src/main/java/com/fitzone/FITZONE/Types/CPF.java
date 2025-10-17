package com.fitzone.FITZONE.Types;

import jakarta.persistence.Embeddable;

@Embeddable
public class CPF {
    private String cpf;

    public CPF() {
    }

    public CPF(String cpf) {
        if(!validate(cpf)) {
            throw new IllegalArgumentException("CPF inválido!");
        }
        this.cpf = cpf;
    }

    public String getCustomerCPF() {
        return cpf;
    }

    private static Boolean validate(String cpf){
        cpf = cpf.replaceAll("[^\\d]", "");
        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        try {
            int soma = 0, peso = 10;
            for (int i = 0; i < 9; i++)
                soma += Character.getNumericValue(cpf.charAt(i)) * peso--;

            int dv1 = 11 - (soma % 11);
            dv1 = (dv1 >= 10) ? 0 : dv1;

            soma = 0; peso = 11;
            for (int i = 0; i < 10; i++)
                soma += Character.getNumericValue(cpf.charAt(i)) * peso--;

            int dv2 = 11 - (soma % 11);
            dv2 = (dv2 >= 10) ? 0 : dv2;

            return dv1 == Character.getNumericValue(cpf.charAt(9)) &&
                    dv2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }
}
