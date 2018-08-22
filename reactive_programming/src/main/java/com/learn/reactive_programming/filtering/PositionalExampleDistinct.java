package com.learn.reactive_programming.filtering;

import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;

public class PositionalExampleDistinct {
    
    public static void main(String[] args) {

        Observable.fromIterable(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
                .subscribe((letter) -> {
                    System.out.println(letter);
                });
        
        System.out.println("------------------------------------------------------------");
        
        // Emit each string value only once, even if it appears in the 
        // original list multiple times.
        Observable.fromIterable(DataGenerator.generateScrambledAndDuppedGreekAlphabet())
                .distinct()
                .subscribe((letter) -> {
                    System.out.println(letter);
                });
        
        System.out.println("------------------------------------------------------------");
        
        System.exit(0);
    }
}
