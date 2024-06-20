package ru.innopolis.java.basic_1.homework6.additionaltask;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Television {

    private static final List<Chanel> channels = Arrays.asList(
            new Chanel(1, "СТС",
                    new Program("Галилео", 4.7, 1500)),
            new Chanel(2, "ТВ3",
                    new Program("Битва экстрасенсов", 4.9, 5600)),
            new Chanel(3, "РенТВ",
                    new Program("Мировой заговор", 4.8, 10000)),
            new Chanel(4, "Россия24",
                    new Program("Новости", 3.7, 1000)),
            new Chanel(5, "Первый",
                    new Program("Балет", 3.9, 300))
            );
    private Random rand = new Random();
    private final String manufacturer;
    private final String diagonal;
    private final double cost;
    private String chanel;
    private int volume;
    private boolean isOn;


    public Television(String manufacturer, double cost, String diagonal) {
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.diagonal = diagonal;
        this.chanel = channels.get(rand.nextInt(channels.size())).getChanelName();
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

    public void setChanel(String chanel) {this.chanel = chanel;}


    @Override
    public String toString() {
        if (isOn) {
            return manufacturer + " - { " +
                    "diagonal='" + diagonal + '\'' +
                    ", cost=" + cost +
                    ", chanel=" + chanel +
                    ", volume=" + volume +
                    ", isOn=on" +
                    "}\n";
        } else {
            return manufacturer + " - { " +
                    "diagonal='" + diagonal + '\'' +
                    ", cost=" + cost +
                    ", isOn=off" +
                    "}\n";
        }
    }

    public static class TvRemoteController {
        private TvRemoteController(){}

        public static void turnOn(Television tv) {
            tv.turnOn();
        }

        public static void turnOff(Television tv) {
            tv.turnOff();
        }

        public static void menuOfChannels() {
            for (Chanel chanel : channels) {
                System.out.println(chanel);
            }
        }

        public static void setChanelByTvRemoteController(Television tv, int chanel) {
            tv.setChanel(channels.get(chanel-1).getChanelName());
        }

        public static void setVolume(Television tv, int volume) {tv.volume = volume;}
    }
}
