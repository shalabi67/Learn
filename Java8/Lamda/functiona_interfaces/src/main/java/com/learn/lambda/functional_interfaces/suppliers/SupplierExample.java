package com.learn.lambda.functional_interfaces.suppliers;

import com.learn.lambda.functional_interfaces.model.Person;

import java.util.function.Supplier;

/**
 * Created by mohammad on 7/13/2017.
 */
public class SupplierExample {
    public static void demo() {
        Supplier<Person> personSupplier = Person::new;  //notice there should be  a default constructor

        System.out.println("This is a person object created using Supplier " + personSupplier.get());
    }
}
