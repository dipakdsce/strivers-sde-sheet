package com.company.day4;

import java.util.HashMap;

public class LengthOfLongestSubarraySumZero {
    public static void main(String[] args) {
        int[] arr = {9, -3, 3, -1, 6, -5};
        System.out.println(findLength(arr, arr.length));
    }

    private static int findLength(int[] arr, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxi = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(sum == 0) {
                maxi = i + 1;
            } else {
                if(map.get(sum) != null) {
                    maxi = Math.max(maxi, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
