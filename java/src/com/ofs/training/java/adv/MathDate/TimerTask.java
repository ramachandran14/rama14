// Print a message every 10 seconds using TimerTask API with time, like "6:11 AM Monday, 10 September 2018: Hi I am auto runner"

package com.ofs.training.java.adv.MathDate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class TimerTask {

    public static void main(String[] args) {

        TimerTask timertask = new TimerTask() {

            public void run() {

                Date date = new Date();
                SimpleDateFormat sdt = new SimpleDateFormat("hh:mm a E, dd MMM yyyy:");

                System.out.print(sdt.format(date));
                System.out.print(" Hi I am auto runner");
                System.out.println();
            }

        };

        Timer timer = new Timer();

        //timer.schedule(timertask, 5, 1000);
    }
}

