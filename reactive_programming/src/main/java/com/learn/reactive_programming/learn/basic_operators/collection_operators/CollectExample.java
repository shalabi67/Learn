package com.learn.reactive_programming.learn.basic_operators.collection_operators;

import io.reactivex.Observable;

import java.util.HashSet;

public class CollectExample {
    /**
     * When none of the collection operators have what you need, you can always use the
     collect() operator to specify a different type to collect items into. For instance, there is no
     toSet() operator to collect emissions into a Set<T>, but you can quickly use collect()
     to effectively do this. You will need to specify two arguments that are built with lambda
     expressions: initialValueSupplier, which will provide a new HashSetfor a new
     Observer, and collector, which specifies how each emission is added to that HashSet:
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .collect(HashSet::new, HashSet::add)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
