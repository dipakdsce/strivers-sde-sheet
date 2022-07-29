package com.company.day9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CombinationSum1 {
    public static void main(String[] args) {
//        int[] arr = {2, 3, 6, 7};
        int[] arr = {8, 1, 8, 6, 8};
        int target = 12;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        getCombination(arr, target, 0, res, new ArrayList<>(), new HashSet<String>());
        System.out.println(res);
    }

    private static void getCombination(int[] arr, int target, int index, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> subset, HashSet<String> unique) {
        if(index == arr.length) {
            if(target == 0) {
                if(!unique.contains(subset.toString())) {
                    res.add(new ArrayList<>(subset));
                    unique.add(subset.toString());
                }
            }
            return;
        }

        if(arr[index] <= target) {
            subset.add(arr[index]);
            getCombination(arr, target - arr[index], index, res, subset, unique);
            subset.remove(subset.size() - 1);
        }
        getCombination(arr, target, index + 1, res, subset, unique);
    }
}
