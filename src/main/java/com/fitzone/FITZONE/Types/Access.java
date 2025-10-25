package com.fitzone.FITZONE.Types;

public enum Access {
    TOTAL("Total"),
    PARCIAL("Parcial");

    private String value;

    Access(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
