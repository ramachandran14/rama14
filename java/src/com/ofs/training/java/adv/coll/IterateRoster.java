// Iterate the roster list in Persons class and print the Person without using forLoop/Stream

package com.ofs.training.java.adv.coll;

import java.util.List;

public class IterateRoster {

    public static void main(String[] args) {

        List<Person> persons = Person.createRoster();

        // persons.listIterator();
        persons.iterator().forEachRemaining(p -> System.out.println(p.name));

       // while(it.hasNext() -> System.out.println(it.next().getName())); {
       // System.out.println(it.next().getName());
       // }
    }
}



