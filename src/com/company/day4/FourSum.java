package com.company.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] num = {1,0,-1,0,-2,2};
        List<List<Integer>> res = findQuadruples(num, num.length, 0);
        System.out.println(res);
    }

    private static List<List<Integer>> findQuadruples(int[] arr, int n, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(arr == null || n == 0) {
            return res;
        }
        Arrays.sort(arr);
        for(int i=0; i<n; i++) {
            int target3 = target - arr[i];
            for(int j=i+1; j<n; j++) {
                int target2 = target3 - arr[j];
                int front = j + 1;
                int back  = n - 1;
                while (front < back) {
                    int two_sum = arr[front] + arr[back];
                    if(two_sum < target2) {
                        front++;
                    } else if (two_sum > target2) {
                        back--;
                    } else {
                        List<Integer> quadruple = new ArrayList<>();
                        quadruple.add(arr[i]);
                        quadruple.add(arr[j]);
                        quadruple.add(arr[front]);
                        quadruple.add(arr[back]);
                        res.add(quadruple);
                        while (front < back && arr[front] == quadruple.get(2))
                            front++;
                        while (front < back && arr[back] == quadruple.get(3))
                            back--;
                    }
                }
                while (j+1 < n && arr[j+1] == arr[j])
                    j++;
            }
            while (i+1 < n && arr[i+1] == arr[i])
                i++;
        }
        return res;
    }
}
