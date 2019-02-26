// Read a any text file using BufferedReader and print the content of the file

package com.ofs.training.java.adv.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Buffering {

    public static void main(String[] args) throws IOException {

        File f = new File("D:\\temp\\xanadu.txt");

        BufferedReader br = new BufferedReader(new FileReader(f));

        int i;
        while ((i = br.read()) != -1) {
            System.out.print((char) i);
        }
        br.close();
    }
}



