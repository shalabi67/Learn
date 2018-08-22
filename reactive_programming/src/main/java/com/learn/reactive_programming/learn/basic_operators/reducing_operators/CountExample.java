package com.learn.reactive_programming.learn.basic_operators.reducing_operators;

import io.reactivex.Observable;

public class CountExample {
    /**
     * It will count the number of emissions and emit through a Single once onComplete() is called
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .count()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
