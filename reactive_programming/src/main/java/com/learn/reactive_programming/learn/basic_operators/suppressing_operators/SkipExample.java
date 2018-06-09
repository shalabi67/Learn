package com.learn.reactive_programming.learn.basic_operators.suppressing_operators;

import io.reactivex.Observable;

public class SkipExample {
    public static void main(String[] args) {
        /**
         * It will ignore the specified number of emissions and then emit the ones that follow.
         */
        Observable.range(1,100)
                .skip(90)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
