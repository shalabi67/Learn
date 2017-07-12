package com.learn.lampda.comparator_example;

import com.learn.lampda.model.Data;
import com.learn.lampda.model.Output;
import com.learn.lampda.model.Person;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Created by mohammad on 7/12/2017.
 */
public class ThirdSolution {

    //we need to fix this function
    public static int compare(Person p1, Person p2, Comparator<Person> comparator) {
        return comparator.compare(p1, p2);
    }

    //The challane is we need to have one function instead of buildIntegerComparator and buildStringComparator
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

        Comparator<Person> function = buildIntegerComparator(Person::getAge);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        function = buildStringComparator(Person::getFirstName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        function = buildStringComparator(Person::getLastName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));
    }
}
