// Rounding off
//    - Write a Java program to round a BigDecimal number to specified decimals.
//    - Print the following values of a particular BigDecimal number:
//        - absolute value
//        - ceiling
//        - floor
//        - rint
//        - max
//        - min

package com.ofs.training.java.adv.MathDate;

import java.math.BigDecimal;

public class RoundingOff {

    public static void main(String[] args) {

        BigDecimal bd = new BigDecimal("2.6555555668");
        bd = bd.abs();
        System.out.println(bd);

        BigDecimal bd2 = new BigDecimal("4.87654366787");
        bd2 = bd2.setScale(3, BigDecimal.ROUND_CEILING);
        System.out.println(bd2);

        BigDecimal bd4 = new BigDecimal("5.7746477646");
        bd4 = bd4.setScale(4, BigDecimal.ROUND_FLOOR);
        System.out.println(bd4);

        BigDecimal bd3 = new BigDecimal("534.733536367");
        bd4 = bd3.max(bd2);
        System.out.println(bd4);

        BigDecimal bd5 = new BigDecimal("6.3336367");
        bd5 = bd4.min(bd);
        System.out.println(bd5);


    }

}
