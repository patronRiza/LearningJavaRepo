package ru.innopolis.java.basic_1.homework4.exercise1;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите букву: ");
        CheckerWords cw = new CheckerWords();
        System.out.println("Буква стоящая слева от " + cw.getLetter() + " --> " + cw.checkWords());
    }
}
