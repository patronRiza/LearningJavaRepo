package ru.innopolis.java.basic_1.homework2.fourth_exercise;

import java.util.Scanner;

public class FourthMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число строк и столбцов сетки: ");
        int num = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Введите повторяемый элемент сетки: ");
        String element = scanner.nextLine();


        System.out.println("Сетка по запросу " + num + " на " + num);

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(element);
            }
            System.out.print("\n");
        }
    }
}
