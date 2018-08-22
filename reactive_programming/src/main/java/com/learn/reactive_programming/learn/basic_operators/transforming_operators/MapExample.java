package com.learn.reactive_programming.learn.basic_operators.transforming_operators;

import io.reactivex.Observable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MapExample {
    /**
     * will transform a T emission into an R emission using the provided Function<T,R> lambda.
     */
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
                Observable.just("1/3/2016", "5/9/2016", "10/12/2016")
                        .map(s -> LocalDate.parse(s, dtf))
                        .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
