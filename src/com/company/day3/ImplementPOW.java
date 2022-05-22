package com.company.day3;

public class ImplementPOW {
    public static void main(String[] args) {
        System.out.println(power(99, 928));
    }

    public static double pow(double x, int n) {
        double ans = 1.0;
        long nn = n;
        if(nn < 0) {
            nn = (-1) * nn;
        }
        while (nn > 0) {
            if(nn % 2 == 1) {
                ans *= x;
                nn -= 1;
            } else {
                x *= x;
                nn /= 2;
            }
        }

        if ( n < 0) {
            ans = 1.0 / ans;
        }
        return ans;
    }

    //GeeksForGeeks Question
    static long power(int a, long b){
        //complete the function here
        long ans = 1;
        long base = a;
        while( b > 0) {
            if(b%(long) 2 == 1) {
                ans = (ans * base) % 1000000007;
                b -= 1;
            } else {
                base = (base * base) % 1000000007;
                b /= 2;
            }
        }
        ans = (ans % 1000000007);
        return ans;
    }
}
