package com.learn.lambda.functional_interfaces.consumers;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by mohammad on 7/13/2017.
 */
public class ConsumerExample {
    public static void demo() {
        Consumer<String> consumerPrint = System.out::println;
        consumerPrint.accept("Hello this is Consumer interface using Method reference.");


        consumerPrint = s -> System.out.println(s);
        consumerPrint.accept("Hello this is Consumer interface using Lambda expression.");
    }
}
