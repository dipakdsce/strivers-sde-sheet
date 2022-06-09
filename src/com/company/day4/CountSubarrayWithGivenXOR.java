package com.company.day4;

import java.util.HashMap;

public class CountSubarrayWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = {4,2,2,6,4};
        int  k = 6;
        System.out.println(countSubArray(arr, arr.length, k));
    }

    private static int countSubArray(int[] arr, int n, int k) {
        HashMap<Integer, Integer> vis = new HashMap<>();
        int c = 0;
        int cpx = 0;
        for(int i=0; i<n; i++) {
            cpx = cpx ^ arr[i];
            if(vis.get(cpx^k) != null) {
                c += vis.get(cpx^k);
            }
            if(cpx == k)
                c++;
            if(vis.get(cpx) != null)
                vis.put(cpx, vis.get(cpx) + 1);
            else
                vis.put(cpx, 1);
        }
        return c;
    }
}
