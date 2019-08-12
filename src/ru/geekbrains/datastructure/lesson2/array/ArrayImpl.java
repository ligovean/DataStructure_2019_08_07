package ru.geekbrains.datastructure.lesson2.array;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ArrayImpl<E extends Object & Comparable<? super E>> implements Array<E> {

    protected E[] data;
    protected int size;

    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    //O(1)
    //O(N)
    @Override
    public void add(E value) {
        checkGrow();
        data[size++] = value;
    }

    protected void checkGrow() {
        if (size == data.length) {
            data = Arrays.copyOf(data, size * 2);
        }
    }

    //O(N) + 1
    //O(1) + O(N)
    //O(N)
    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        if (index != -1) {
            return removeByIndex(index) != null;
        }
        return false;
    }

    //O(N)
    @Override
    public E removeByIndex(int index) {
        checkIndex(index);

        E result = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[--size] = null;
        return result;
    }

    private void checkIndex(int index) {
        if (index >= 0 && index < size)
            return;

        throw new IndexOutOfBoundsException("Invalid index value: " + index + "; array size is "  + data.length);
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != -1;
    }

    //O(N)
    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, data[i])) {
                return i;
            }
        }
        return -1;
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
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(data[i]);
        }
        System.out.println("----------");
    }

    //Compare: N + (N-1) + (N-2) + ... + (N-N-1) ~= N^2
    //Swap: N^2
    //O(N^2)
    @Override
    public void sortBubble() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    //Compare: N + (N-1) + (N-2) + ... + (N-N-1) ~= N^2
    //Swap: N
    //O(N^2)
    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
    }

    //Unsorted: O(N^2)
    // Sorted: O(N)
    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) > 0) {
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }


    E[] getArray() {
        return Arrays.copyOf(data, size);
    }
}
