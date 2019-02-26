// Print the components of the current date

package com.ofs.training.java.adv.MathDate;

import java.time.LocalDate;

public class ComponentsOfCurrentDate {

    public static void main(String[] args) {

        // Getting current date
        LocalDate ld = LocalDate.now();

        // Printing components of the current date
        System.out.println(ld.getYear());
        System.out.println(ld.getMonth());
        System.out.println(ld.getDayOfMonth());
        System.out.println(ld.getDayOfYear());
        System.out.println(ld.lengthOfMonth());
        System.out.println(ld.lengthOfYear());
        System.out.println(ld.getDayOfWeek());
        System.out.println(ld.now());
    }
}




