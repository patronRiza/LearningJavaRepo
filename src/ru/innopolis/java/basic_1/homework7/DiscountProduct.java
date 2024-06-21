package ru.innopolis.java.basic_1.homework7;

import java.util.Objects;

public class DiscountProduct extends Product{

    private final double discount;

    public DiscountProduct(String productName, double productPrice, double discount) {
        super(productName, productPrice);
        this.discount = discount;
    }

    @Override
    public double getTotalPrice() {
        return super.getTotalPrice() * (1 - discount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiscountProduct that)) return false;
        if (!super.equals(o)) return false;
        return Double.compare(discount, that.discount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
