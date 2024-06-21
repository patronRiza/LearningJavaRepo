package ru.innopolis.java.basic_1.homework4.exercise3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите последовательность символов через пробел:");
        String word = sc.nextLine();
        String[] wordArray = word.toLowerCase().split(" ");
        Arrays.sort(wordArray);
        System.out.println(Arrays.toString(wordArray));
    }
}
