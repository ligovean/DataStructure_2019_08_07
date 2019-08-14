package ru.geekbrains.datastructure.lesson3.queue;

import ru.geekbrains.datastructure.lesson3.ICollection;

public interface Queue<E> extends ICollection {

    boolean insert(E value);

    E remove();

    E peek();

}
