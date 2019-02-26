// List<Integer> randomNumbers = Array.asList( {1, 6, 10, 25, 78} );

// Find the sum of all the numbers in the list using java.util.Stream
// Find the maximum of all the numbers in the list using java.util.Stream
// Find the minimum of all the numbers in the list using java.util.Stream

package com.ofs.training.java.adv.coll;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AggregateFunction {

    public static void main(String[] args) {

        List<Integer> randomNumbers = Arrays.asList(1, 6, 10, 25, 78);

        System.out.println(sum(randomNumbers));

        // Finding min and max numbers
        Integer min = Collections.min(randomNumbers);
        Integer max = Collections.max(randomNumbers);

        // Printing the min and max numbers
        System.out.println("The minimum number is:" + min);
        System.out.println("The maximum number is:" + max);

    }

    private static int sum(List<Integer> randomNumbers) {

        return randomNumbers.stream().filter(i -> i >= 5).mapToInt(i -> i).sum();
    }
}
