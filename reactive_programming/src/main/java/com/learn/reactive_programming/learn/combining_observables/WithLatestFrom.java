package com.learn.reactive_programming.learn.combining_observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static com.learn.reactive_programming.learn.combining_observables.AmbiguousExample.sleep;

public class WithLatestFrom {
    /**
     * Similar to Observable.combineLatest(), but not exactly the same, is the withLatestfrom() operator.
     * It will map each T emission with the latest values from other Observables and combine them,
     * but it will only take one emission from each of the other Observables
     */
    public static void main(String[] args) {
        Observable<Long> source1 =
                Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 =
                Observable.interval(1, TimeUnit.SECONDS);
        source2.withLatestFrom(source1,
                (l1,l2) -> "SOURCE 2: " + l1 + " SOURCE 1: " + l2
        ) .subscribe(System.out::println);
        sleep(3000);
    }
}
