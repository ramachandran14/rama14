// find the first person from the filtered persons
// find the last person from the filtered persons
// find random person from the filtered persons

package com.ofs.training.java.adv.coll;

import java.util.List;

public class Find {

    public static void main(String[] args) {

        List<Person> v = Person.createRoster();

        // get first person from filtered persons
        String res = v.stream().findFirst().get().getName();

        // get random person from filtered persons
        String res1 = v.stream().findAny().get().getName();

        // get first person from filtered persons
        String p = v.get(v.size() - 1).getName();

        // Printing the filtered persons
        System.out.println(res);
        System.out.println(res1);
        System.out.println(p);
    }
}


