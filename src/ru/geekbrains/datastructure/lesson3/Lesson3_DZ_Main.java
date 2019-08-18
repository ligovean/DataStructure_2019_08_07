package ru.geekbrains.datastructure.lesson3;

import ru.geekbrains.datastructure.lesson3.deque.Deque;
import ru.geekbrains.datastructure.lesson3.deque.DequeImpl;
import ru.geekbrains.datastructure.lesson3.stack.Stack;
import ru.geekbrains.datastructure.lesson3.stack.StackImpl;

public class Lesson3_DZ_Main {
    public static void main(String[] args) {
        // TASK 1
//        String str = "abcd";
//
//        System.out.println(new StringBuilder(str).reverse());
//
//        Stack<Character> st = new StackImpl<>(str.length());
//        for (int i = 0; i < str.length(); i++) {
//            st.push(str.charAt(i));
//        }
//
//        while ( !st.isEmpty() ) {
//            System.out.print(st.pop());
//        }
//        System.out.println();
//
//        if (true) {
//            return;
//        }


        //TASK 2
        Deque<Integer> deq = new DequeImpl<>(6);

        deq.insertRight(1);
        deq.insertRight(2);
        deq.insertRight(3);
        // 1 2 3 4
        deq.insertRight(4);
        // 5 1 2 3 4
        deq.insertLeft(5);
        // 6 5 1 2 3 4
        deq.insertLeft(6);

        //5 1 2 3 4
        deq.removeLeft();
        // 5 1 2 3
        deq.removeRight();

//        displayLeftToRight(deq); // Queue
//        displayRightToLeft(deq); //Stack
    }


    private static <E> void displayRightToLeft(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeRight());
        }
    }

    private static <E> void displayLeftToRight(Deque<E> deq) {
        while (!deq.isEmpty()) {
            System.out.println(deq.removeLeft());
        }
    }
}