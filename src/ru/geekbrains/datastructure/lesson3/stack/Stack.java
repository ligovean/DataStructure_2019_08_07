package ru.geekbrains.datastructure.lesson3.stack;

import ru.geekbrains.datastructure.lesson3.ICollection;

public interface Stack<E> extends ICollection {

    boolean push(E value);

    E pop();

    E peek();

}
