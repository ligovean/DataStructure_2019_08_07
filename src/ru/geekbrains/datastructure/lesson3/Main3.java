package ru.geekbrains.datastructure.lesson3;

import ru.geekbrains.datastructure.lesson3.queue.PriorityQueue;
import ru.geekbrains.datastructure.lesson3.queue.Queue;
import ru.geekbrains.datastructure.lesson3.queue.QueueImpl;
import ru.geekbrains.datastructure.lesson3.stack.Stack;
import ru.geekbrains.datastructure.lesson3.stack.StackImpl;

public class Main3 {

    public static void main(String[] args) {
//        testStack();
        testQueue();
    }

    private static void testQueue() {
        //        Queue<Integer> queue = new QueueImpl<>(5);
        Queue<Integer> queue = new PriorityQueue<>(5);
        queue.insert(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(6);
        queue.insert(5);
        queue.insert(4);

        System.out.println("Top of queue is " + queue.peek());
        System.out.println("queue size is " + queue.size());

        while ( !queue.isEmpty() ) {
            System.out.println(queue.remove());
        }
    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println("Top of stack is " + stack.peek());
        System.out.println("stack size is " + stack.size());

        while ( !stack.isEmpty() ) {
            System.out.println(stack.pop());
        }
    }
}
