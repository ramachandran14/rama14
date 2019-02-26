package com.ofs.training.java.base;

public class Fibonacci {

    public static void main(String[] args) {

        int total = 10;
        int a = 0;
        int b = 1;
        System.out.println("fibonacci series of" +total+ "numbers:");

        for(int i = 0; i <= total; ++i) {

            int sum = a+b;
            a = b;
            b = sum;
            System.out.println(" " + sum);
        }
    }
}

