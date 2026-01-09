package org.example.enums;

public enum ScooterColor {
    BLACK("black"),
    GREY("grey");

    private final String checkboxId;

    ScooterColor(String checkboxId) {
        this.checkboxId = checkboxId;
    }

    public String getCheckboxId() {
        return checkboxId;
    }
}