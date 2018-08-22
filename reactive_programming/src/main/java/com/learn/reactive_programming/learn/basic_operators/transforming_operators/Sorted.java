package com.learn.reactive_programming.learn.basic_operators.transforming_operators;

import io.reactivex.Observable;

import java.util.Comparator;

public class Sorted {
    /**
     * If you have a finite Observable<T> emitting items that implement Comparable<T>, you can use sorted()
     * to sort the emissions. Internally, it will collect all the emissions and then re-emit them in their sorted order.
     */
    public static void main(String[] args) {
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                .sorted()
                .subscribe(System.out::println);

        System.out.println("---------------------------------");
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);

        System.out.println("---------------------------------");
        Observable.just("Alpha", "Beta", "Gamma" ,"Delta",
                "Epsilon")
                .sorted((x,y) -> Integer.compare(x.length(), y.length()))
                .subscribe(System.out::println);

    }
}
