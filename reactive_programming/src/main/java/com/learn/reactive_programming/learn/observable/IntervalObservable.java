package com.learn.reactive_programming.learn.observable;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class IntervalObservable {
    public static void main(String[]args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s + " Mississippi"));
        sleep(5000);
    }
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
