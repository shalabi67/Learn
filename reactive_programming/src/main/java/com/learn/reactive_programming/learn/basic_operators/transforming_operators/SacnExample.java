package com.learn.reactive_programming.learn.basic_operators.transforming_operators;

import io.reactivex.Observable;

public class SacnExample {
    /**
     * The scan() method is a rolling aggregator. For every emission, you add it to an accumulation.
     * Then, it will emit each incremental accumulation.
     */
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 10, 2, 14)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(s -> System.out.println("Received: " + s));

        System.out.println("------------------count items-------------------");
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .scan(0, (total, next) -> total + 1)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
