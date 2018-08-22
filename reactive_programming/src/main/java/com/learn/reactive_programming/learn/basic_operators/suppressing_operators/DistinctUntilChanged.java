package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

public class DistinctUntilChanged {
    public static void main(String[] args) {
        /**
         * will ignore duplicate consecutive emissions. It is a helpful way to ignore repetitions until they change.
         * If the same value is being emitted repeatedly, all the duplicates will be ignored until a new value is emitted.
         * Duplicates of the next value will be ignored until it changes again, and so on.
         */
        Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
                .distinctUntilChanged()
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
                "Delta")
                .distinctUntilChanged(String::length)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
