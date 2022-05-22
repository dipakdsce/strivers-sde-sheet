package com.company.day2;

public class CountInversionInArray {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};
        System.out.println(mergeSort(arr, new int[arr.length], 0, arr.length - 1));
    }

    private static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, inv_count=0;
        if(right > left) {
            mid = (left + right)/2;
            inv_count += mergeSort(arr, temp, left, mid);
            inv_count += mergeSort(arr, temp, mid+1, right);

            inv_count += merge(arr, temp, left, mid+1, right);
        }
        return inv_count;
    }

    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int inv_count = 0;
        int i = left;
        int j = mid;
        int k = left;
        while( i <= mid - 1 && j <= right) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inv_count += (mid - i);
            }
        }

        while(i <= mid - 1) {
            temp[k++] = arr[i++];
        }

        while(j <= right) {
            temp[k++] = arr[j++];
        }

        for(i = left; i<=right; i++) {
            arr[i] = temp[i];
        }
        return inv_count;
    }
}
