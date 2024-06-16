package ru.innopolis.java.basic_1.homework5;

public class Television {
    //Constants
    private final int DEFAULT_CHANEL = 1;
    public final int DEFAULT_VOLUME = 10;
    private final boolean DEFAULT_STATUS = false;

    private final String manufacturer;
    private final String diagonal;
    private double cost;
    protected int chanel;
    protected int volume;
    private boolean isOn;

    public Television(String manufacturer, double cost, String diagonal) {
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.diagonal = diagonal;
        this.chanel = DEFAULT_CHANEL;
        this.volume = DEFAULT_VOLUME;
        this.isOn = DEFAULT_STATUS;
    }

    public Television(String manufacturer, String diagonal) {
        this.manufacturer = manufacturer;
        this.diagonal = diagonal;
        this.chanel = DEFAULT_CHANEL;
        this.volume = DEFAULT_VOLUME;
        this.isOn = DEFAULT_STATUS;
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
                ", diagonal='" + diagonal + '\'' +
                ", cost=" + cost +
                ", chanel=" + chanel +
                ", volume=" + volume +
                ", isOn=" + isOn +
                '}';
    }
}
