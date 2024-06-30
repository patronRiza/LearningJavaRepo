package ru.innopolis.java.basic_1.homework7.enums;

public enum DiscountLevels {
    DEFAULT_DISCOUNT("0"),
    BRONZE_DISCOUNT("15"),
    SILVER_DISCOUNT("25"),
    GOLD_DISCOUNT("50");

    private final String discount;

    DiscountLevels(String discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return discount;
    }
}
