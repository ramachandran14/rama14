// Write a program to filter the Person, who are male and age greater than 21

package com.ofs.training.java.adv.coll;

import java.util.List;

public class FilterPerson {

    public static void main(String[] args) {

        List<Person> l = Person.createRoster();

        for (Person person : l) {

            if (person.getAge() > 21 && person.getGender() == Person.Sex.MALE) {

                person.printPerson();
            }
        }

        System.out.println();

        // List<Person> l1 = l.stream()
        // .filter (person -> (person.getAge() > 21 && person.getGender() == Person.Sex.MALE))
        // .collect(Collectors.toList());
        // for (Person person : l1) {
        // person.printPerson();
    }
}



