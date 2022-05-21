package com.company.day2;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 5, 7};
        int arr2[] = {0, 2, 6, 8, 9};
        System.out.println("Before merge:");
        printArray(arr1, arr2);
        System.out.println();
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("After merge:");
        printArray(arr1, arr2);
    }

    private static void printArray(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }


    static void merge(int ar1[], int ar2[], int n, int m) {
       int gap = (int) Math.ceil((m+n)/2.0);
       while(gap > 0) {
           int i=0, j=gap;
           while(j < (m+n)) {
               if(j < n && ar1[i] > ar1[j]) {
                   int temp = ar1[i];
                   ar1[i] = ar1[j];
                   ar1[j] = temp;
               } else if(j >=n && i < n && ar1[i] > ar2[j-n]) {
                   int temp = ar1[i];
                   ar1[i] = ar2[j-n];
                   ar2[j-n] = temp;
               } else if(j>=n & i >=n && ar2[i-n] > ar2[j-n]) {
                   int temp = ar2[i-n];
                   ar2[i-n] = ar2[j-n];
                   ar2[j-n] = temp;
               }
               i++;
               j++;
           }
           if(gap == 1) {
               gap = 0;
           } else {
               gap =(int)Math.ceil(gap/2.0);
           }
       }
    }
}
