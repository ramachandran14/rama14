// Generate and print a random number every time

package com.ofs.training.java.adv.MathDate;

import java.util.Random;

public class RandomNumber {

    public static void main(String[] args) {

        // double rnd = Math.random();
        // System.out.println(rnd);

        Random rnd1 = new Random();

        // Generating a randomNumber from 0 to 1000
        int u = rnd1.nextInt(1000);
        System.out.println(u);
    }
}








