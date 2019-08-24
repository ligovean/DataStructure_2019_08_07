package ru.geekbrains.datastructure.lesson5.homework;


import ru.geekbrains.datastructure.lesson5.Item;

import java.util.ArrayList;
import java.util.List;

public class Backpack {

    private final int maxWeight;

    private int bestPrice;
    private List<Item> bestItems = null;

    public int count;


    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    private  int calcWeight(List<Item> items) {
        int sumWeight = 0;
        for (Item item : items) {
            sumWeight += item.weight;
        }
        return sumWeight;
    }

    private int calcPrice(List<Item> items) {
        int sumPrice = 0;
        for (Item item : items) {
            sumPrice += item.price;
        }
        return sumPrice;
    }

    private void bestSet(List<Item> items) {
        if (calcWeight(items) <= maxWeight && calcPrice(items) > bestPrice) {
            bestItems = items;
            bestPrice = calcPrice(items);
        }
    }

    public void calcBestSet(List<Item> items) {
        count++;
        if (items.size() > 0) {
            bestSet(items);
        }

        for (int i = 0; i < items.size(); i++) {
            List<Item> list = new ArrayList<>(items);
            list.remove(i);
            calcBestSet(list);
        }
    }

    public List<Item> getBestSet() {
        return bestItems;
    }

    public int getBestPrice() {
        return bestPrice;
    }
}