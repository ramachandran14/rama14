package com.ofs.training.java.adv.coll;

import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicatePersonRemoval {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add(new String("John"));
        names.add(new String("John"));
        //System.out.println(names);
        System.out.println(names.stream().distinct().collect(Collectors.toList()));

        List<Person> persons = Person.createRoster();
        persons.add(new Person("Bob",
                     IsoChronology.INSTANCE.date(2000, 9, 12),
                     Person.Sex.MALE,
                     "bob@example.com"));
        //System.out.println(persons);
        List<Person> list = persons.stream().distinct().collect(Collectors.toList());
        for (Person person : list) {
            person.printPerson();
        }
    }
}
