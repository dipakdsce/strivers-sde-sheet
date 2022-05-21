package com.company.day2;

import java.util.*;

public class MergeOverlappingSubIntervals {
    public static void main(String[] args) {
        ArrayList<List<Integer>> intervals = new ArrayList<>();
        intervals.add(Arrays.asList(new Integer[]{1,3}));
        intervals.add(Arrays.asList(new Integer[]{2,4}));
        intervals.add(Arrays.asList(new Integer[]{2,6}));
        intervals.add(Arrays.asList(new Integer[]{8,9}));
        intervals.add(Arrays.asList(new Integer[]{8,10}));
        intervals.add(Arrays.asList(new Integer[]{9,11}));
        intervals.add(Arrays.asList(new Integer[]{15,18}));
        intervals.add(Arrays.asList(new Integer[]{16,17}));
        ArrayList<List<Integer>> res = mergeIntervals(intervals);
        for (List < Integer > it: res) {
            System.out.println(it.get(0) + " " + it.get(1));
        }
    }

    private static ArrayList<List<Integer>> mergeIntervals(ArrayList<List<Integer>> intervals) {
       Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));
       ArrayList<List<Integer>> res = new ArrayList<>();
       for(int i=0; i<intervals.size(); i++) {
           if(res.isEmpty() || res.get(res.size() - 1).get(1) < intervals.get(i).get(0)) {
               ArrayList<Integer> temp = new ArrayList<>();
               temp.add(intervals.get(i).get(0));
               temp.add(intervals.get(i).get(1));
               res.add(temp);
           } else {
               res.get(res.size() - 1).set(1, Math.max(res.get(res.size() - 1).get(1), intervals.get(i).get(1)));
           }
       }
       return res;
    }
}
