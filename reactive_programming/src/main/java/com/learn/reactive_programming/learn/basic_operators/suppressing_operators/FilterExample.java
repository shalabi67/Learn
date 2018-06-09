package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

import static io.reactivex.internal.operators.observable.ObservableBlockingSubscribe.subscribe;

public class FilterExample {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .filter(s -> s.length() != 5)
            .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
