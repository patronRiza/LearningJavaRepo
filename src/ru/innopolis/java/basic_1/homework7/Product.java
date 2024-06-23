package ru.innopolis.java.basic_1.homework7;

import java.util.Objects;

public class Product {
    private final String productName;
    private final double productPrice;
    protected boolean status = false;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return productName + " {" +
                "цена = " + productPrice +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Double.compare(productPrice, product.productPrice) == 0 && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, productPrice);
    }
}
