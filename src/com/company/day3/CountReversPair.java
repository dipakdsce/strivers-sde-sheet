package com.company.day3;

public class CountReversPair {
    public static void main(String[] args) {
        int arr[] = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647};
        System.out.println(mergeSort(arr, 0, arr.length - 1, new int[arr.length]));
    }

    public static int mergeSort(int[] arr, int low, int high, int[] temp) {
        int revPairCount = 0;
        int mid;
        if(high > low) {
            mid = (low + high)/2;
            revPairCount += mergeSort(arr, low, mid, temp);
            revPairCount += mergeSort(arr, mid+1, high, temp);

            revPairCount += merge(arr, low, mid, high, temp);
        }
        return revPairCount;
    }

    public static int merge(int[] arr, int low, int mid, int high, int[] temp) {
        int i = low;
        int j = mid+1;
        int k = low;
        int revPairCount = 0;
        for(i=low; i<=mid; i++) {
            while (j<=high && arr[i] > (2* (long) arr[j])) {
                j++;
            }
            revPairCount += j - (mid+1);
        }
        i = low;
        j = mid + 1;
        while(i<=mid && j<=high) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <=mid) {
            temp[k++] = arr[i++];
        }

        while(j <= high) {
            temp[k++] = arr[j++];
        }

        for(i = 0; i<=high; i++) {
            arr[i] = temp[i];
        }
        return revPairCount;
    }
}
