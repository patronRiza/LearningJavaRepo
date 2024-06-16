package ru.innopolis.java.basic_1.homework4.exercise2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку");
        String chars = sc.nextLine();
        int countOnLeft = 0;
        int countOnRight = 0;

        if (chars.length() >= 106) {
            System.out.println("Вы ввели слишком большую строку");
        }else {
            for (int i = 0; i < chars.length() - 4; i++) {
                if (chars.charAt(i) == '>') {
                    if (chars.charAt(i + 1) == '>'
                            && chars.charAt(i + 2) == '-'
                            && chars.charAt(i + 3) == '-'
                            && chars.charAt(i + 4) == '>')
                        countOnRight++;
                }
            }
            for (int j = 0; j < chars.length() - 4; j++) {
                if (chars.charAt(j) == '<') {
                    if (chars.charAt(j + 1) == '-'
                            && chars.charAt(j + 2) == '-'
                            && chars.charAt(j + 3) == '<'
                            && chars.charAt(j + 4) == '<')
                        countOnLeft++;
                }
            }

            System.out.println("Количество стрел в введенной строке равно: " + (countOnRight + countOnLeft));
        }
    }
}
