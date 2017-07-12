package com.learn.lampda.comparator_example;

import com.learn.lampda.model.Data;
import com.learn.lampda.model.Output;
import com.learn.lampda.model.Person;

import java.util.Comparator;

/**
 * Created by mohammad on 7/12/2017.
 */
public class FirstSolution {
    public static final Comparator<Person> byAge = (p1, p2) -> p1.getAge() - p2.getAge();
    public static final Comparator<Person> byFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
    public static final Comparator<Person> byLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

    public static int compare(Person p1, Person p2, Comparator<Person> comparator) {
        return comparator.compare(p1, p2);
    }

    public static void demo() {

        System.out.println("The problem with this is the byAge, byFirstName and byLastName lambda is similar, " +
                "and they differ only by the calling function which is mapped also to lambda variable name. " +
                "another problem is we can not chain operations we can not say compare by name then by age");

        Output.printResult(compare(Data.personOne, Data.personTwo, byAge));
        Output.printResult(compare(Data.personTwo, Data.personOne, byAge));
        Output.printResult(compare(Data.personOne, Data.personOne, byAge));

        Output.printResult(compare(Data.personOne, Data.personTwo, byFirstName));
        Output.printResult(compare(Data.personTwo, Data.personOne, byFirstName));
        Output.printResult(compare(Data.personOne, Data.personOne, byFirstName));

        Output.printResult(compare(Data.personOne, Data.personTwo, byLastName));
        Output.printResult(compare(Data.personTwo, Data.personOne, byLastName));
        Output.printResult(compare(Data.personOne, Data.personOne, byLastName));
    }
}
