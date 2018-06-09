package com.learn.reactive_programming.learn.combining_observables;

import io.reactivex.Observable;

public class ZippingExample {
    /**
     * Zipping allows you to take an emission from each Observable source and combine it into a single emission.
     * Each Observable can emit a different type, but you can combine these different emitted types into a single emission.
     *
     * If one Observable calls onComplete() and the other still has emissions waiting to get paired,
     * those emissions will simply drop, since they have nothing to couple with.
     *
     * Note that if one or more sources are producing emissions faster than another, zip() will queue up those
     * rapid emissions as they wait on the slower source to provide emissions.
     * This could cause undesirable performance issues as each source queues in memory.
     */
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<Integer> source2 = Observable.range(1,6);
        Observable.zip(source1, source2, (s, i) -> s + "-" + i)
                .subscribe(System.out::println);
    }
}
