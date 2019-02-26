// GroupBy
// List<Integer> randomNumbers = Array.asList( {1, 6, 10, 1, 25, 78, 10, 25} );

package com.ofs.training.java.adv.coll;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Iterator {

    public static void main(String[] args) {

        List<Integer> randomNumbers = Arrays.asList(1, 6, 10, 1, 25, 78, 10, 25);
        ListIterator<Integer> it = randomNumbers.listIterator();

        while (it.hasNext()) {

            System.out.println(it.next());
        }

        System.out.println();
        randomNumbers.stream().distinct().forEach(n -> System.out.print(n + " "));
    }
}
