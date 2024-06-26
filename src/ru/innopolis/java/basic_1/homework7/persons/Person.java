package ru.innopolis.java.basic_1.homework7.persons;

import ru.innopolis.java.basic_1.homework7.prooducts.Product;

import java.util.List;
import java.util.Objects;

public abstract class Person {
    private final String name;
    private final int age;
    private double money;

    protected Person(String name, double money, int age) {
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public abstract int getDiscountLevel();
    public abstract List<Product> getPackageOfProducts();
    public abstract void addPackageOfProducts(Product product);
    protected abstract void updateDiscountLevel();

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public int getAge() { return age; }

    public void setMoney(double costOfProduct) {
        this.money -= costOfProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Double.compare(money, person.money) == 0 && Objects.equals(name, person.name) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
