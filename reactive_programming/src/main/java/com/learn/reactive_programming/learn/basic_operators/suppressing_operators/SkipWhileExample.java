package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

public class SkipWhileExample {
    /**
     * It will keep skipping emissions while they qualify with a condition. The moment that condition no longer
     * qualifies, the emissions will start going through.
     */
    public static void main(String[] args) {
        Observable.range(1,100)
                .skipWhile(i -> i <= 95)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
