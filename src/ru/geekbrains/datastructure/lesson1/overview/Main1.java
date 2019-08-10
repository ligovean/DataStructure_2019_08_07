package ru.geekbrains.datastructure.lesson1.overview;

public class Main1 {

    private static int fieldA;
    private static String str;

    public static void main(String[] args) {
        int a = 5;//001 = 5
        System.out.println(a);
        System.out.println(str);
//        System.out.println(str1);

        int b = 5;//002 = 5
        System.out.println("a == b:" + (a == b));//[001] == [002] <-> 5 == 5

        Person p1 = new Person(33, "Alex");
        Person p2 = new Person(33, "Alex");

        System.out.println("p1 == p2:" + (p1 == p2));
        System.out.println("p1.equals(p2):" + (p1.equals(p2)));

        System.out.println("----------");
        System.out.println(a);
        a = testPrimitive(5);
        System.out.println(a);

        System.out.println("----------");
        System.out.println(p1);//[001] -> 002
        testObject(p1);//testObject(002)
        System.out.println(p1);


    }

    private static int testPrimitive(int a) {
        System.out.println(a);
        a = 7;
        System.out.println(a);
        return a;
    }

    private static void testObject(Person p1) {//[003] = 002
        System.out.println(p1);
        p1.setName("Sergey");
        p1 = new Person(25, "Petr");//[003] = 004
        System.out.println(p1);
    }
}
