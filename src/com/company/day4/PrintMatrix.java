package com.company.day4;

import java.util.Scanner;

public class PrintMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        print(m, n);
    }

    private static void print(int m, int n) {
        boolean flag = true;
        int count = 1;
        for(int i=0; i<m; i++) {
            if(flag) {
                for(int j=0; j<n; j++) {
                    System.out.print(count++ + " ");
                }
                flag = false;
            } else {
                int tempCount = count + n - 1;
                count = tempCount;
                for(int j=0; j<n; j++) {
                    System.out.print(count-- + " ");
                }
                count = tempCount + 1;
                flag = true;
            }
            System.out.println();
        }
    }
}
