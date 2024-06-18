package ru.innopolis.java.basic_1.homework6;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> personsList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        List<String> requests = new ArrayList<>();
        System.out.print("Введите людей: ");
        createPerson(personsList, sc.nextLine());
        System.out.print("Введите продукты: ");
        createProduct(productList, sc.nextLine());
        System.out.println("Введите имя покупателя и название покупаемого товара через запятую (Например: Анна, Торт): ");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            } else
                requests.add(input);
        }

        for (String request : requests) {
            if (buyProduct(findFromPersonList(personsList, request), findFromProductList(productList, request))) {
                if (request.split(", ")[0].equals("Анна Петровна")) {
                    System.out.println("Анна Петровна купила " + request.split(", ")[1]);
                } else {
                    System.out.println(request.split(", ")[0] + " купил " + request.split(", ")[1]);
                }
            } else {
                System.out.println(request.split(", ")[0] + " не может позволить себе " + request.split(", ")[1]);
            }
        }

        System.out.println("\n1. Информация о покупателях");
        System.out.println("------------------------");
        for (Person person : personsList) {
            System.out.println(person);
        }

        System.out.println("\n2. Информация о продуктах");
        System.out.println("----------------------");
        for (Product product : productList) {
            System.out.println(product);
        }

        System.out.println("\n3. Информация о пакетах:");
        System.out.println("---------------------");
        for (Person person : personsList) {

            if (person.getName().equals("Анна Петровна")) {
                if (person.getPackageOfProducts().isEmpty())
                    System.out.println(person.getName() + " ничего не купила");
                else
                    System.out.println(person.getName() + " купила - " + Arrays.toString(person.getPackageOfProducts()
                            .toArray())
                            .replace("[", "")
                            .replace("]", ""));
            } else {
                if (person.getPackageOfProducts().isEmpty())
                    System.out.println(person.getName() + " ничего не купил");
                else
                    System.out.println(person.getName() + " купил - " + Arrays.toString(person.getPackageOfProducts()
                            .toArray())
                            .replace("[", "")
                            .replace("]", ""));
            }
        }
    }

    private static String[] splitting(String input) {
        String hardRequest = input.replace(" = ", ",");
        return hardRequest.split("; ");
    }

    public static void createPerson(List<Person> personsList, String persons) {
        for (String res : splitting(persons)) {
            personsList.add(new Person(res.split(",")[0], Double.parseDouble(res.split(",")[1])));
        }
    }

    public static void createProduct(List<Product> productList, String products) {
        for (String res : splitting(products)) {
            productList.add(new Product(res.split(",")[0], Double.parseDouble(res.split(",")[1])));
        }
    }

    public static boolean buyProduct(Person person, Product product) {
        if ((person.getMoney() - product.getProductPrice()) > 0) {
            person.addPackageOfProducts(product);
            person.setMoney(product.getProductPrice());
            return true;
        } else
            return false;
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
}
