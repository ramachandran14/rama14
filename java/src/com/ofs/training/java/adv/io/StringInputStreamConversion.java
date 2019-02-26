// Write a program to convert InputStream to String and vice versa

package com.ofs.training.java.adv.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringInputStreamConversion {

    // Creating a method InputStreamtostring
    public void InputStreamtoString() throws IOException {

        // creating new file
        File f = new File("D:\\temp\\Practice\\xanadu.txt");

        // creating Input Stream
        InputStream i = new FileInputStream(f);

        // creating BufferedReader
        BufferedReader bf = new BufferedReader(new InputStreamReader(i));

        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        String n = null;

        // Passing the n value to While Loop
        while ((n = bf.readLine()) != null) {
            sb.append(n);
            System.out.println(n);
        }

        bf.close();
    }

    public void StringtoInputstream() throws IOException {

        String str = "In Xanadu did Kubla Khan";

        // byte[] b = str.getBytes();

        // creating InputStream
        InputStream j = new ByteArrayInputStream(str.getBytes());

        // creating BufferedReader
        BufferedReader bf = new BufferedReader(new InputStreamReader(j));

        // Using StringBuilder
        StringBuilder sb = new StringBuilder();
        String n = null;

        while ((n = bf.readLine()) != null) {
            sb.append(n);
            System.out.println(n);

        }
        bf.close();

        System.out.println(j);
        j.close();

    }

    public static void main(String[] args) throws IOException {

        StringInputStreamConversion con = new StringInputStreamConversion();

        // Accessing the methods using instance con
        con.InputStreamtoString();
        con.StringtoInputstream();
    }

}
