// Check if a object is non-null

package com.ofs.training.java.adv.MathDate;

import java.util.Objects;

public class ObjectIsNonNull {

    public static void main(String[] args) {

        // Creating new object
        Object object = new Object();

        // Initializing object as null
        object = null;

        System.out.println(Objects.nonNull(object));
    }
}



