package com.learn.reactive_programming.learn.Challenges;

import io.reactivex.Observable;

public class Example1 {
    /**
     * Say you added Google Guava as a dependency (h t t p s ://g i t h u b . c o m /g o o g l e /g u a v a ) and
     you want to collect emissions into an ImmutableList. To create an ImmutableList , you
     have to call its builder() factory to yield an ImmutableList.Builder<T>. You then call
     its add() method to put items in the builder, followed by a call to build(), which returns a
     sealed, final ImmutableList<T> that cannot be modified.
     */


    /**
     * solution:

    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .collect(ImmutableList::builder,
                        ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(s -> System.out.println("Received: " + s));
    }
     */
}
