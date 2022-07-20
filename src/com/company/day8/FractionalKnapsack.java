package com.company.day8;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value;
    int weight;
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class ItemComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        double r1 = (double) (o1.value) / (double) (o1.weight);
        double r2 = (double) (o2.value) / (double) (o2.weight);

        if(r1 < r2) {
            return 1;
        } else if(r1 > r2) {
            return -1;
        } else {
            return 0;
        }
    }
}
public class FractionalKnapsack {
    public static void main(String[] args) {
        int n = 3;
        int w = 50;

        int[] values = {100, 60, 120};
        int[] weight = {20, 10, 30};
        System.out.println(maxProfit(values, weight, n, w));
    }

    private static double maxProfit(int[] values, int[] weight, int n, int w) {
        Item[] items = new Item[n];
        for(int i=0; i<n; i++) {
            items[i] = new Item(values[i], weight[i]);
        }

        Arrays.sort(items, new ItemComparator());

        double maxProfit = 0.0;
        int curWeight = 0;

        for(int i=0; i<n; i++) {
            if(curWeight + items[i].weight <= w) {
                curWeight += items[i].weight;
                maxProfit += items[i].value;
            } else {
                int weightTaken = w - curWeight;
                maxProfit += (double) (items[i].value/(double)items[i].weight) * weightTaken;
                break;
            }
        }
        return maxProfit;
    }
}
