package com.learn.reactive_programming.learn.multicasting_replaying_caching;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static com.learn.reactive_programming.learn.combining_observables.AmbiguousExample.sleep;

public class ReplayingExample2 {
    /**
     * The replay() operator is a powerful way to hold onto previous emissions within a certain scope and re-emit them
     * when a new Observer comes in. It will return a ConnectableObservable that will both multicast emissions as well as
     * emit previous emissions defined in a scope. Previous emissions it caches will fire immediately to a new Observer
     * so it is caught up, and then it will fire current emissions from that point forward.
     *
     * note that this can get expensive with memory, as replay() will keep caching all emissions it receives.
     *
     * Note that if you always want to persist the cached values in your replay()even if there are
     * no subscriptions, use it in conjunction with autoConnect(), not refCount().
     */
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma",
                        "Delta", "Epsilon")
                        .replay(1)
                        .autoConnect();
        //Observer 1
        source.subscribe(l -> System.out.println("Observer 1: " +
                l));
        //Observer 2
        source.subscribe(l -> System.out.println("Observer 2: " +
                l));


        System.out.println("----------------------------");
        source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                        .replay(1)
                        .refCount();

        //Observer 1
        source.subscribe(l -> System.out.println("Observer 1: " +
                l));
        //Observer 2
        source.subscribe(l -> System.out.println("Observer 2: " +
                l));
    }
}
