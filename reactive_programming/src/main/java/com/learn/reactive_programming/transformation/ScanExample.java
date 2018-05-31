package com.learn.reactive_programming.transformation;

import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;

public class ScanExample {

    public static void main(String[] args) {

        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .scan(new StringBuilder(), (accumBuffer, nextLetter) -> {

                    return accumBuffer.append(nextLetter);
                })
                .subscribe((total) -> {
                    System.out.println("Scan Event: " + total.toString());
                });

        System.out.println("--------------------------------------------------");
       
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .scan(new StringBuilder(), (accumBuffer, nextLetter) -> {

                    return accumBuffer.append(nextLetter);
                })
                .last(new StringBuilder("ERROR"))
                .subscribe((total) -> {
                    System.out.println("Scan Event: " + total.toString());
                });

        System.out.println("--------------------------------------------------");

        System.exit(0);
    }
}
