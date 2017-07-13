package com.learn.lampda.comparator_example;

import com.learn.lampda.model.Data;
import com.learn.lampda.model.Employee;
import com.learn.lampda.model.Output;
import com.learn.lampda.model.Person;

import java.util.Comparator;
import java.util.function.Function;

/**
 * Created by mohammad on 7/12/2017.
 */
public class FourthSolution {

    //we need to fix this function
    public static <T> int compare(T p1, T p2, Comparator<T> comparator) {
        return comparator.compare(p1, p2);
    }

    //the solution until now depends on Person we need to make it working for any class

    //to solve this let use Comparable class instead of String or Integer
    public static <T> Comparator<T> buildComparator(Function<T, Comparable> function) {
        return (p1, p2) -> function.apply(p1).compareTo(function.apply(p2));
    }

    public static void demo() {

        System.out.println("Now we have single method (buildComparator) which can take any method " +
                "we want to compare with, " +
                "but we still can not do the chain operations we can not say compare by name then by age");

        System.out.println("print Person   -----------------------------------");
        Comparator<Person> function = buildComparator(Person::getAge);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        function = buildComparator(Person::getFirstName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        function = buildComparator(Person::getLastName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        System.out.println("print Employee  -------------------------------------------");
        Comparator<Employee> employeeFunction = buildComparator(Employee::getAge);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

        employeeFunction = buildComparator(Employee::getFirstName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

        employeeFunction = buildComparator(Employee::getLastName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

    }
}
