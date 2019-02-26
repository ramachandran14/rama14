// For a given month of the current year, lists all of the Mondays in that month with date in mm-dd-yyyy format.

package com.ofs.training.java.adv.MathDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

public class ListMondays {

    public static void main(String[] args) {

        Month month = Month.valueOf("August".toUpperCase());
        System.out.println(month);

        // Getting the first monday of the given month
        LocalDate l = Year.now().atMonth(month).atDay(2).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        Month m = l.getMonth();

        while (m == month) {

            System.out.printf("%s %n", l);

            // Getting next dates of mondays on the given month
            l = l.with(TemporalAdjusters.next(DayOfWeek.MONDAY));

            m = l.getMonth();
        }
    }
}


