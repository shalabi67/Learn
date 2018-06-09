package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

public class TakeExample {
    public static void main(String[] args) {
        /**
         * take a specified number of emissions and then call onComplete()
         */
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .take(3)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
