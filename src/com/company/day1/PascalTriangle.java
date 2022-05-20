package com.company.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Long> res = returnPascalTriangle(n);
        for(long num : res) {
            System.out.print(num % (1000000007) + " ");
        }
    }

    public static void printPascal(int n) {
        if ( n >= 1) {
            System.out.println(1);
        }
        if (n >= 2) {
            System.out.println("1 1");
        }
        if ( n >= 3) {
            List<Integer> pascalList = new ArrayList<>();
            pascalList.add(1);
            pascalList.add(1);
            for(int i=3 ; i<=n; i++) {
                System.out.print(pascalList.get(0) + " ");
                int oldListSize = pascalList.size();
                List<Integer> oldPascalList = new ArrayList<>(pascalList);
                for(int j = 1; j<oldListSize ; j++) {
                    pascalList.set(j, oldPascalList.get(j-1) + oldPascalList.get(j));

                    System.out.print(pascalList.get(j) + " ");
                }
                pascalList.add(1);
                System.out.println(pascalList.get(pascalList.size() - 1));
            }
        }
    }

    public static ArrayList<Long> returnPascalTriangle(int n) {
        ArrayList<ArrayList<Long>> res = new ArrayList<ArrayList<Long>>();
        ArrayList<Long> row, prev = null;
        for(int i=0 ; i<n; i++) {
            row = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    row.add(1L);
                } else {
                    row.add((prev.get(j-1) + prev.get(j))%1000000007);
                }
            }
            prev = row;
            res.add(row);
        }
        return res.get(res.size() - 1);
    }
}
