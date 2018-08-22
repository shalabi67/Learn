package com.learn.reactive_programming.learn.basic_operators.transforming_operators;

import io.reactivex.Observable;

public class DefaultIfEmptyExample {
    /**
     * If we want to resort to a single emission if a given Observable comes out empty
     */
    public static void main(String[] args) {
        Observable<String> items =
                Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");

        items.filter(s -> s.startsWith("Z"))
                .defaultIfEmpty("None")
                .subscribe(System.out::println);
    }
}
