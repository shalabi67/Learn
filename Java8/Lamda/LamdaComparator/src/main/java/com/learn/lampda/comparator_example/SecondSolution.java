package com.learn.lampda.comparator_example;

import com.learn.lampda.model.Data;
import com.learn.lampda.model.Output;
import com.learn.lampda.model.Person;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Created by mohammad on 7/12/2017.
 */
public class SecondSolution {
    //this is the first change ( replace -  with compareTo) but not enough since we still have function dependency
    public static final Comparator<Person> byAge = (p1, p2) -> p1.getAge().compareTo(p2.getAge());
    public static final Comparator<Person> byFirstName = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
    public static final Comparator<Person> byLastName = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());

    //we need to fix this function
    public static int compare(Person p1, Person p2, Comparator<Person> comparator) {
        return comparator.compare(p1, p2);
    }

    public static final Function<Person, Integer> ageFunction = Person::getAge;
    public static final Function<Person, String> firstNameFunction = Person::getFirstName;
    public static final Function<Person, String> lastNameFunction = Person::getLastName;

    public static Comparator<Person> buildIntegerComparator(Function<Person, Integer> function) {
        return (p1, p2) -> function.apply(p1).compareTo(function.apply(p2));
    }

    public static Comparator<Person> buildStringComparator(Function<Person, String> function) {
        return (p1, p2) -> function.apply(p1).compareTo(function.apply(p2));
    }

    public static void demo() {

        System.out.println("Even this is looking better but we still have a problem with the " +
                "function type(Integer, and String) and  " +
                "we still can not do the chain operations we can not say compare by name then by age");

        Comparator<Person> function = buildIntegerComparator(ageFunction);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        function = buildStringComparator(Person::getFirstName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        function = buildStringComparator(lastNameFunction);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));
    }
}
