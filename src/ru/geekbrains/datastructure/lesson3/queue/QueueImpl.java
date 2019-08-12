package ru.geekbrains.datastructure.lesson3.queue;

public class QueueImpl<E> implements Queue<E> {

    private static final int DEFAULT_TAIL = -1;
    private static final int DEFAULT_HEAD = 0;

    protected final E[] data;
    protected int size;

    private int head;
    private int tail;

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

        if (tail == lastIndex()) {
            tail = DEFAULT_TAIL;
        }

        data[++tail] = value;
        size++;
        return true;
    }

    //O(1)
    @Override
    public E remove() {
        if (isEmpty())
            return null;

        if (head == data.length) {
            head = DEFAULT_HEAD;
        }

        E value = data[head++];
        size--;
        return value;
    }

    @Override
    public E peek() {
        return isEmpty() ? null : data[head];
    }

    private int lastIndex() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == data.length;
    }
}
