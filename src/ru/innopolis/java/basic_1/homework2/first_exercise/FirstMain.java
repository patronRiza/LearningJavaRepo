package ru.innopolis.java.basic_1.homework2.first_exercise;


import java.util.Scanner;

public class FirstMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите степень в градусах Фаренгейта: ");
        Converter converter = new Converter((double) scanner.nextInt());


        System.out.println(converter.fahrenheit + " градусов по Фаренгейту равна "
                + converter.celsius + " по Цельсию");

        System.out.println(Math.max(5,5));
    }
}
