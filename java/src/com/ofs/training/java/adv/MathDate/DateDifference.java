// Find the difference between two dates.

package com.ofs.training.java.adv.MathDate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateDifference {

    public static void main(String[] args) {

        // Getting two days for finding difference
        LocalDate birthdate = LocalDate.of(1996, 8, 14);
        LocalDate currentdate = LocalDate.now();

        // Finding difference between days
        long diff_in_year = ChronoUnit.YEARS.between(birthdate, currentdate);
        long diff_in_month = ChronoUnit.MONTHS.between(birthdate, currentdate);
        long diff_in_day = ChronoUnit.DAYS.between(birthdate, currentdate);

        System.out.println(diff_in_year);
        System.out.println(diff_in_month);
        System.out.println(diff_in_day);
    }
}
