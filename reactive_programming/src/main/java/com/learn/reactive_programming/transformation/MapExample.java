package com.learn.reactive_programming.transformation;

import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;

public class MapExample {

    public static void main(String[] args) {

        // Simple map example...transform every greek letter string
        // into upper case.
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .map((letterString) -> {
                    return letterString.toUpperCase();
                })
                .subscribe((letterString) -> {
                    System.out.println(letterString);
                });

        System.out.println("--------------------------------------------------");

        // flatMap -> Each greek letter is emitted as all upper and 
        // all lower case...doubling the output.  One item in the origin
        // list generates multiple items.
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .flatMap((letterString) -> {

                    String[] returnStrings = {letterString.toUpperCase(),
                        letterString.toLowerCase()
                    };

                    return Observable.fromArray(returnStrings);
                })
                .subscribe((letterString) -> {
                    System.out.println(letterString);
                });

        System.exit(0);
    }
}
