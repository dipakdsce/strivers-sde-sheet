package com.company.day3;

import java.util.ArrayList;

public class FindMajorityElementNby3 {
    public static void main(String[] args) {
        int[] arr = {2,1,1,3,1,4,5,6};
        int[] res = findMajority(arr, arr.length);
        for(int num :  res)
            System.out.print(num + " ");
    }

    private static int[] findMajority(int arr[], int n) {
        int num1 = 0, count1 = 0, num2=0, count2=0;
        for(int num : arr) {
            /*if(count1 == 0) {
                num1 = num;
            } else if(count2 == 0) {
                num2 = num;
            }
            if(num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else {
                count1--;
                count2--;
            }*/
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;
            else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : arr) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(count1 > n/3) {
            res.add(num1);
        }
        if(count2 > n/3) {
            res.add(num2);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
