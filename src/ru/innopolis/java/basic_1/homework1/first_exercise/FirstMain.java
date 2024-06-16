package ru.innopolis.java.basic_1.homework1.first_exercise;

import java.util.Random;

public class FirstMain {
    public static void main(String[] args) {
        Random random = new Random();
        int i = 0;
        System.out.print("Четыре рандомных числа от 1 до 99: ");
        while (i < 4) {
            int randomNum = random.nextInt(100);
            if (i < 3) {
                System.out.print(randomNum + " ");
                i++;
            }
            else {
                System.out.print(randomNum + ".");
                i++;
            }
        }
    }
}
