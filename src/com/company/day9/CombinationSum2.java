package com.company.day9;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getCombination(candidates, target, 0, res, new ArrayList<>());
        System.out.println(res);
    }

    private static void getCombination(int[] candidates, int target, int index,
                                       ArrayList<ArrayList<Integer>> res,
                                       ArrayList<Integer> subset) {

        if(target == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }

        for(int i=index; i<candidates.length; i++) {
            if(i > index && candidates[i-1] == candidates[i])
                continue;
            if(candidates[i] > target)
                break;
            subset.add(candidates[i]);
            getCombination(candidates, target - candidates[i], i + 1, res, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
