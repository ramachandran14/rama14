// Formatting current date to following formats: 2001-07-04T12:08:56.235-0700 and 2001.07.04 at 12:08:56 PDT

package com.ofs.training.java.adv.MathDate;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FormattingDate {

    public static void main(String[] args) {

        // Specifying the format for the current date
        SimpleDateFormat dtf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss z");

        Date date = new Date();

        System.out.println(dtf.format(date));

        // Getting current date and time
        LocalDateTime localdate = LocalDateTime.now();

        System.out.println(localdate);
    }
}



