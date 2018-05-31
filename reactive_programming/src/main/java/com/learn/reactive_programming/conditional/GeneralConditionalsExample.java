package com.learn.reactive_programming.conditional;


import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;

public class GeneralConditionalsExample {

    public static void main(String[] args) {

        // defaultIfEmpty example - We create an empty observable
        // and then apply "defaultIfEmpty" and set the default to "Hello World".
        // Since the observable is empty, "Hello World" will be emitted as 
        // the only event.
        Observable.empty()
                .defaultIfEmpty("Hello World")
                .subscribe((s) -> {
                    System.out.println(s);
                });

        System.out.println();

        // defaultIfEmpty example  2 - We create an non-empty observable
        // and then apply "defaultIfEmpty" and set the default to "Hello World".
        // Since the observable is not empty, the list items will be emitted.
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .defaultIfEmpty("Hello World")
                .first("EMPTY") // we just want to show that it isn't Hello World...
                .subscribe((s) -> {
                    System.out.println(s);
                });

        System.out.println();

        Observable.fromIterable(DataGenerator.generateFibonacciList())
                .skipWhile((i) -> {
                    return i < 8;
                })
                .subscribe((i) -> {
                    System.out.println(i);
                });

        System.out.println();

        Observable.fromIterable(DataGenerator.generateFibonacciList())
                .takeWhile((i) -> {
                    return i < 8;
                })
                .subscribe((i) -> {
                    System.out.println(i);
                });

        System.out.println();

        /*
        Observable.fromIterable(DataGenerator.generateFibonacciList())
                .take((i , index) -> {
                    return index < 3;
                })
                .subscribe((i) -> {
                    System.out.println(i);
                });*/

        System.out.println();

        System.exit(0);

    }

}
