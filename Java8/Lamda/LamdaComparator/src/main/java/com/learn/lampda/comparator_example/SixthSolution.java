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
public class SixthSolution {
    public static <T> int compare(T p1, T p2, Comparator<T> comparator) {
        return comparator.compare(p1, p2);
    }


    //we need now to support chaining for the case if two objects are equal.
    // so we will use .thenComparing default method of the comparing class

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


        System.out.println("print Chained  -------------------------------------------");
        //if objects are equal by age, then compare by last name if they are equal then compare by first name
        employeeFunction = Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getLastName)
                .thenComparing(Employee::getFirstName);
        Output.printResult(compare(Data.employeeOne, Data.employeeTwo, employeeFunction));
        Output.printResult(compare(Data.employeeOne, Data.employeeThree, employeeFunction));
        Output.printResult(compare(Data.employeeOne, Data.employeeFourth, employeeFunction));
    }
}
