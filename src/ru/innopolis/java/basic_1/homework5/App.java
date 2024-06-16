package ru.innopolis.java.basic_1.homework5;

import java.util.Scanner;

/*
    Реализовать класс Телевизор. У класса есть поля, свойства и методы.
    Проверить работу в классе App, методе main.
    Обратить внимание на переопределение метода toString.
*/

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Инициализация телевизора Samsung");
        Television samsungTv = new Television("Samsung", 50000, "43\"");
        System.out.println("\n" + samsungTv + "\n");

        System.out.print("Переключение канала на Samsung на 26");
        TvRemoteController.setChanel(samsungTv, 26);
        System.out.println("\n" + samsungTv + "\n");

        System.out.print("Инициализация телевизора LG");
        Television lgTv = new Television("LG", "45\"");
        //Установка цены на телевизоре LG
        lgTv.setCost(74989.99);
        System.out.println("\n" + lgTv + '\n');

        System.out.print("Увеличение громкости до 56 на LG");
        TvRemoteController.setVolume(lgTv, 56);
        System.out.println("\n" + lgTv + "\n");

        System.out.print("Инициализация телевизора Xiaomi");
        Television xiaomiTv = new Television("Xiaomi", 35000, "48\"");
        System.out.println("\n" + xiaomiTv + "\n");

        System.out.print("Увеличение громкости до 120 на Xiaomi");
        TvRemoteController.setVolume(xiaomiTv, 120);
        System.out.println(xiaomiTv + "\n");

        System.out.println("Инициализация телевизора Sony");
        Television sonyTv = new Television("Sony", "50\"");
        //Установка цены на телевмзор Sony
        System.out.print("Enter how much is Sony Television: ");
        sonyTv.setCost(scanner.nextDouble());
        System.out.println(sonyTv + "\n");

        System.out.print("Включение телевизора Sony");
        TvRemoteController.turnOn(sonyTv);
        System.out.println("\n" + sonyTv + "\n");
    }
}
