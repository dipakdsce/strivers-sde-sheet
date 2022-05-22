package com.company.day3;

public class FindMajorityElement {
    public static void main(String[] args) {
        int arr[] = {1,2,3} ;
        System.out.println(findMajority(arr));
    }

    private static int findMajority(int[] arr) {
        int count = 0;
        int candidate = 0;
        for(int num : arr) {
            if(count == 0) {
                candidate = num;
            }
            if(candidate == num) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for(int num : arr) {
            if(num == candidate) {
                count++;
            }
        }
        return count > arr.length/2 ? candidate : -1;
    }
}
