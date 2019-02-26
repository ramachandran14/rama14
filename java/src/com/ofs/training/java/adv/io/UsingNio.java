// Read a file using java.nio.Files using Paths

package com.ofs.training.java.adv.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UsingNio {

    public static void main(String[] args) throws IOException {

        // Creating a Path
        Path path = Paths.get("D:\\temp\\Practice\\Sum.java");

        // Using List to read the file
        List<String> niobuffer = Files.readAllLines(path);

        System.out.println(niobuffer);
    }
}

// List contents = Files.readAllLines(path);
// for(Path buffering: niobuffer) {
// System.out.println(buffering);
// }
