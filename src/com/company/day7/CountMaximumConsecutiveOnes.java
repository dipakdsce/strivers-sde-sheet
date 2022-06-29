package com.company.day7;

public class CountMaximumConsecutiveOnes {
    public static void main(String[] args) {
//        int[] prices = {1, 1, 0, 1, 1, 1};
        int[] prices = {1, 0, 1, 1, 0, 1};
        System.out.println(findCount(prices));
    }

    private static int findCount(int[] prices) {
        int maxCount = 0;
        int count = 0;
        for(int i=0; i<prices.length; i++) {
            if(prices[i] == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        maxCount = Math.max(maxCount, count);
        return maxCount;
    }
}
