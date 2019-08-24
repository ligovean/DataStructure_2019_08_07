package ru.geekbrains.datastructure.lesson5.homework;

import ru.geekbrains.datastructure.lesson5.Item;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Рюкзак
        List<Item> list = new ArrayList<>();
        list.add(new Item("Книга",   1, 600));
        list.add(new Item("Бинокль", 2, 5000));
        list.add(new Item("Аптечка", 4, 1500));
        list.add(new Item("Ноутбук", 2, 40000));
        list.add(new Item("Котелок", 1, 500));


        Backpack backpack = new Backpack(5);
        backpack.calcBestSet(list);

        list = backpack.getBestSet();


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name + " " + list.get(i).price);
        }

        System.out.println("Total best price is " + backpack.getBestPrice());
        System.out.println("Count:" + backpack.count);
    }

}