package com.learn.reactive_programming.learn.basic_operators.transforming_operators;

import io.reactivex.Observable;

public class StartWithExample {
    /**
     * allows you to insert a T emission that precedes all the other emissions.
     */
    public static void main(String[] args) {
        Observable<String> menu =
                Observable.just("Coffee", "Tea", "Espresso", "Latte");

        //print menu
        menu.startWith("COFFEE SHOP MENU")
                .subscribe(System.out::println);
    }
}
