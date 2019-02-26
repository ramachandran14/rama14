// List<Integer> randomNumbers = Array.asList( {1, 6, 10, 1, 25, 78, 10, 25} );
// Get the non-duplicate values from the above list using java.util.Stream API

package com.ofs.training.java.adv.coll;

import java.util.Map;
import java.util.TreeMap;

public class DuplicateRemoval {

    public static void main(String[] args) {

        TreeMap<Integer, String> randomNumbers = new TreeMap<>();
        randomNumbers.put(1, "");
        randomNumbers.put(6, "");
        randomNumbers.put(10, "");
        randomNumbers.put(1, "");
        randomNumbers.put(25, "");
        randomNumbers.put(78, "");
        randomNumbers.put(10, "");
        randomNumbers.put(25, "");

        for (Map.Entry m : randomNumbers.entrySet()) {
            System.out.println(m.getKey());
        }
    }
}




