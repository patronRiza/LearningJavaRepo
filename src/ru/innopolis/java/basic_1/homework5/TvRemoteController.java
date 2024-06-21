package ru.innopolis.java.basic_1.homework5;

public class TvRemoteController {

    private TvRemoteController() {
    }

    public static void setChanel(Television tv, int chanel) {
        tv.chanel = chanel;
    }

    public static void setVolume(Television tv, int volume) {tv.volume = volume;}

    public static void turnOn(Television tv) {
        tv.turnOn();
    }

    public static void turnOff(Television tv) {
        tv.turnOff();
    }
}
