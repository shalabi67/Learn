package com.learn.reactive_programming.learn.combining_observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class CombineLatest {
    /**
     * The Observable.combineLatest() factory is somewhat similar to zip(), but for every emission that fires from
     * one of the sources, it will immediately couple up with the latest emission from every other source.
     * It will not queue up unpaired emissions for each source, but rather cache and pair the latest one.
     */
    public static void main(String[] args) {
        Observable<Long> source1 =
                Observable.interval(300, TimeUnit.MILLISECONDS);
        Observable<Long> source2 =
                Observable.interval(1, TimeUnit.SECONDS);
        Observable.combineLatest(source1, source2,
                (l1,l2) -> "SOURCE 1: " + l1 + " SOURCE 2: " + l2)
                .subscribe(System.out::println);
        sleep(3000);
    }
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
