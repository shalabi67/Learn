package com.learn.reactive_programming.learn.observable;

import io.reactivex.Observable;

public class RangeObservable {
    public static void main(String[] args) {
        Observable.range(5,10)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
