package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class TakeWithTimeExample {
    /**
     * take emissions within a specific time duration and then call onComplete().
     */
    public static void main(String[] args) {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS)  //take emissions for two seconds.
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        sleep(5000);
    }
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
