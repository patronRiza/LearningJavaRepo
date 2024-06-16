package ru.innopolis.java.basic_1.homework4.exercise1;

import java.util.Scanner;

public class CheckerWords {
    Scanner sc = new Scanner(System.in);
    private final String alphabet = "qwertyuiopasdfghjklzxcvbnm";
    private final char letter = sc.next().charAt(0);
    char[] alphabetArray = alphabet.toCharArray();
    public char checkWords() {
        int index = alphabet.indexOf(letter);
        if (index == 0) {
            return alphabetArray[alphabetArray.length - 1];
        } else {
            return alphabetArray[index - 1];
        }
    }
    public char getLetter() {
        return letter;
    }
}
