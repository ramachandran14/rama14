// sort the roster list based on the Person's age in descending order using Comparator

package com.ofs.training.java.adv.coll;

import java.util.Collections;
import java.util.List;

public class SortingLambda {

    public static void main(String[] args) {

        List<Person> persons = Person.createRoster();

        // Sorting the persons list using age
        Collections.sort(persons, (p1, p2) -> {

            return p1.birthday.compareTo(p2.birthday);
        });

        for (Person l : persons) {
            l.printPerson();
        }
    }
}


