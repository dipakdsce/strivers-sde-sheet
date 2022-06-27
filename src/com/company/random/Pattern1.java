package com.company.random;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pattern1 {
    public static void main(String[] args) {
        int n = 7;
        print(n);
    }

    private static void print(int n) {
        int i=1;

        //For Printing increasing sequence
        for(i=1; i<=n; i++) {
            printRow(n, i);
        }

        //For Printing Decreasing sequence
        for(i=n-1; i>=1; i--) {
            printRow(n, i);
        }
    }

    private static void printRow(int n, int i) {
        int j = 1;
        //For printing space
        for (j = 1; j < i; j++) {
            System.out.print(" ");
        }

        //For printing actual number
        for (; j <= n; j++)
            System.out.print(j);
        System.out.println();
    }
}
