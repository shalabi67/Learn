package com.learn.reactive_programming.learn.observable;

import io.reactivex.Observable;

public class DeferObservable {
    private static int start = 1;
    private static int count = 5;
    public static void main(String[] args) {
        /**
         * this example shows if we change the count state this change will not reflect second count
         */
        System.out.println("change count will not effect observe 2");
        Observable<Integer> source = Observable.range(start,count);

        source.subscribe(i -> System.out.println("Observer 1: " + i));

        //modify count
        System.out.println("modify count from 5 to 10. but nothing will change");
        count = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));

        /**
         * to be able to reflect change we use defer.
         */
        System.out.println("using defer will reflect state change to observer 2");
        Observable<Integer> source1 = Observable.defer(() ->
                Observable.range(start,count));
        source1.subscribe(i -> System.out.println("Observer 1: " + i));
        //modify count
        System.out.println("modify count from 5 to 10. and we will see tha change");
        count = 10;
        source1.subscribe(i -> System.out.println("Observer 2: " + i));
    }
}
