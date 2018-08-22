package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

public class DistinctExample {
    /**
     * will emit each unique emission, but it will suppress any duplicates that follow.
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon", "Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .distinct()
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .map(String::length)
                .distinct()
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .distinct(String::length)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
