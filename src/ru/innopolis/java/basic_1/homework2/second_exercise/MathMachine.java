package ru.innopolis.java.basic_1.homework2.second_exercise;

import java.text.DecimalFormat;

public class MathMachine {

    int max, min, sum, sub, multi, dis;
    String avg;

    public MathMachine(int a, int b) {
        comparison(a, b);
        summa(a,b);
        subtraction(a,b);
        multiplication(a,b);
        average(a,b);
    }

    public void comparison(int a, int b) {
        if (a > b) {
            this.max = a;
            this.min = b;
        }
        else {
            this.max = b;
            this.min = a;
        }
    }

    public void summa(int a, int b) {
        this.sum = a + b;
    }

    public void subtraction(int a, int b) {
        this.sub = a - b;
        this.dis = this.sub;
    }

    public void multiplication(int a, int b) {
        this.multi = a * b;
    }

    public void average(int a, int b) {
        this.avg = new DecimalFormat("#0.00").format((a + b) /2);
    }
}
