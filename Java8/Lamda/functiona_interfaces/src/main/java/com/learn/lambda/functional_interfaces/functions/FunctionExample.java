package com.learn.lambda.functional_interfaces.functions;

import com.learn.lambda.functional_interfaces.model.Data;
import com.learn.lambda.functional_interfaces.model.Person;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by mohammad on 7/13/2017.
 */
public class FunctionExample {
    public static void demo() {
        Function<Person, String> personStringFunction = Person::toString;  //this is a mapping function which maps person to string
        System.out.println("Function " + personStringFunction.apply(Data.personOne));

        personStringFunction = (person) -> person.toString();
        System.out.println("Function " + personStringFunction.apply(Data.personTwo));
    }
}
