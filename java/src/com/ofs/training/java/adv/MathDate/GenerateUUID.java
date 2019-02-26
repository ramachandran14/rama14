// Generate and print a unique id with alpha-numerical characters

package com.ofs.training.java.adv.MathDate;

import java.util.UUID;

public class GenerateUUID {

    public static void main(String[] args) {

        UUID uid = UUID.fromString("384D00000-8cf-1b1-02f4-30b9f4eaf00d");
        System.out.println(uid.randomUUID());

        // UUID e = UUID.randomUUID();
        // System.out.println(e);
    }
}

