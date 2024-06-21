package ru.innopolis.java.basic_1.homework2.second_exercise;

import java.util.Scanner;

public class SecondMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите 1-е целое число: ");
        int first_num = scanner.nextInt();
        System.out.print("Введите второе целое число: ");
        int second_num = scanner.nextInt();

        MathMachine mathMachine = new MathMachine(first_num, second_num);

        System.out.println("\n" + "Сумма двух целых чисел: " + mathMachine.sum + "\n" +
                "Разница двух целых чисел " + mathMachine.sub + "\n" +
                "Произведение из двух целых чисел: " + mathMachine.multi + "\n" +
                "Среднее из двух целых чисел: " + mathMachine.avg + "\n" +
                "Расстояние двух целых чисел: " + mathMachine.sub + "\n" +
                "Максимальное целое число: " + mathMachine.max + "\n" +
                "Минимальное целое число: " + mathMachine.min + "\n");
    }
}

