package com.learn.lambda.functional_interfaces.model;

/**
 * Created by mohammad on 7/12/2017.
 */
public class Output {
    public static void printResult(boolean result) {
        if(result)
            System.out.println("They are equal");
        else
            System.out.println("they are different");
    }
}
