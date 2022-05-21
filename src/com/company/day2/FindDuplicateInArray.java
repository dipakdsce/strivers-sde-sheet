package com.company.day2;

public class FindDuplicateInArray {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(getDuplicate(arr));
    }

    private static long getDuplicate(int[] arr) {
        /*int n = arr.length;
        int totalSum =  n *(n-1)/2;
        int arrSum = 0;
        for(int i=0; i<arr.length; i++) {
            arrSum += arr[i];
        }
        return  arrSum - totalSum;*/
        int length = arr.length;
        for(int num : arr) {
            int index = Math.abs(num);
            if(arr[index] < 0) {
                return index;
            }
            arr[index] = -arr[index];
        }
        return length;
    }
}
