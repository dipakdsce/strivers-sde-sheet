package com.company.day9;

import java.util.ArrayList;
import java.util.HashSet;

public class Subset2 {
    public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 2};
        ArrayList<Integer> ds = new ArrayList<>();
        HashSet<String> result = new HashSet<>();
        findAllUniqueSubset(arr, n, 0, ds, result);
        System.out.println(result);
    }

    private static void findAllUniqueSubset(int[] arr, int n, int index, ArrayList<Integer> ds, HashSet<String> result) {
        if(index == n) {
            result.add(ds.toString());
            return;
        }
        ds.add(arr[index]);
        findAllUniqueSubset(arr, n, index + 1, ds, result);
        ds.remove(ds.size() - 1);
        findAllUniqueSubset(arr, n, index + 1, ds, result);
    }


}
