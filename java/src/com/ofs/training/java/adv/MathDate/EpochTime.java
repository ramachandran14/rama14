//  Print the Epoch time

package com.ofs.training.java.adv.MathDate;

import java.time.Instant;

public class EpochTime {

    public static void main(String[] args) {

        // Date date = new Date();
        // Instant instant = date.toInstant();
        // System.out.println(instant);

        Instant instant1 = Instant.now();

        // Getting EpochTime of current time
        long epochTime = instant1.getEpochSecond();

        System.out.println(instant1);
        System.out.println(epochTime);
    }
}

