package com.company.day3;

public class GridUniquePath {
    public static void main(String[] args) {
        System.out.println(uniquePathDP(1,1));
    }

    private static int uniquePath(int m, int n) {
        return countUniquePath(0, 0, m, n);
    }

    private static int countUniquePath(int i, int j, int n, int m) {
        if(i == n-1 && j == m-1)
            return 1;

        if(i >= n || j >= m)
            return 0;

        return countUniquePath(i+1, j, n, m) + countUniquePath(i, j+1, n, m);
    }

    private static int uniquePathDP(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                dp[i][j] = -1;
            }
        }
        return countUniquePathDP(0, 0, m, n, dp);
    }

    private static int countUniquePathDP(int i, int j, int n, int m, int[][] dp) {
        if(i == n-1 && j == m-1) {
            return 1;
        }
        if(i >= n || j>=m) {
           return 0;
        }
        if(dp[i][j] != -1) {
            return dp[i][j];
        } else {
            return dp[i][j] = countUniquePathDP(i+1, j, n, m, dp) + countUniquePathDP(i, j+1, n, m, dp);
        }
    }
}
