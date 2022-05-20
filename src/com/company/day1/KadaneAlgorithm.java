package com.company.day1;

import java.util.ArrayList;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        findMaximumSubArraySum(nums);
    }

    private static void findMaximumSubArraySum(int[] nums) {
        ArrayList<Integer> subArray = new ArrayList<>();
        int msf = nums[0];
        int meh = 0;
        int s = 0;
        for(int i=0; i<nums.length; i++) {
            meh += nums[i];
            if(meh > msf) {
                msf = meh;
                subArray.clear();
                subArray.add(s);
                subArray.add(i);
            }
            if(meh < 0) {
                meh = 0;
                s = i+1;
            }
        }
        System.out.println(msf);
        for(int i=subArray.get(0) ; i<=subArray.get(1); i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
