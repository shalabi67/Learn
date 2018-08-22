package com.learn.reactive_programming.learn.basic_operators.reducing_operators;

import io.reactivex.Observable;

import java.time.LocalDate;

public class AnyExample {
    /**
     * The any() method will check whether at least one emission meets a specific criterion and return a Single<Boolean>.
     * The moment it finds an emission that qualifies, it will emit true and then call onComplete().
     * If it processes all emissions and finds that they all are false, it will emit false and call onComplete().
     */
    public static void main(String[] args) {
        Observable.just("2016-01-01", "2016-05-02", "2016-09-12",
                "2016-04-03")
                .map(LocalDate::parse)
                .any(dt -> dt.getMonthValue() >= 6)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
