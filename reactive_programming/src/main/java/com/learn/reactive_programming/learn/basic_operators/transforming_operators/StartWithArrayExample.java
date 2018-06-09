package com.learn.reactive_programming.learn.basic_operators.transforming_operators;

import io.reactivex.Observable;

public class StartWithArrayExample {
    public static void main(String[] args) {
        Observable<String> menu =
                Observable.just("Coffee", "Tea", "Espresso", "Latte");

        //print menu
        menu.startWithArray("COFFEE SHOP MENU","----------------")
                .subscribe(System.out::println);
    }
}
