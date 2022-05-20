package com.company.day1;

import java.util.Arrays;

public class Sort012 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        int[] res = sort(nums);
        Arrays.stream(res).forEach(num -> System.out.print(num + " "));
    }

    private static int[] sort(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            if(nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int low, int mid) {
        int temp = nums[low];
        nums[low] = nums[mid];
        nums[mid] = temp;
    }
}
