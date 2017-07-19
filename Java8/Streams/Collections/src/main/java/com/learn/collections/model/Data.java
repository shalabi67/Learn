package com.learn.collections.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohammad on 7/12/2017.
 */
public class Data {
    public static Person personOne = new Person("mohammad", "shalabi", 50);
    public static Person personTwo = new Person("mohammad", "ahmad", 50);

    public static Employee employeeOne = new Employee("mohammad", "shalabi", 50);
    public static Employee employeeTwo = new Employee("mohammad", "Ahmad", 53);
    public static Employee employeeThree = new Employee("mohammad", "ahmad", 50);
    public static Employee employeeFourth = new Employee("ali", "shalabi", 50);

    public static List<Person> getPersons() {
        List<Person> list =new ArrayList<>();
        list.add(personOne);
        list.add(personTwo);
        list.add(new Person());

        return list;
    }
}
