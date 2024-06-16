package ru.innopolis.java.basic_1.homework2.third_exercise;

import java.util.Scanner;

public class ThirdMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Исходная строка: ");
        String text = scanner.nextLine();
        System.out.print("Сколько раз вывести строку? ");
        int num = scanner.nextInt();
        int iterator = 0;

        System.out.print("После повторения " + num + " раз: ");
        while (iterator < num) {
            System.out.print(text);
            iterator += 1;
        }
    }
}
