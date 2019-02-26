package com.ofs.training.java.adv.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ConvertingStringToInputStream {

    public static void main(String[] args) throws IOException {

        FileOutputStream f = new FileOutputStream("D:\\Rama");

        BufferedOutputStream bf = new BufferedOutputStream(f);

        String s = "SamuelPraveen";
        String s1 = "Ajith Saran";
        String s3 = s.concat(s1);

        byte b[] = s3.getBytes();
        bf.write(b);
        bf.write(45);
        bf.flush();
        bf.close();
        f.close();
    }
}

