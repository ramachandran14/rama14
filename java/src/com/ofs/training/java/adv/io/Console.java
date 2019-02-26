// Write some String content to console using appropriate Writer

package com.ofs.training.java.adv.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Console {

    public static void main(String[] args) throws IOException {

        FileWriter f = new FileWriter("D:\\suhil");

        BufferedWriter bf = new BufferedWriter(f);

        String s = "God is Faith ";
        String s1 = s.concat(args[0] + "" + args[1] + "" + args[2]);

        System.out.println(s1);
    }
}


