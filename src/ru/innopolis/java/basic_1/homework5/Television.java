package ru.innopolis.java.basic_1.homework5;

public class Television {

    private final String manufacturer;
    private final String diagonal;
    private final double cost;
    protected int chanel;
    protected int volume;
    private boolean isOn;

    public Television(String manufacturer, double cost, String diagonal) {
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.diagonal = diagonal;
        this.chanel = 1;
        this.volume = 10;
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
    }

    public void turnOff() {
        this.isOn = false;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        if (isOn) {
            return manufacturer + " - { " +
                    ", diagonal='" + diagonal + '\'' +
                    ", cost=" + cost +
                    ", chanel=" + chanel +
                    ", volume=" + volume +
                    ", isOn=" + isOn +
                    "}\n";
        } else {
            return manufacturer + " - { " +
                    ", diagonal='" + diagonal + '\'' +
                    ", cost=" + cost +
                    ", isOn=" + false +
                    "}\n";
        }
    }
}
