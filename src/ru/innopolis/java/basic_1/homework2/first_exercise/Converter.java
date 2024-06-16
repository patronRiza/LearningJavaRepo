package ru.innopolis.java.basic_1.homework2.first_exercise;

public class Converter {

    double fahrenheit;
    double celsius;

    public Converter(double x) {

        this.fahrenheit = x;
        convert(x);
    }

    public void convert(double fahrenheit) {

        this.celsius = (fahrenheit - 32) * 5 / 9;
    }
}
