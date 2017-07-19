package com.learn.collections.foreach;

import com.learn.collections.model.Data;
import com.learn.collections.model.Person;

import java.util.Comparator;
import java.util.List;

/**
 * Created by mshalabi on 14.07.17.
 */
public class ForEachExample {

    public static void demo() {

        System.out.println("print all persons    ------------------------");
        Data.getPersons().forEach(System.out::println);

        System.out.println("remove persones with age less thn 20    ------------------------");
        List<Person> persons =  Data.getPersons();
        persons.removeIf(p -> p.getAge()<20);
        persons.forEach(System.out::println);

        System.out.println("to upercase    ------------------------");
        persons =  Data.getPersons();
        persons.replaceAll(Person::toUpper);
        persons.forEach(System.out::println);


        System.out.println("sorting    ------------------------");
        persons =  Data.getPersons();
        Comparator<Person> lastNameThenAgeComparator =
                Comparator.comparing(Person::getLastName)
                        .thenComparing(Person::getAge);
        persons.sort(lastNameThenAgeComparator);
        persons.forEach(System.out::println);
    }
}
