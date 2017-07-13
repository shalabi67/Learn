package com.learn.lambda.functional_interfaces.chaining_and_with_predicate;

/**
 * Created by mohammad on 7/14/2017.
 */
public class ChainingExample {
    public static void demo() {
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNull =  a -> a == null;
        Predicate<String> isNullOrEmpty = isNull.or(isEmpty);

        System.out.println("string is empty " + isNullOrEmpty.check(""));
        System.out.println("string is null " + isNullOrEmpty.check(null));
        System.out.println("string is  null or  empty " + isNullOrEmpty.check("aaa"));


    }
}
