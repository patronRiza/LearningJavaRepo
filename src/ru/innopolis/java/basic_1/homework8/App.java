package ru.innopolis.java.basic_1.homework8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Path pathInput = Paths.get("src/ru/innopolis/java/basic_1/homework8/InputFile.txt");
        List<Person> personsList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(pathInput);
            for (int i = 0; i < lines.size(); i++) {
                if (i == 0)
                    createPerson(personsList, lines.get(i));
                if (i == 1)
                    createProduct(productList, lines.get(i));
                if (i > 1) {
                    if (lines.get(i).equals("END")) {
                        break;
                    } else {
                        buyProduct(findFromPersonList(personsList, lines.get(i)), findFromProductList(productList, lines.get(i)), lines.get(i));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Такого файла нет(");
        }

        System.out.println("\n1. Информация о покупателях");
        System.out.println("------------------------");
        for (Person person : personsList) {
            System.out.println(person);
        }

        System.out.println("\n2. Информация о продуктах");
        System.out.println("----------------------");
        for (Product product : productList) {
            System.out.println(product.toAllString());
        }

        System.out.println("\n3. Информация о пакетах:");
        System.out.println("---------------------");
        writeOut("\n");
        for (Person person : personsList) {
            if (person.getPackageOfProducts().isEmpty()) {
                System.out.println(person.getName() + " - ничего не куплено");
                writeOut(person.getName() + " - ничего не куплено");
            } else {
                System.out.println(person.getName() + " - " + Arrays.toString(person.getPackageOfProducts()
                                .toArray())
                        .replace("[", "")
                        .replace("]", ""));
                writeOut(person.getName() + " - " + Arrays.toString(person.getPackageOfProducts()
                                .toArray())
                        .replace("[", "")
                        .replace("]", ""));
            }
        }
    }

    public static void createPerson(List<Person> personsList, String persons) {
        for (String res : persons.split("; ")) {
            personsList.add(new Person(res.split(" = ")[0], Double.parseDouble(res.split(" = ")[1])));
        }
    }

    public static void createProduct(List<Product> productList, String products) {
        for (String res : products.split("; ")) {
            productList.add(new Product(res.split(" = ")[0], Double.parseDouble(res.split(" = ")[1])));
        }
    }

    public static void buyProduct(Person person, Product product, String input) {
        if ((person.getMoney() - product.getProductPrice()) >= 0) {
            person.addPackageOfProducts(product);
            person.setMoney(product.getProductPrice());
            System.out.println(input.split(", ")[0] + " купил/купила " + input.split(", ")[1]);
            writeOut(input.split(", ")[0] + " купил/купила " + input.split(", ")[1]);
        } else {
            System.out.println(input.split(", ")[0] + " не может позволить себе " + input.split(", ")[1]);
            writeOut(input.split(", ")[0] + " не может позволить себе " + input.split(", ")[1]);
        }
    }

    private static Person findFromPersonList(List<Person> personList, String request) {
        Person person = null;
        for (Person value : personList) {
            if (value.getName().equals(request.split(", ")[0]))
                person = value;
        }
        return person;
    }

    private static Product findFromProductList(List<Product> productList, String request) {
        Product product = null;
        for (Product value : productList) {
            if (value.getProductName().equals(request.split(", ")[1]))
                product = value;
        }
        return product;
    }

    public static void writeOut(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/ru/innopolis/java/basic_1/homework8/OutputFile.txt", true))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}