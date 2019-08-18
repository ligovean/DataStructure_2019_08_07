package ru.geekbrains.datastructure.lesson3.deque;

import ru.geekbrains.datastructure.lesson3.queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }


    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (head == 0)
            head = data.length;

        data[--head] = value;
        size++;

        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if (isFull())
            return false;

        if (tail == data.length - 1) {
            tail = DEFAULT_TAIL;
        }
        data[++tail] = value;
        size++;
        return true;
    }

    @Override
    public E removeRight() {
        if (isEmpty()) {
            return  null;
        }
        if (tail < 0)
            tail = data.length - 1;

        size--;
        return data[tail--];
    }

}