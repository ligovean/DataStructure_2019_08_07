package ru.geekbrains.datastructure.lesson2.array;

import ru.geekbrains.datastructure.ICollection;

public interface Array<E> extends ICollection {

    int DEFAULT_CAPACITY = 16;

    void add(E value);

    boolean remove(E value);
    E removeByIndex(int index);

    boolean contains(E value);
    int indexOf(E value);

    void display();

    default void addAll(E... values) {
        for (E value : values) {
            add(value);
        }
    }

    void sortBubble();

    void sortSelect();

    void sortInsert();

}
