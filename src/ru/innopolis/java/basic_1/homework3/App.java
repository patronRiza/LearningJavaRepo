package ru.innopolis.java.basic_1.homework3;

import java.util.Scanner;

/*
    Реализовать класс Телевизор. У класса есть поля, свойства и методы.
    Проверить работу в классе MainApp, методе main.
    Обратить внимание на переопределение метода toString.
*/

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TV samsungTv = new TV("Samsung", 50000, "43\"");
        System.out.println("\n" + samsungTv + "\n");

        TV lgTv = new TV("LG", "45\"");
        lgTv.setCost(74989.99);
        System.out.println(lgTv.getCost() + " - is LG's cost\n");

        TV sonyTv = new TV("Sony", "50\"");
        System.out.print("Enter how much is Sony Television: ");
        sonyTv.setCost(scanner.nextDouble());
        System.out.println(sonyTv);
    }
}
