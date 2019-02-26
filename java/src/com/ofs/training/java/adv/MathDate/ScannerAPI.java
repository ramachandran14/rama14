// Get input from the console using Scanner API

package com.ofs.training.java.adv.MathDate;

import java.util.Scanner;

public class ScannerAPI {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter the name");

        String name = scanner.nextLine();
        System.out.println(name);

        System.out.println("enter the age");

        int age = scanner.nextInt();
        System.out.println(age);

        System.out.println("enter the gender");

        char gender = scanner.next().charAt(0);
        System.out.println(gender);

        System.out.println("enter the roll_no");

        long roll_no = scanner.nextLong();
        System.out.println(roll_no);
    }
}
