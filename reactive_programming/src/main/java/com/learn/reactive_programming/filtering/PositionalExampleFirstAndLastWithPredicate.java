package com.learn.reactive_programming.filtering;

import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;

public class PositionalExampleFirstAndLastWithPredicate {
    
    public static void main(String[] args) {

        // Emit the greek alphabet, but only the first letter
        // that matches our predicate
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .filter((letter) -> { return letter.equals( "Beta" ); })
                .first( "EMPTY" )
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.out.println();

        // Emit the greek alphabet, but only the last letter
        // that matches our predicate
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                .filter((letter) -> { return letter.equals( "Gamma" ); } )
                .last( "EMPTY")
                .subscribe((letter) -> {
                    System.out.println(letter);
                });

        System.out.println();

        
        System.exit(0);
    }
}
