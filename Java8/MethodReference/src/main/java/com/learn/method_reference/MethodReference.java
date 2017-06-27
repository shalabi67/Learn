package com.learn.method_reference;

/**
 * Created by mshalabi on 23.06.17.
 */
public class MethodReference {
    public static void printPublicStaticMethod() {
        System.out.println("I am puplic static method");
    }

    private static void printPrivateStaticMethod() {
        System.out.println("I am private static method");
    }

    public static  NoArgumentNoResult usePrivateMethd = MethodReference::printPrivateStaticMethod;
}

