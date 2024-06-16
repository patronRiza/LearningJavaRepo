package ru.innopolis.java.basic_1.homework1.second_exercise;

import java.util.Random;

public class SecondMain {
    public static void main(String[] args) {
        Random r = new Random();
        String firstPlayer = "Вася";
        String secondPlayer = "Петя";
        String[] shapes = new String[]{"Камень", "Ножницы", "Бумага"};

        String firstPlayersShape = shapes[r.nextInt(3)];
        String secondPlayersShape = shapes[r.nextInt(3)];

        System.out.println("У Васи выпало: " + firstPlayersShape);
        System.out.println("У Пети выпало: " + secondPlayersShape);

        switch (firstPlayersShape) {
            case "Камень":
                if (secondPlayersShape.equals("Ножницы"))
                    System.out.println("Победил " + firstPlayer + "!");
                else if (secondPlayersShape.equals("Бумага"))
                    System.out.println("Победил " + secondPlayer + "!");
                else
                    System.out.println("Ничья!");
                break;
            case "Ножницы":
                if (secondPlayersShape.equals("Камень"))
                    System.out.println("Победил " + secondPlayer + "!");
                else if (secondPlayersShape.equals("Бумага"))
                    System.out.println("Победил " + firstPlayer + "!");
                else
                    System.out.println("Ничья!");
                break;
            case "Бумага":
                if (secondPlayersShape.equals("Камень"))
                    System.out.println("Победил " + firstPlayer + "!");
                else if (secondPlayersShape.equals("Ножницы"))
                    System.out.println("Победил " + secondPlayer + "!");
                else
                    System.out.println("Ничья!");
                break;
        }
    }
}
