// Get current time using possible APIs

package com.ofs.training.java.adv.MathDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {

    public static void main(String[] args) {

        // Giving pattern of the date to be printed
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:MM:ss");

        // Getting current time
        LocalTime lt = LocalTime.now();

        System.out.println(lt);
    }
}
