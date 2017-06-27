package com.learn.method_reference.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshalabi on 23.06.17.
 */
public class Employee {
    private String firstName;
    private String lastName;
    private int age;

    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAge(Integer age) {
        return age.equals(getAge());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public static List<Employee> create() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("a", "b", 20));
        employees.add(new Employee("a1", "b1", 21));
        employees.add(new Employee("a2", "b2", 22));
        employees.add(new Employee("a3", "b3", 23));
        employees.add(new Employee("a4", "b4", 24));
        employees.add(new Employee("a5", "b5", 25));
        employees.add(new Employee("a6", "b6", 26));
        employees.add(new Employee("a6", "b6", 27));
        employees.add(new Employee("c", "c", 10));
        employees.add(new Employee("b", "b", 30));
        employees.add(new Employee("d", "d", 40));
        employees.add(new Employee("e", "e", 50));
        employees.add(new Employee("", "", 0));

        return employees;
    }

}
