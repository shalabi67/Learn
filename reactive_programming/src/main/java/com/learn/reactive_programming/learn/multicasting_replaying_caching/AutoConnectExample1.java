package com.learn.reactive_programming.learn.multicasting_replaying_caching;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class AutoConnectExample1 {
    /**
     * Multicasting  happened by calling publish
     * will automatically call connect() after a specified number of Observers are subscribed.
     */
    public static void main(String[] args) {
        Observable<Integer> threeRandoms = Observable.range(1,3)
                .map(i -> randomInt())
                .publish()
                .autoConnect(2);
        //Observer 1 - print each random integer
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        //Observer 2 - sum the random integers, then print
        threeRandoms.reduce(0, (total,next) -> total + next)
                .subscribe(i -> System.out.println("Observer 2: " + i));
    }
    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
