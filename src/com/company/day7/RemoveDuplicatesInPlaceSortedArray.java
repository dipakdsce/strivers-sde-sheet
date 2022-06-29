package com.company.day7;

public class RemoveDuplicatesInPlaceSortedArray {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3,3,3,3,4,4};
        int res = removeDuplicates(arr);
        for(int i=0; i<res; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int removeDuplicates(int[] arr) {
        int uniqueIndex = 0;
        for(int i=1; i<arr.length; i++) {
            if(arr[uniqueIndex] != arr[i]) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }
        return uniqueIndex + 1;
    }
}
