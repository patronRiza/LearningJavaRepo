package ru.innopolis.java.basic_1.homework7;

import ru.innopolis.java.basic_1.homework7.enums.DiscountLevels;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private final String name;
    private double money;

    private int numOfPurchases = 0;

    private final List<Product> packageOfProducts = new ArrayList<>();
    private int discountLevels;

    public Person(String name, double money) {
        this.name = name;
        if (money < 0) {
            System.out.println("Деньги не могут быть отрицательным числом");
        }
        else {
            this.money = money;
        }
        changeDiscountLevel();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double costOfProduct) {
        this.money -= costOfProduct * (1 - (this.discountLevels * 0.01));
    }

    public List<Product> getPackageOfProducts() {
        return packageOfProducts;
    }

    public void addPackageOfProducts(Product product) {
        packageOfProducts.add(product);
        numOfPurchases++;
        changeDiscountLevel();
    }

    private void changeDiscountLevel() {
        if (numOfPurchases == 6) {
            this.numOfPurchases = 0;
        }
        switch (this.numOfPurchases) {
            case 0,1 -> this.discountLevels = Integer.parseInt(DiscountLevels.valueOf("DEFAULT_DISCOUNT").toString());
            case 2,3 -> this.discountLevels = Integer.parseInt(DiscountLevels.valueOf("BRONZE_DISCOUNT").toString());
            case 4 -> this.discountLevels = Integer.parseInt(DiscountLevels.valueOf("SILVER_DISCOUNT").toString());
            case 5 -> this.discountLevels = Integer.parseInt(DiscountLevels.valueOf("GOLD_DISCOUNT").toString());
        }

    }

    @Override
    public String toString() {
        return name + " {" +
                "на счету = " + money +
                "уровень скидки = " + discountLevels + " %" +
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
