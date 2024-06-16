package ru.innopolis.java.basic_1.homework4.added_exercise;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word to reverse: ");
        boolean rev = reverse(sc.nextLine());
        System.out.printf(String.valueOf(rev));
    }
    private static boolean reverse(String str) {
        StringBuilder newWord = new StringBuilder(str);
        newWord.reverse();
        return newWord.toString().equals(str);
    }
}
