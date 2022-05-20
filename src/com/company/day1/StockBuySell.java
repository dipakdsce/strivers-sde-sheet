package com.company.day1;

import java.util.ArrayList;

public class StockBuySell {
    public static void main(String[] args) {
        int[] prices = {4,2,2,2,4};
        System.out.println(getMaxProfit(prices));
    }

    public static int getMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit =0;
        for(int i=0; i<prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

   /* private static ArrayList<ArrayList<Integer>> stockBuySell(int A[], int n) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int mxProfit = 0;
        int minPrice = A[0];
        int minPriceIndex = 0;
        int i;
        for( i=1; i<n; i++) {
            if(mxProfit < (A[i] - minPrice)) {
                mxProfit = A[i] - minPrice;
            } else {
                if(mxProfit > 0) {
                    ArrayList<Integer> resultSet = new ArrayList<>();
                    resultSet.add(minPriceIndex);
                    resultSet.add(i-1);
                    result.add(resultSet);
                }
                mxProfit = 0;
                minPrice = A[i];
                minPriceIndex = i;
            }
        }
        if(mxProfit > 0) {
            ArrayList<Integer> resultSet = new ArrayList<>();
            resultSet.add(minPriceIndex);
            resultSet.add(i-1);
            result.add(resultSet);
        }
        return result;
    }*/
}

