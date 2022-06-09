package com.company.day4;

public class PrintPattern {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }

    private static void print(int n) {
        //For printing in increasing order
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                if(j==i) {
                    System.out.print(i);
                } else {
                    System.out.print(i +  "*");
                }
            }
            System.out.println();
        }

        //For printing in decreasing order
        for(int i=n; i>=1; i--) {
            for(int j=i; j>=1; j--) {
                if(j==1) {
                    System.out.print(i);
                } else {
                    System.out.print(i +  "*");
                }
            }
            System.out.println();
        }
    }
}
