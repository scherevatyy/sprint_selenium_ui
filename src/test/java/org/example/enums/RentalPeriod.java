package org.example.enums;

public enum RentalPeriod {
    ONE_DAY("сутки"),
    TWO_DAYS("двое суток"),
    THREE_DAYS("трое суток");

    private final String uiText;

    RentalPeriod(String uiText) {
        this.uiText = uiText;
    }

    public String getUiText() {
        return uiText;
    }
}