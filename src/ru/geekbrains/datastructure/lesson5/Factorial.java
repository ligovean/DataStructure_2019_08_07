package ru.geekbrains.datastructure.lesson5;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    //n!
    private static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
