package ru.innopolis.java.basic_1.homework4.added_exercise;

import java.util.Set;
import java.util.TreeSet;

public class CheckLetter {
    public static void main(String[] args) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        String set = "qwertyuioplzxcvbnm";

        System.out.println(checkLetter(alphabet));
        System.out.println(checkLetter(set));
    }

    public static boolean checkLetter(final String letter) {
        if (letter.length() < 26) {
            return false;
        }

        Set<Character> ch = new TreeSet<>();
        for (char c : letter.toCharArray()) {
            ch.add(c);
        }
        return ch.size() == 26;
    }
}
