package com.company.day1;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        /*int[][] matrix ={
                {1,2,3,4},
                {5,0,7,8},
                {0,10,11,12},
                {13,14,15,0}
        };*/
        setRowColZero2(matrix);
        for (int row=0; row < matrix.length; row++) {
            for(int col=0; col < matrix[0].length; col++) {
               /* if(matrix[row][col] == -1)
                    matrix[row][col] = 0;*/
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void setRowColZero2(int[][] mat) {
        int col0 = 1;
        for(int i=0; i < mat.length; i++) {
            if(mat[i][0] == 0)
                col0 = 0;
            for(int j=1; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    mat[i][0] = mat[0][j] = 0;
                }
            }
        }

        for(int i=mat.length-1; i >= 0; i--) {
            for(int j=mat[0].length-1; j>=1; j--) {
                if(mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
            if(col0 == 0)
                mat[i][0] = 0;
        }
    }

    private static void setRowColZero1(int[][] mat) {
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);

        for(int i=0; i < mat.length; i++) {
            for(int j=0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }

        for(int i=0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (row[i] == 0 || col[j] == 0) {
                    mat[i][j] = -1;
                }
            }
        }
    }

    private static void setRowColZero(int[][] matrix) {
        for (int row=0; row < matrix.length; row++) {
            for (int col=0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    setZero(matrix, row, col);
                }
            }
        }
    }

    private static void setZero(int[][] matrix, int i, int j) {
        for(int row=0; row < matrix.length; row++) {
            if(row != i && matrix[row][j] != 0) {
                matrix[row][j] = -1;
            }
        }

        for(int col=0; col<matrix[0].length; col++) {
            if(col != j && matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }
        }
    }


}
