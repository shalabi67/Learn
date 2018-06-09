package com.learn.reactive_programming.learn.multicasting_replaying_caching;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static com.learn.reactive_programming.learn.combining_observables.AmbiguousExample.sleep;

public class AutoConnectExample2 {
    /**
     * Multicasting  happened by calling publish
     * will automatically call connect() after a specified number of Observers are subscribed.
     *
     * autoconnect will persist the connection even after observers disposes
     */
    public static void main(String[] args) {
        Observable<Long> threeRandoms = Observable.interval(100, TimeUnit.MILLISECONDS)
                .publish()
                .autoConnect(2);
        //Observer 1 - print each random integer
        Disposable disposable1 = threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        //Observer 2 - sum the random integers, then print
        Disposable disposable2 = threeRandoms.subscribe(i -> System.out.println("Observer 2: " + i));

        //observer can subscribe and get data, but it will miss part of it.
        sleep(1000);
        threeRandoms.subscribe(i -> System.out.println("Observer 3: " + i));

        //let us get rid of first and second observers
        sleep(1000);
        disposable1.dispose();
        disposable2.dispose();

        sleep(1000);
    }
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
