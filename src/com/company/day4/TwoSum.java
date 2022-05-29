package com.company.day4;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,2,4,6};
        int sum = 6;
        int[] ans = findIndexes(nums, sum);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int[] findIndexes(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0 ;i<nums.length; i++) {
            if(!map.isEmpty() && map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
