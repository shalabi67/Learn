package com.learn.reactive_programming.learn.basic_operators.collection_operators;

import io.reactivex.Observable;

public class MapExample {
    /**
     * For a given Observable<T>, the toMap() operator will collect emissions into Map<K,T>,
     * where K is the key type derived off a lambda Function<T,K> argument producing the key for each emission.
     *
     * Note that if I have a key that maps to multiple emissions, the last emission for that key is going to replace subsequent ones.
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(s -> s.charAt(0))
                .subscribe(s -> System.out.println("Received: " + s));

        /**
         * If we wanted to yield a different value other than the emission to associate with the key, we
         can provide a second lambda argument that maps each emission to a different value.
         */
        System.out.println("---------------------------------------------");
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(s -> s.charAt(0), String::length)
                .subscribe(s -> System.out.println("Received: " + s));

        /**
         * Note that if I have a key that maps to multiple emissions, the last emission for that key is going to replace subsequent ones.
         */
        System.out.println("---------------------------------------------");
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(String::length)
                .subscribe(s -> System.out.println("Received: " + s));

    }
}
