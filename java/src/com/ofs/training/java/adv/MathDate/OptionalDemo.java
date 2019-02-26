//  demonstrate how optional avoids null pointer exception

package com.ofs.training.java.adv.MathDate;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        String[] str = new String[3];

        Optional<String> optional = Optional.ofNullable(str[0]);

        if (optional.isPresent()) {
            System.out.println("values are present");
        }
        else {
            System.out.println("optional prevents null pointer exception");
        }
    }
}




