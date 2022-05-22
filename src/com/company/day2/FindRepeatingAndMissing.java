package com.company.day2;

public class FindRepeatingAndMissing {
    public static void main(String[] args) {
        int arr[] = {1, 3, 3};
        find(arr);
    }

    private static void find(int[] nums) {
        int n = nums.length;
        long s = (long) n * (n+1)/2;
        long p = (long) n*(n+1)*((long)2*n+1)/6;

        for(int i=0; i<n; i++) {
            s -= nums[i];
            p -= (long) nums[i] * (long) nums[i];
        }
        int missingNum = (int) (s + p/s)/2;
        int repeatingNum = missingNum - (int) s;
        System.out.println("missing=" + missingNum + " repeating=" + repeatingNum);
    }
}
