package com.company.day8;

import java.util.ArrayList;

public class FindMinimumNumberOfCoin {
    public static void main(String[] args) {
        /*int value = 149;
        System.out.println(getNumberOfCoin(value));*/

        int V = 11;
        ArrayList < Integer > ans = new ArrayList< >();
        int coins[] = {1, 5, 6, 9};
        int n = coins.length;
        for (int i = n - 1; i >= 0; i--) {
            while (V >= coins[i]) {
                V -= coins[i];
                ans.add(coins[i]);
            }
        }
        System.out.println("The minimum number of coins is "+ans.size());
        System.out.println("The coins are ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(" " + ans.get(i));
        }
    }

    private static int getNumberOfCoin(int value) {
        int count = 0;
        while(value != 0) {
            if(value >= 1000) {
                count++;
                value -= 1000;
            } else if (value >= 500) {
                count++;
                value -= 500;
            } else if(value >= 100) {
                count++;
                value -= 100;
            } else if (value >= 50) {
                count++;
                value -= 50;
            } else if (value >= 20) {
                count++;
                value -= 20;
            } else if (value >= 10) {
                count++;
                value -= 10;
            } else if (value >= 5) {
                count++;
                value -= 5;
            } else if (value >= 2) {
                count++;
                value -= 2;
            } else {
                count++;
                value--;
            }
        }
        return count;
    }
}
