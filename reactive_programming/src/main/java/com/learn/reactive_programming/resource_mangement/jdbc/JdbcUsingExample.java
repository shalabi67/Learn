package com.learn.reactive_programming.resource_mangement.jdbc;

import com.learn.reactive_programming.util.ThreadUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.util.concurrent.Callable;

public class JdbcUsingExample {

    public static void main(String[] arg) {

        // Create a simple error handler that will emit the stack trace for a given exception
        Consumer<Throwable> simpleErrorHandler = (t) -> {
            t.printStackTrace();
        };

        // Initialize the test Derby database...this also resets its contents
        TestDatabase.init();

        // Resource Factory function to create a TestDatabase connection and wrap it
        // in a ConnectionSubscription
        Callable<ConnectionSubscription> resourceFactory = () -> {
            return new ConnectionSubscription(TestDatabase.createConnection());
        };

        // Observable Factory function to create the resultset that we want.
        Function<ConnectionSubscription, Observable<String>> greekAlphabetList = (connectionSubscription) -> {
            return TestDatabase.selectGreekAlphabet(connectionSubscription);
        };

        //disposer which will dispose the resource
        Consumer<ConnectionSubscription> disposer = (connectionSubscription) -> connectionSubscription.cancel();

        Observable<String> t = Observable.using(resourceFactory, greekAlphabetList, disposer);
        t.subscribe(
                (letter) -> {
                    System.out.println(ThreadUtils.currentThreadName() + " - " + letter);
                },
                simpleErrorHandler,
                () -> {
                    System.out.println( "onCompleted" );
                }
        );

        System.exit(0);
    }
}
