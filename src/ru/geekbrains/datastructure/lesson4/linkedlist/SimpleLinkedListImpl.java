package ru.geekbrains.datastructure.lesson4.linkedlist;

import ru.geekbrains.datastructure.lesson4.iterator.ListIterator;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E> {

    protected Node<E> firstElement;//001[007]
    protected int size;


    //O(1)
    @Override
    public void insertFirst(E value) {
        Node<E> node = new Node<>(value);//005
        node.next = firstElement;//003[007]
        firstElement = node;//001[005]
        size++;
    }

    //O(1)
    @Override
    public E removeFirst() {
        if (isEmpty())
            return null;

        E value = firstElement.value;
        firstElement = firstElement.next;

        size--;
        return value;
    }

    //O(N)
    @Override
    public boolean remove(E value) {
        Node<E> previous = null;
        Node<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }

            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }
        else if (current == firstElement) {
            firstElement = current.next;
        }
        else {
            previous.next = current.next;
        }

        size--;

        return true;
    }

    //O(N)
    @Override
    public boolean contains(E value) {
        Node<E> current = firstElement;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println("----------");
        Node<E> current = firstElement;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("----------");
    }

    @Override
    public E getFirstValue() {
        return firstElement != null ? firstElement.value : null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstElement == null;
    }

    @Override
    public boolean isFull() {
        return LinkedList.super.isFull();
    }

    @Override
    public Node<E> getFirst() {
        return firstElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(this);
    }

    @SuppressWarnings("unchecked")
    private static class LinkedListIterator<E> implements ListIterator<E> {

        private SimpleLinkedListImpl list;

        private Node<E> current;
        private Node<E> previous;

        public LinkedListIterator(SimpleLinkedListImpl list) {
            this.list = list;
            reset();
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E nextValue = current.value;
            previous = current;
            current = current.next;
            return nextValue;
        }

        @Override
        public void remove() {
            if (previous == null){
                list.firstElement = current.next;
                reset();
            } else {
                previous.next = current.next;
                if ( !hasNext() ) {
                    reset();
                } else {
                    current = current.next;
                }
            }
        }

        @Override
        public void reset() {
            current = list.firstElement;
            previous = null;
        }

        @Override
        public void insertBefore(E value) {
            Node newItem = new Node(value);
            if(previous == null) {
                newItem.next = list.firstElement;
                list.firstElement = newItem;
                reset();
            }
            else {
                newItem.next = previous.next;
                previous.next = newItem;
                current = newItem;
            }

        }

        @Override
        public void insertAfter(E value) {
            Node newItem = new Node(value);
            if (list.isEmpty()){
                list.firstElement = newItem;
                current = newItem;
            } else {
                newItem.next = current.next;
                current.next = newItem;
                next();
            }
        }

    }
}
