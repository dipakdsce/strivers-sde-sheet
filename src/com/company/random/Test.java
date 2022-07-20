package com.company.random;

import java.io.Console;

public class Test {
    public static void main(String[] args) {
        Exception exception = null;
        try
        {
            try
            {
                throw new Exception("exception thrown from try block");
            }
            catch (Exception ex)
            {
                exception = new Exception("Random Exception");
                System.out.println("Inner catch block handling ex = " + ex.getMessage());
            }
            finally
            {
                System.out.println("Inner finally block");
                try {
                    System.out.println("exception thrown from finally block");
                    if(exception != null)
                        throw exception;
                } catch (Exception e) {
                    System.out.println("This line is never reached " + e.getMessage());
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Outer catch block handling " + ex.getMessage());
        }
        finally
        {
            System.out.println("Outer finally block");
        }
    }
}
