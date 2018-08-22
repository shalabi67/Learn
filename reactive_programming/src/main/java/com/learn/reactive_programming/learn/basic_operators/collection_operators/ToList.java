package com.learn.reactive_programming.learn.basic_operators.collection_operators;

import io.reactivex.Observable;

public class ToList {
    /**
     * For a given Observable<T>, it will collect incoming emissions into a List<T> and
     * then push that entire List<T> as a single emission (through Single<List<T>>).
     *
     * By default, toList() will use a standard ArrayList implementation.
     */
    public static  void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toList()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
