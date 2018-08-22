package com.learn.reactive_programming.learn.observable;

import io.reactivex.Observable;

public class CallableObserver {
    public static void main(String[] args) {
        /**
         *this will throw an exception before the subscriber method and the onError will not execute because of the exception
         * this is why we but it in try catch
         */
        try {
            Observable.just(1 / 0)
                    .subscribe(i -> System.out.println("RECEIVED: " + i),
                            e -> System.out.println("Error was not supposed to be Captured: " + e));
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

        /**
         * to overcome this we use callable
         */
        Observable.fromCallable(() -> 1 / 0)
                .subscribe(i -> System.out.println("Received: " + i),
                        e -> System.out.println("Error Captured: " + e));
    }
}
