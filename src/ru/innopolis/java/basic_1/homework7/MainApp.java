package ru.innopolis.java.basic_1.homework7;

import ru.innopolis.java.basic_1.homework7.persons.Adult;
import ru.innopolis.java.basic_1.homework7.persons.Child;
import ru.innopolis.java.basic_1.homework7.persons.Person;
import ru.innopolis.java.basic_1.homework7.persons.Retiree;
import ru.innopolis.java.basic_1.homework7.prooducts.DiscountProduct;
import ru.innopolis.java.basic_1.homework7.prooducts.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> personsList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        System.out.println("Введите людей: ");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                createPerson(personsList, input);
            }
        }

        System.out.println("Введите продукты: ");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                createProduct(productList, input);
            }
        }

        System.out.println("Введите имя покупателя и название покупаемого товара через запятую (Например: Анна, Торт): ");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("END")) {
                break;
            } else {
                if (buyProduct(findFromPersonList(personsList, input), findFromProductList(productList, input))) {
                    if (input.split(", ")[0].equals("Анна Петровна")) {
                        System.out.println("Анна Петровна купила " + input.split(", ")[1]);
                    } else {
                        System.out.println(input.split(", ")[0] + " купил " + input.split(", ")[1]);
                    }
                } else {
                    System.out.println(input.split(", ")[0] + " не может позволить себе " + input.split(", ")[1]);
                }
            }
        }



        System.out.println("\n1. Информация о покупателях");
        System.out.println("------------------------");
        for (Person person : personsList) {
            System.out.println(person);
        }

        System.out.println("\n2. Информация о продуктах");
        System.out.println("----------------------");
        System.out.print("Обычные продукты: ");
        for (Product product : productList) {
            if (!product.isStatus())
                System.out.print(product.getProductName() + "; ");
        }
        System.out.println("\n----------------------");
        System.out.print("Акционные продукты: ");
        for (Product product : productList) {
            if (product.isStatus())
                System.out.print(product.getProductName() + "; ");
        }

        System.out.println("\n\n3. Информация о пакетах:");
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

    public static void createPerson(List<Person> personsList, String persons) {
        String str = persons.replace(" = ", ", ").replace(", ", ",");
        while (true) {
            if (Double.parseDouble(str.split(",")[1]) < 0) {
                System.out.println("Деньги не могут быть отрицательным числом");
                break;
            }
            else {
                int age = Integer.parseInt(str.split(",")[2]);
                if ((0 <= age) && (age < 17)) {
                    personsList.add(new Child(str.split(",")[0],
                            Double.parseDouble(str.split(",")[1]),
                            Integer.parseInt(str.split(",")[2])));
                    break;
                } else if ((17 <= age) && (age < 65)) {
                    personsList.add(new Adult(str.split(",")[0],
                            Double.parseDouble(str.split(",")[1]),
                            Integer.parseInt(str.split(",")[2])));
                    break;
                } else {
                    personsList.add(new Retiree(str.split(",")[0],
                            Double.parseDouble(str.split(",")[1]),
                            Integer.parseInt(str.split(",")[2])));
                    break;
                }
            }
        }
    }

    public static void createProduct(List<Product> productList, String products) {
        String str = products.replace(" = ", ", ").replace(", ", ",");
        if (str.endsWith("%")) {
            str = str.substring(0, str.length() - 1);
            while (true) {
                if (checkNaming(str.split(",")[0])) {
                    System.out.println("Недопустимое имя продукта!");
                    break;
                }
                if (Double.parseDouble(str.split(",")[1]) <= 0) {
                    System.out.println("Недопустимая стоимость продукта!");
                    break;
                }
                else {
                    productList.add(new DiscountProduct(str.split(",")[0], Double.parseDouble(str.split(",")[1]), Double.parseDouble(str.split(",")[2])));
                    break;
                }
            }
        }
        else {
            while (true) {
                if (checkNaming(str.split(",")[0])) {
                    System.out.println("Недопустимое имя продукта!");
                    break;
                }
                if (Double.parseDouble(str.split(",")[1]) <= 0) {
                    System.out.println("Недопустимая стоимость продукта!");
                    break;
                }
                else {
                    productList.add(new Product(str.split(",")[0], Double.parseDouble(str.split(",")[1])));
                    break;
                }
            }
        }
    }

    public static boolean buyProduct(Person person, Product product) {
        if (person.getAge() < 6) {
            System.out.println("Дети до 6 не могут покупать товары(");
            return false;
        }
        double final_cost = (product.getTotalPrice() * (1 - (person.getDiscountLevel() * 0.01)));
        if ((person.getMoney() - final_cost) >= 0) {
            person.addPackageOfProducts(product);
            person.setMoney(final_cost);
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

    private static boolean checkNaming(String string) {
        if (string.length() < 3)
            return true;
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
