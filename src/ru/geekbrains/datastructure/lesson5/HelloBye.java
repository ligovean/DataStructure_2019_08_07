package ru.geekbrains.datastructure.lesson5;

public class HelloBye {

    public static void main(String[] args) {
        hello("VP");
    }

    private static void hello(String name) {
        print("Hello, " + name + "!");
        bye(name);
    }

    private static void bye(String name) {
        print("Good bye, " + name + "!");
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
