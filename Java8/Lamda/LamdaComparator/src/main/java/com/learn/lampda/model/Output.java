package com.learn.lampda.model;

/**
 * Created by mohammad on 7/12/2017.
 */
public class Output {
    public static void printResult(int result) {
        if(result == 0)
            System.out.println("They are equal");
        else if(result > 0)
            System.out.println("p1 > p2");
        else if(result < 0)
            System.out.println("p1 < p2");
        else
            throw new RuntimeException("Invalid result " + result);
    }
}
