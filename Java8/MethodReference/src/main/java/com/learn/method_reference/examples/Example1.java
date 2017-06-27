package com.learn.method_reference.examples;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by mshalabi on 23.06.17.
 *
 * Have a list of Employees we want to
 1- find employees whome age > n
 2- find employes whome first name = some name.
 3- find employes whome last name = some name
 */
public class Example1 {
    public static void main( String[] args )
    {
        Predicate<Employee> employeeAgeFilter = (a) -> a.getAge() > 30;
        getEmployees(employeeAgeFilter);

        System.out.println("-------------------------------------");
        Predicate<Employee> employeeFirstNameFilter = (a) -> a.getFirstName().equals("a5");
        getEmployees(employeeFirstNameFilter);

        /*
        This is solution 2 using static Method reference
         */
        System.out.println(" *************  This is solution 2 using static Method reference ******************");

        System.out.println("---------------Employees with age < 30----------------------");
        Employee.create().stream()
                .filter(Example1::getYoungEmployee)
                .forEach(System.out::println);

        System.out.println("-----------------Employees with first name starts with a--------------------");
        Employee.create().stream()
                .filter(Example1::getAEmployee)
                .forEach(System.out::println);
    }

    static boolean getYoungEmployee(Employee employee) {
        return employee.getAge() < 30;
    }

    static boolean getAEmployee(Employee employee) {
        return employee.getFirstName().startsWith("a");
    }

    private static void getEmployees(Predicate<Employee> employeeFilter) {
        Employee.create().stream()
                .filter(employeeFilter)
                .forEach(System.out::println);
    }
}
