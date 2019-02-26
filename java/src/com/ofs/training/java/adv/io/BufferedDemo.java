// Write some String content to a file using appropriate OutputStream

package com.ofs.training.java.adv.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class BufferedDemo {

    public static void main(String[] args) throws IOException {

        FileOutputStream outputStream = new FileOutputStream("D:\\suhil");

        Writer outputStreamWriter = new OutputStreamWriter(outputStream);

        outputStreamWriter.write("welcome");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
}
