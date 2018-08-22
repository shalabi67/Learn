package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

public class TakeWhileExample {
    /**
     * keep taking emissions while emissions are less than 5. The moment it encounters one that is not,
     * it will call the onComplete()
     */
    public static void main(String[] args) {
        Observable.range(1,100)
                .takeWhile(i -> i < 5)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
