package com.company.day8;

import java.util.Arrays;

public class MinimumNumberOfPlatform {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        System.out.println(minimumPlatformRequired(n, arr, dep));
        System.out.println(platformRequired(n, arr, dep));
    }

    private static int minimumPlatformRequired(int n, int[] arr, int[] dep) {
        if(n == 0) {
            return 0;
        }
        int count = 1;
        int min = arr[0];
        int max = dep[0];
        for(int i=1; i<n; i++) {
            if(arr[i] == min || dep[i] == min || arr[i] == max || dep[i] == max) {
                count++;
            }
            if(arr[i] < min) {
                if(dep[i] >= min) {
                    count++;
                    if(dep[i] > max) {
                        max = dep[i];
                    }
                }
                min = arr[i];
            } else {
                if(arr[i] < max) {
                    count++;
                    if(dep[i] > max) {
                        max = dep[i];
                    }
                } else {
                    max = dep[i];
                }
            }
        }
        return count;
    }

    private static int platformRequired(int n, int[] arr, int[] dep) {
        if(n == 0 || n == 2) {
            return n;
        }
        Arrays.sort(arr);
        Arrays.sort(dep);
        int res = 1, platformNeeded = 1;
        int i=1, j=0;
        while (i < n && j < n) {
            if(arr[i] < dep[j]) {
                platformNeeded++;
                i++;
                if(platformNeeded > res){
                    res = platformNeeded;
                }
            } else if(arr[i] > dep[j]) {
                platformNeeded--;
                j++;
            }
            res = Math.max(platformNeeded, res);
        }
        return res;
    }
}
