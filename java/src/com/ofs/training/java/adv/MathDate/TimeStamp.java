// Create and print the time stamp for current date.

package com.ofs.training.java.adv.MathDate;

import java.sql.Timestamp;

public class TimeStamp {

    public static void main(String[] args) {

        System.out.println(new Timestamp(System.currentTimeMillis()));
    }
}

