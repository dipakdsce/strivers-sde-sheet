package com.company.day4;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 7, 6};
        System.out.println(findLongestConsecutiveSequence(arr, arr.length));
    }

    public static int findLongestConsecutiveSequence(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(arr[i]);
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!set.contains(arr[i] - 1)) {
                int tempCount = 1;
                int num = arr[i] + 1;
                while(set.contains(num)) {
                    tempCount++;
                    num++;
                }
                count = Math.max(tempCount, count);
            }
        }
        return count;

    }
}
