/*ArrayList<Person> newRoster = new ArrayList<>(4);
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

Create a roster from the Person class and add each Person in the newRoster to the existing list and print the new roster List
Print the number of Persons in roster list after the above addition
Remove all the Person in the roster list*/

package com.ofs.training.java.adv.coll;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class NewRoster {

    public static void main(String[] args) {

        List<Person> persons = Person.createRoster();

        ArrayList<Person> newRoster = new ArrayList<>(4);

        newRoster.add(new Person("John", IsoChronology.INSTANCE.date(1980, 6, 20), Person.Sex.MALE, "john@example.com"));
        newRoster.add(new Person("Jade", IsoChronology.INSTANCE.date(1990, 7, 15), Person.Sex.FEMALE, "jade@example.com"));
        newRoster.add(new Person("Donald", IsoChronology.INSTANCE.date(1991, 8, 13), Person.Sex.MALE, "donald@example.com"));
        newRoster.add(new Person("Bob", IsoChronology.INSTANCE.date(2000, 9, 12), Person.Sex.MALE, "bob@example.com"));

        persons.addAll(newRoster);

        for (Person o : persons) {

            System.out.println(o.name + " " + o.getAge());
        }

        System.out.println("The size of the list after the addition is " + persons.size());

        persons.clear();

        System.out.println("The size of the list after deletion is " + persons.size());
    }
}
