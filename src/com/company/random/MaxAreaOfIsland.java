package com.company.random;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIsland {

    static class Pair {
        int row;
        int col;
        Pair(int y, int x) {
            row = y;
            col = x;
        }
    }

    public static void main(String[] args) {
        int grid[][] =  {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,1,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,1,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(largestIsland(grid));
    }

    private static int bfs(int[][] grid, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        int area = 1;

        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(row, col));
        grid[row][col] = 0;
        int[] dir = {-1, 0, 1, -1};
        return 1;
    }

    private static int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
}
