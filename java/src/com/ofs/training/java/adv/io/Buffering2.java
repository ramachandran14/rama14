package com.ofs.training.java.adv.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Buffering2 {

    public static void main(String[] args) throws IOException {

        FileOutputStream f = new FileOutputStream("D:\\rama.txt");
        BufferedOutputStream b = new BufferedOutputStream(f);
        String s = "My bufferedReader";
        String v = "You are awesome";
        byte c[] = v.getBytes();
        byte a[] = s.getBytes();
        b.write(a);
        b.write(65);
        b.write(c);
        b.flush();
        b.close();
    }
}



