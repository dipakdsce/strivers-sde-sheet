package com.company.day3;

public class SearchIn2DSortedMatrix {
    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 30, 40},
                {15, 11, 16, 20},
                {23, 30, 34, 60}
        };
//        int[][] mat = {{1,1}};
        int target = 3;
        System.out.println(find(mat, target));
    }

    private static boolean find(int[][] mat, int target) {
        int low = 0;
        if(mat.length == 0) return false;
        int n = mat.length;
        int m = mat[0].length;
        int high = (n*m) - 1;
        while(low<=high) {
            int mid = (low + (high - low)/2);
            if(mat[mid/m][mid % m] == target) {
                return true;
            }
            if (mat[mid/m][mid % m] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
