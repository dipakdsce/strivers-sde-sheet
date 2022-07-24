package com.company.day9;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSum {
    public static void main(String[] args) {
        int n = 3;
//        int[] arr = {5, 2, 1};
        int[] arr = {3, 2, 1};
        ArrayList<Integer> res = new ArrayList<>();
        findSubsetSum(arr, n, 0, 0 , res);
        Collections.sort(res);
        System.out.println(res);
    }

    private static void findSubsetSum(int[] arr, int n, int index, int sum, ArrayList<Integer> sumSubset) {
        if(index == n) {
            sumSubset.add(sum);
            return;
        }
        findSubsetSum(arr, n, index + 1, sum + arr[index], sumSubset);
        findSubsetSum(arr, n, index + 1, sum, sumSubset);

    }
}
