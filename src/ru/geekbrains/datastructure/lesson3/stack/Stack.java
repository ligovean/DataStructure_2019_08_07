package ru.geekbrains.datastructure.lesson3.stack;

import ru.geekbrains.datastructure.ICollection;

public interface Stack<E> extends ICollection {

    void push(E value);

    E pop();

    E peek();

}
