package com.company.day7;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(findTotalRainWaterTrapped(height));
        System.out.println(timeEfficientSolution(height));
    }

    //Optimal solution with O(n) time and O(1) space complexity
    private static int findTotalRainWaterTrapped(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    res += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += rightMax - height[right];
                }
                right--;
            }
        }
        return res;
    }

    //Only Time efficient but not space efficient O(n) time and space complexity
    private static int timeEfficientSolution(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];

        for(int i=1; i<n; i++) {
            if(prefixMax[i-1] < height[i]) {
                prefixMax[i] = height[i];
            } else {
                prefixMax[i] = prefixMax[i-1];
            }

            if(height[n-1-i] > suffixMax[n-i]) {
                suffixMax[n-1-i] = height[n-1-i];
            } else {
                suffixMax[n-1-i] = suffixMax[n-i];
            }
        }
        int res = 0;
        for(int i=0; i<n; i++) {
            res += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return res;
    }
}
