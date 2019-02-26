// new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bob@example.com")
// Check if the above Person is in the roster list obtained from Person class

package com.ofs.training.java.adv.coll;

import java.time.chrono.IsoChronology;
import java.util.List;

public class ContainsFileld {

    public static void main(String[] args) {

        // Get the roster list
        List<Person> persons = Person.createRoster();

        // Creating new person
        Person a = new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bob@example.com");

        // Checking whether the new person is in list
        boolean b = persons.contains(a);
        System.out.println(b);

    }
}
