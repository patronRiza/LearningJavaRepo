package ru.innopolis.java.basic_1.homework7.persons;

import ru.innopolis.java.basic_1.homework7.enums.Ages;
import ru.innopolis.java.basic_1.homework7.enums.DiscountLevels;
import ru.innopolis.java.basic_1.homework7.prooducts.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Retiree extends Person {
    private int discountLevels;
    private int numOfPurchases = 0;
    private final List<Product> packageOfProducts = new ArrayList<>();
    private final Ages ageStatus = Ages.RETIREE;

    public Retiree(String name, double money, int age) {
        super(name, money, age);
        updateDiscountLevel();
    }

    public int getDiscountLevel() {
        return discountLevels;
    }

    public List<Product> getPackageOfProducts() {
        return packageOfProducts;
    }

    public void addPackageOfProducts(Product product) {
        packageOfProducts.add(product);
        numOfPurchases++;
        updateDiscountLevel();
    }

    @Override
    protected void updateDiscountLevel() {
        if (numOfPurchases == 6) {
            this.numOfPurchases = 0;
        }
        switch (this.numOfPurchases) {
            case 0,1 -> this.discountLevels = Integer.parseInt(DiscountLevels.valueOf("DEFAULT_DISCOUNT").toString());
            case 2,3 -> this.discountLevels = Integer.parseInt(DiscountLevels.valueOf("BRONZE_DISCOUNT").toString());
            case 4 -> this.discountLevels = Integer.parseInt(DiscountLevels.valueOf("SILVER_DISCOUNT").toString());
            case 5 -> this.discountLevels = Integer.parseInt(DiscountLevels.valueOf("GOLD_DISCOUNT").toString());
        }
        this.discountLevels += 5;
    }

    @Override
    public String toString() {
        return super.getName() + " - " + ageStatus + " {" +
                "на счету = " + super.getMoney() +
                " уровень скидки = " + discountLevels + " %" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Retiree retiree)) return false;
        if (!super.equals(o)) return false;
        return ageStatus == retiree.ageStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ageStatus);
    }
}
