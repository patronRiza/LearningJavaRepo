package ru.innopolis.java.basic_1.homework7.prooducts;

import java.util.Objects;

public class DiscountProduct extends Product {

    private final double discount;

    public DiscountProduct(String productName, double productPrice, double discount) {
        super(productName, (productPrice * (1 - discount * 0.01)));
        this.discount = discount;
        super.status = true;
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

    @Override
    public String toString() {
        return super.getProductName() + " {" +
                "цена = " + super.getTotalPrice() +
                ", скидка на товар=" + discount +
                "}";
    }
}
