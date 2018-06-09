package com.learn.reactive_programming.learn.basic_operators.transforming_operators;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static com.learn.reactive_programming.learn.disposable.DisposableUsingObserver.sleep;

public class DelayExample {
    /**
     * We can postpone emissions using the delay() operator.
     * It will hold any received emissions and delay each one for the specified time period.
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma" ,"Delta",
                "Epsilon")
                .delay(3, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println("Received: " + s));
        sleep(5000);
    }
}
