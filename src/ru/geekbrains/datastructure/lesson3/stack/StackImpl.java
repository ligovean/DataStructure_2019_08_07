package ru.geekbrains.datastructure.lesson3.stack;

public class StackImpl<E> implements Stack<E> {

    private final E[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public StackImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
    }

    //O(1)
    @Override
    public boolean push(E value) {
        if (isFull())
            return false;

        data[size++] = value;
        return true;
    }

    //O(1)
    @Override
    public E pop() {
        return isEmpty() ? null : data[--size];
    }

    //O(1)
    @Override
    public E peek() {
        return isEmpty() ? null : data[size - 1];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
