// Print all the persons in the roster using java.util.Stream<T>#forEach

package com.ofs.training.java.adv.coll;

import java.util.List;

public class ForEach {

    public static void main(String[] args) {

        List<Person> persons = Person.createRoster();

        for(Person s: persons)
            System.out.println(s);

        System.out.println();

        // Printing name and email address of person list
        persons.stream().forEach(n -> System.out.println(n.name + " " + n.emailAddress));
    }
}


