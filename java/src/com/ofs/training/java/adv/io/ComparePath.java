// Write a program to check if two paths are same.

package com.ofs.training.java.adv.io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparePath {

    public static void main(String[] args) {

        Path path = Paths.get("D:\\Rama");
        Path path2 = Paths.get("D:\\Rama");
        System.out.println(path.compareTo(path2));
        System.out.println(path.equals(path2));
    }
}


