// Convert a collection to array and vice versa.

package com.ofs.training.java.adv.MathDate;

import java.util.ArrayList;
import java.util.List;

public class CollectionToArray {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("I ");
        list.add("am ");
        list.add("a ");
        list.add("developer ");

        String[] string = list.toArray(new String[0]);

        for(String str : string) {

            System.out.print(str);
        }
    }
}



