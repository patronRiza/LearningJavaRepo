package ru.innopolis.java.basic_1.homework8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private final String name;
    private double money;
    private List<Product> packageOfProducts = new ArrayList<>();

    public Person(String name, double money) {
        this.name = name;
        if (money < 0)
            System.out.println("Деньги не могут быть отрицательным числом");
        else {
            this.money = money;
        }
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double costOfProduct) {
        this.money -= costOfProduct;
    }

    public List<Product> getPackageOfProducts() {
        return packageOfProducts;
    }

    public void addPackageOfProducts(Product product) {
        packageOfProducts.add(product);
    }

    @Override
    public String toString() {
        return name + " {" +
                "на счету = " + money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Double.compare(money, person.money) == 0 && Objects.equals(name, person.name) && Objects.equals(packageOfProducts, person.packageOfProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money, packageOfProducts);
    }
}
