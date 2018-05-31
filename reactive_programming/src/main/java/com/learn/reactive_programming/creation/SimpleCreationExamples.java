package com.learn.reactive_programming.creation;


import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;


public class SimpleCreationExamples {

    public static void main(String[] args) {
        Observable<Integer> observable = null;

        System.out.println("---------------------------------------------");
        System.out.println("Observable creation from a single value");
        System.out.println("---------------------------------------------");
        observable = Observable.just(Integer.valueOf(42));
        observable.subscribe((i) -> {
            System.out.println(i);
        });

        System.out.println("---------------------------------------------");
        System.out.println("Observable creation from an Iterable");
        System.out.println("---------------------------------------------");
        observable = Observable.fromIterable(DataGenerator.generateFibonacciList());
        observable.subscribe((i) -> {
            System.out.println(i);
        });

        System.out.println("---------------------------------------------");
        System.out.println("Observable creation from an Array");
        System.out.println("---------------------------------------------");
        observable = Observable.fromArray(DataGenerator.generateFibonacciArray());
        observable.subscribe((i) -> {
            System.out.println(i);
        });

        System.exit(0);
    }
}
