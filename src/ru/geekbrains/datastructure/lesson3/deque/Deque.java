package ru.geekbrains.datastructure.lesson3.deque;

import ru.geekbrains.datastructure.lesson3.queue.Queue;

public interface Deque<E> extends Queue<E> {

    boolean insertLeft(E value);
    boolean insertRight(E value);

    E removeLeft();
    E removeRight();
}