package ru.innopolis.java.basic_1.homework5;

public class TvRemoteController {

    private TvRemoteController(){}

    public static void setChanel(Television tv, int chanel) {
        tv.chanel = chanel;
    }

    public static void setVolume(Television tv, int volume) {
        if (0 <= volume && volume <= 100) {
            tv.volume = volume;
        } else {
            System.out.println("\nВы ввели некорректный уровень громкости!");
            tv.volume = tv.DEFAULT_VOLUME;
        }
    }

    public static void turnOn(Television tv) {
        tv.turnOn();
    }

    public static void turnOff(Television tv) {
        tv.turnOff();
    }
}
