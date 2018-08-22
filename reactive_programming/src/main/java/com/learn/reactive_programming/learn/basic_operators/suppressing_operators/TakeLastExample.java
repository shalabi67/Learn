package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

public class TakeLastExample {
    public static void main(String[] args) {
        /**
         * take the last specified number of emissions and then call onComplete().
         * Just keep in mind that it will internally queue emissions until its onComplete() function is called,
         * and then it can logically identify and emit the last emissions.
         */
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .takeLast(3)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
