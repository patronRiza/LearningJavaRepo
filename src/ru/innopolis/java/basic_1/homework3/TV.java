package ru.innopolis.java.basic_1.homework3;

public class TV {
    private String manufacturer;
    private double cost;
    private String diagonal;
    private boolean isOn;

    public TV(String manufacturer, double cost, String diagonal) {
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.diagonal = diagonal;
        this.isOn = false;
    }

    public TV(String manufacturer, String diagonal) {
        this.manufacturer = manufacturer;
        this.diagonal = diagonal;
        this.isOn = false;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    @Override
    public String toString() {
        return manufacturer + " - { " +
                "cost=" + cost +
                ", diagonal='" + diagonal + '\'' +
                ", isOn=" + isOn +
                " }";
    }
}
