// For a given year, print the length of each month within that year.

package com.ofs.training.java.adv.MathDate;

import java.time.LocalDate;
import java.time.Month;

public class LengthOfMonth {

    public static void main(String[] args) {

        Month month = Month.from(LocalDate.now());
        Month september = Month.from(month.minus(1));
        Month august = Month.from(month.minus(2));
        Month july = Month.from(month.minus(3));
        Month june = Month.from(month.minus(4));
        Month may = Month.from(month.minus(5));
        Month april = Month.from(month.minus(6));
        Month march = Month.from(month.minus(7));
        Month february = Month.from(month.minus(8));
        Month january = Month.from(month.minus(9));
        Month november = Month.from(month.plus(1));
        Month december = Month.from(month.plus(2));

        System.out.println("total no of days in october " + month.length(true));
        System.out.println("total no of days in september " + september.length(true));
        System.out.println("total no of days in august " + august.length(true));
        System.out.println("total no of days in july " + july.length(true));
        System.out.println("total no of days in june " + june.length(true));
        System.out.println("total no of days in may " + may.length(true));
        System.out.println("total no of days in april " + april.length(true));
        System.out.println("total no of days in march " + march.length(true));
        System.out.println("total no of days in february " + february.length(true));
        System.out.println("total no of days in january " + january.length(true));
        System.out.println("total no of days in november " + november.length(true));
        System.out.println("total no of days in december " + december.length(true));
    }
}

