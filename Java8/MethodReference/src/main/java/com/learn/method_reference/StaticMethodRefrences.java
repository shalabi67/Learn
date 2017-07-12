package com.learn.method_reference;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Created by mshalabi on 23.06.17.
 */
public class StaticMethodRefrences {
    public static void main(String[] args ) {
        Consumer<String> staticExample = StaticMethodRefrences::showStaticExample;
        staticExample.accept("Method Reference for Static");

        Supplier<Thread> currentThreadReference = Thread::currentThread;
        System.out.println("The current thread is " + currentThreadReference.get().getName());  //This should print current thread

    }

    private static void showStaticExample(String header) {
        System.out.println(header);

        NoArgumentNoResult publicStatic = MethodReference::printPublicStaticMethod;
        publicStatic.doOperation();

        MethodReference.usePrivateMethd.doOperation();

        System.out.println("------------------------------------------");
    }
}
