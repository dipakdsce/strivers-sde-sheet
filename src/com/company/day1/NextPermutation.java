package com.company.day1;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 8, 7, 5};
//        int[] arr = {4, 3, 2, 1};
        int[] res = findNextBiggerPermutation(arr);
        Arrays.stream(res).forEach(num -> System.out.print(num + " "));
    }

    public static int[] findNextBiggerPermutation(int[] arr) {
        int i;
        for(i=arr.length - 2; i>=0; i--) {
            if(arr[i] < arr[i+1])
                break;
        }
        if(i == -1)
            Arrays.sort(arr);
        else {
            int min = arr[i];
            int temp = Integer.MAX_VALUE;
            int j;
            int foundIndex = 0;
            for(j = i + 1 ; j<arr.length; j++) {
                if(arr[j] > min && arr[j] <= temp) {
                    temp = arr[j];
                    foundIndex = j;
                }
            }
            arr[i] = temp;
            arr[foundIndex] = min;
            for(int k = i+1; k<(i+1+arr.length)/2; k++) {
                temp = arr[k];
                arr[k] = arr[arr.length - k + i];
                arr[arr.length - k + i] = temp;
            }
        }
        return arr;
    }
}
