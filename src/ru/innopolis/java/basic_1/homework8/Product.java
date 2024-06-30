package ru.innopolis.java.basic_1.homework8;

import java.util.Objects;

public class Product {
    private final String productName;
    private double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        if (productPrice < 0)
            System.out.println("Стоимость продукта не может быть отрицательным числом");
        else {
            this.productPrice = productPrice;
        }
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public String toString() {
        return productName;
    }

    public String toAllString() {
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
