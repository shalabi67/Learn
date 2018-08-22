package com.learn.reactive_programming.learn.combining_observables;

import io.reactivex.Observable;

public class ConcatenationExample {
    /**
     * Concatenation is remarkably similar to merging, but with an important nuance:
     * it will fire elements of each provided Observable sequentially and in the order specified. It will not
     * move on to the next Observable until the current one calls onComplete(). This makes it great to ensure that
     * merged Observables fire their emissions in a guaranteed order. However, it is often a poor choice for
     * infinite Observables, as an infinite Observable will indefinitely hold up the queue and forever leave subsequent Observables waiting.
     *
     * You should prefer concatenation when you want to guarantee that Observables fire their emissions in order.
     * If you do not care about ordering, prefer merging instead.
     */
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<String> source2 =
                Observable.just("Zeta", "Eta", "Theta");
        Observable.concat(source1, source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        System.out.println("-----------------------------------------------");
        source1.concatWith(source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        System.out.println("-----------------------------------------------");
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
    }

}
