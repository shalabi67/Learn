package com.learn.collections.model;

/**
 * Created by mohammad on 7/12/2017.
 */
public class Person {
    private String firstName;
    private String lastName;
    private Integer age;

    public Person() {
        firstName = "firstName";
        lastName = "lastName";
        age = 0;
    }
    public Person(String firstName, String lastName, int age) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public Person toUpper() {
        //Booth solutions will work.
        /*
        lastName = lastName.toUpperCase();
        firstName = firstName.toUpperCase();
        return this;
        */

        return new Person(firstName.toUpperCase(), lastName.toUpperCase(), age);
    }
}
