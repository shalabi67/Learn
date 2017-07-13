package com.learn.lambda.functional_interfaces.predicate;

import com.learn.lambda.functional_interfaces.model.Person;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by mohammad on 7/13/2017.
 */
public class PredicateExample {
    public static void demo() {
        Predicate<String> stringPredicate = String::isEmpty;
        System.out.println("Check if string is empty " + stringPredicate.test("   "));


        stringPredicate = (s) -> s.length()>10;
        System.out.println("Check if string length is grater than 10 " + stringPredicate.test("  dsgfdsgfasasdf "));
    }
}
