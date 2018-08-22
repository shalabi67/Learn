package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

public class ElementAt {
    public static void main(String[] args) {
        /**
         * You can get a specific emission by its index specified by a Long, starting at 0.
         * After that item is found and emitted, onComplete() will be called and the subscription will be disposed of.
         * If you want to get the fourth emission coming from an Observable.
         * It returns Maybe<T> instead of Observable<T>. This is because it will yield one emission,
         * but if there are fewer emissions than the sought index, it will be empty.
         */
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
                "Delta")
                .elementAt(3)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
