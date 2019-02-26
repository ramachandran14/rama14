// Given a path, check if path is file or directory

package com.ofs.training.java.adv.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindingDirectory {

    public static void main(String[] args) {

        // creating a path
        Path path = Paths.get("D:\\temp\\Practice");

        String s = path.toString();

        File file = new File(s);

             if (file.isFile()) { System.out.println("it is file"); }
        else if (file.isDirectory()) { System.out.println("it is directory"); }
        else { System.out.println("it is neither file nor directory"); }
    }
}







