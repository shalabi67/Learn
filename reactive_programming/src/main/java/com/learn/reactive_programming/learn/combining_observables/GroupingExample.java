package com.learn.reactive_programming.learn.combining_observables;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class GroupingExample {
    /**
     * A powerful operation that you can achieve with RxJava is to group emissions by a specified key into separate Observables. This can be achieved by calling the groupBy() operator,
     which accepts a lambda mapping each emission to a key. It will then return an
     Observable<GroupedObservable<K,T>>, which emits a special type of Observable
     called GroupedObservable. GroupedObservable<K,T> is just like any other
     Observable, but it has the key K value accessible as a property. It will emit the T emissions
     that are mapped for that given key.
     */
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(s -> s.length());
        byLengths.flatMapSingle(grp -> grp.toList())
                .subscribe(System.out::println);

        byLengths.flatMapSingle(grp ->
                grp.reduce("",(x,y) -> x.equals("") ? y : x + ", " + y)
                        .map(s -> grp.getKey() + ": " + s)
        ).subscribe(System.out::println);
    }
}
