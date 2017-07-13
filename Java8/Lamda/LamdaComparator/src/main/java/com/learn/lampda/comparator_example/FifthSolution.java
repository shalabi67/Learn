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
public class FifthSolution {
    //Now, buildCompartor is not needed any more because it is defined in Comparetor class as static method
    public static <T> int compare(T p1, T p2, Comparator<T> comparator) {
        return comparator.compare(p1, p2);
    }
    public static <T> Comparator<T> buildComparator(Function<T, Comparable> function) {
        return (p1, p2) -> function.apply(p1).compareTo(function.apply(p2));
    }

    //we need now to support chaining for the case if two objects are equal. to do that we need to extend
    // functional interface(Comparator) to support new compare method

    public static void demo() {

        System.out.println("Now we have single method (buildComparator) which can take any method " +
                "we want to compare with, " +
                "but we still can not do the chain operations we can not say compare by name then by age");

        System.out.println("print Person   -----------------------------------");
        Comparator<Person> function = Comparator.comparing(Person::getAge);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        function = Comparator.comparing(Person::getFirstName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        function = Comparator.comparing(Person::getLastName);
        Output.printResult(compare(Data.personOne, Data.personTwo, function));
        Output.printResult(compare(Data.personTwo, Data.personOne, function));
        Output.printResult(compare(Data.personOne, Data.personOne, function));

        System.out.println("print Employee  -------------------------------------------");
        Comparator<Employee> employeeFunction = Comparator.comparing(Employee::getAge);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

        employeeFunction = Comparator.comparing(Employee::getFirstName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

        employeeFunction = Comparator.comparing(Employee::getLastName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));

    }
}
