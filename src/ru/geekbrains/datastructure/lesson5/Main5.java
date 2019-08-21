package ru.geekbrains.datastructure.lesson5;

public class Main5 {

    public static void main(String[] args) {
//        countdownLoop(5);
        countdownRec(5);
    }

    private static void countdownRec(int n) {
//        if (n <= 0) {
//            return;
//        }

        System.out.println(n);
        countdownRec(--n);
    }

    private static void countdownLoop(int n) {
        while (n > 0) {
            System.out.println(n);
            --n;
        }
    }
}
