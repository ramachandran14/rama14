package com.ofs.training.java.base;

public class FibonacciWhile {

    public static void main(String[] args) {

        int total = 10;
        int a = 0;
        int b = 1;
        System.out.println("fibonacci series of" +total+ "numbers:");

        int i = 0;
        while(i <= total) {
            System.out.println(a+ " ");
            int sum = a+b;
            a = b;
            b = sum;
            System.out.println(" " + sum);
            i++;
        }
    }
}
