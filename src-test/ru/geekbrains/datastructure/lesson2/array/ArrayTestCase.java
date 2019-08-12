package ru.geekbrains.datastructure.lesson2.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayTestCase {

    private ArrayImpl<Integer> array;

    @BeforeEach
    public void prepare() {
        array = new ArrayImpl<>();
    }

    @Test
    public void testAdd() {
        array.add(1);
        array.add(2);
        array.add(3);
        Assertions.assertArrayEquals(
                new Integer[] {1, 2, 3},
                array.getArray());
    }

    @Test
    public void testRemove() {
        array.add(1);
        array.add(2);
        array.add(3);

        array.remove(2);

        Assertions.assertArrayEquals(
                new Integer[] {1, 3},
                array.getArray());
    }

    @Test
    public void testSearch() {
        array.add(1);
        array.add(2);
        array.add(3);

        Assertions.assertTrue(array.contains(2));
        Assertions.assertFalse(array.contains(4));

        Assertions.assertEquals(1, array.indexOf(2));
        Assertions.assertEquals(-1, array.indexOf(22));
    }
}
