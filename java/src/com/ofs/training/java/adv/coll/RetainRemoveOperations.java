// Consider the code snippet of newRoster above
// Remove the only Person who are in the newRoster from the roster list
// Remove the following Person from the roster List:
// new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bob@example.com")

package com.ofs.training.java.adv.coll;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class RetainRemoveOperations {

    public static void main(String[] args) {

        List<Person> list = Person.createRoster();

        ArrayList<Person> newRoster = new ArrayList<>(4);

        newRoster.add(new Person("John",
                IsoChronology.INSTANCE.date(1980, 6, 20),
                Person.Sex.MALE,
                "john@example.com"));
        newRoster.add(new Person("Jade",
                IsoChronology.INSTANCE.date(1990, 7, 15),
                Person.Sex.FEMALE,
                "jade@example.com"));
        newRoster.add(new Person("Donald",
                IsoChronology.INSTANCE.date(1991, 8, 13),
                Person.Sex.MALE,
                "donald@example.com"));
        newRoster.add(new Person("Bob",
                IsoChronology.INSTANCE.date(2000, 9, 12),
                Person.Sex.MALE,
                "bob@example.com"));
        Person person = (new Person("Bob",
                IsoChronology.INSTANCE.date(2000, 9, 12),
                Person.Sex.MALE,
                "bob@example.com"));

        list.remove(person);

        list.removeAll(newRoster);

        for (Person object : list) {
            object.printPerson();
        }
    }
}

