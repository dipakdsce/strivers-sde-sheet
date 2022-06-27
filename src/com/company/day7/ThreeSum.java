package com.company.day7;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(findTriplet(nums));
    }

    private static ArrayList<ArrayList<Integer>> findTriplet(int[] nums) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for(int i=0; i<nums.length - 2; i++) {
            if(i==0 || (i>0 && nums[i] != nums[i-1])) {
                int low = i+1;
                int high = nums.length - 1;
                int sum = -nums[i];
                while (low < high) {
                    if(nums[low] + nums[high] == sum) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[low]);
                        temp.add(nums[high]);
                        res.add(temp);

                        while (low < high && nums[low] == nums[low + 1])
                            low++;

                        while (low < high && nums[high] ==  nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
