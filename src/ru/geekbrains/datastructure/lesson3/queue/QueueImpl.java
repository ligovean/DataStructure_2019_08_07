package ru.geekbrains.datastructure.lesson3.queue;

public class QueueImpl<E> implements Queue<E> {

    public static final int DEFAULT_TAIL = -1;
    public static final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;

    protected int tail;
    protected int head;

    @SuppressWarnings("unchecked")
    public QueueImpl(int maxCapacity) {
        this.data = (E[]) new Object[maxCapacity];
        this.head = DEFAULT_HEAD;
        this.tail = DEFAULT_TAIL;
    }

    //O(1)
    @Override
    public boolean insert(E value) {
        if (isFull())
            return false;

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    //O(1)
    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E peek() {
        return data[head];
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
