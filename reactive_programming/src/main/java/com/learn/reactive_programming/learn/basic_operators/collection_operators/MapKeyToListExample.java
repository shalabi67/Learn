package com.learn.reactive_programming.learn.basic_operators.collection_operators;

import io.reactivex.Observable;

public class MapKeyToListExample {
    /**
     * If you want a given key to map to multiple emissions, you can use toMultiMap() instead, which will maintain
     * a list of corresponding values for each key.
     *
     * result map is Map<K, Lis<T>
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .toMultimap(String::length)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
