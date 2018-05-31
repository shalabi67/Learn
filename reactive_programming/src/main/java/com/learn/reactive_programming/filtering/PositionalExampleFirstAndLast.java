package com.learn.reactive_programming.filtering;

import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;

public class PositionalExampleFirstAndLast {

    public static void main(String[] args) {

        // Emit the greek alphabet, but only the first letter
        // Alpha
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .first("empty list")
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.out.println();

        // Emit the greek alphabet, but only the first 4
        // Alpha, Beta, Gamma, Delta
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .take(4)
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.out.println();

        // Emit the greek alphabet, but only the last letter
        // Omega
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .last("empty list")
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.out.println();

        // Emit the greek alphabet, but this time only the last 4
        // Phi, Chi, Psi, Omeaga
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .takeLast(4)
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.out.println();

        // firstOrDefault and lastOrDefault allows you to handle the case where there is 
        // an empty list.
        Observable.empty()
                .first("List is empty!")
                .subscribe((letter) -> {
                    System.out.println(letter);
                });
        Observable.empty()
                .last("List is empty!")
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.exit(0);
    }
}
