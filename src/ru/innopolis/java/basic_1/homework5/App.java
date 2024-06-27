package ru.innopolis.java.basic_1.homework5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
    Реализовать класс Телевизор. У класса есть поля, свойства и методы.
    Проверить работу в классе MainApp, методе main.
    Обратить внимание на переопределение метода toString.
*/

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Television> tvList = new ArrayList<>();
        int iterator = 1;

        while (true) {
            if (iterator > 2) {
                System.out.println("Продолжаем добавлять телевизоры?\n1.Да\n2.Нет");
                System.out.println();
                if (!scanner.nextLine().equals("1")) {
                    break;
                }
            }
            System.out.println("Введите производителя телевизора");
            String manufacturer = scanner.nextLine();

            System.out.println("Введите диагональ телевизора");
            String diagonal = scanner.nextLine();

            System.out.println("Введите цену телевизора");
            double cost = Double.parseDouble(scanner.nextLine());

            Television tv = new Television(manufacturer, cost, diagonal);
            tvList.add(tv);

            iterator++;
            System.out.println("Телевизор добавлен!\n");
        }

        for (Television tv : tvList) {
            System.out.println(tv);
        }

        System.out.println("Хотите включить телевизоры?\n1.Да\n2.Нет");
        if (scanner.nextLine().equals("1")) {
            for (Television tv : tvList) {
                TvRemoteController.turnOn(tv);
                System.out.println(tv);
            }
        }

        System.out.println("Хотите прибавить звук?\n1.Да\n2.Нет");
        if (scanner.nextLine().equals("1")) {
            for (int i = 0; i < tvList.size(); i++) {
                System.out.println((i + 1) + ". " + tvList.get(i).getManufacturer());
            }
            System.out.print("Выберите телевизор: ");
            int tvNum = Integer.parseInt(scanner.nextLine());
            System.out.println("На сколько прибавить звук? (Рекомендованная громкость 50-70)");
            int volume = Integer.parseInt(scanner.nextLine());
            if (0 > volume || volume > 100) {
                System.out.println("\nВы ввели некорректный уровень громкости! Давайте еще раз");
                volume = Integer.parseInt(scanner.nextLine());
            }
            if ((volume >= 0 && volume < 50) || (volume > 70 && volume <= 100)) {
                System.out.println("Это не рекомендованная громкость... Давайте еще раз!");
                volume = Integer.parseInt(scanner.nextLine());
                if (volume >= 50 && volume <= 70) {
                    System.out.println("То что нужно!\n");
                } else {
                    System.out.println("Ваш слух на вашей совести!\n");
                }
            }
            TvRemoteController.setVolume(tvList.get(tvNum - 1), volume);
        }
        for (Television tv : tvList) {
            System.out.println(tv);
        }
    }
}
