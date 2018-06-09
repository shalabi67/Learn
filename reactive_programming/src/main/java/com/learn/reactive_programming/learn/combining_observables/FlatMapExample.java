package com.learn.reactive_programming.learn.combining_observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class FlatMapExample {
    /**
     * It is an operator that performs a dynamic Observable.merge() by taking each emission and mapping it to an Observable.
     * Then, it merges the emissions from the resulting Observables into a single stream.
     *
     * The simplest application of flatMap() is to map one emission to many emissions.
     */

    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.flatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);

        source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.flatMap(s -> Observable.fromArray(s.split("")),
                (s,r) ->
                        s + "-" + r)
                .subscribe(System.out::println);


        source =
                Observable.just("521934/2342/FOXTROT", "21962/12112/78886 /TANGO",
                        "283242/4542/WHISKEY/2348562");
        source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+")) //use regex to filter integers
                .map(Integer::valueOf)
                .subscribe(System.out::println);


        Observable<Integer> intervalArguments =
                Observable.just(2, 3, 10, 7);
        intervalArguments.flatMap(i ->
                Observable.interval(i, TimeUnit.SECONDS)
                        .map(i2 -> i + "s interval: " + ((i + 1) * i) + " seconds elapsed")
                        ).subscribe(System.out::println);
        sleep(12000);


    }
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
