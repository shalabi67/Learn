package com.learn.reactive_programming.creation;


import com.learn.reactive_programming.util.DataGenerator;
import com.learn.reactive_programming.util.ThreadUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;


public class ObserveOnParallelThreadExample {

    public static void main(String[] args) {

        // Create and sync on an object that we will use to make sure we don't
        // hit the System.exit(0) call before our threads have had a chance
        // to complete.
        Object waitMonitor = new Object();
        synchronized (waitMonitor) {

            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("Creating an Observable that does not specify a subscribeOn or an observeOn Scheduler");
            System.out.println("driving thread: " + ThreadUtils.currentThreadName());
            System.out.println("---------------------------------------------------------------------------------------");

            // Create a big list of integers...
            List<Integer> emitList = DataGenerator.generateBigIntegerList();

            // Wrap it in an observable...
            Observable<Integer> observable = Observable.fromIterable(emitList);

            // Dot chain
            observable
                    // We want the subscriber driving code on a new thread.
                    .subscribeOn(Schedulers.newThread())
                    // We want to run this code in parallel
                    .flatMap(a1 -> Observable
                            .just(a1)
                            .filter((i) -> {
                                return i % 2 == 0;
                            })
                            .subscribeOn(Schedulers.io())
                            .doOnNext((xx) -> {
                                System.out.println("parallel thread in: " + ThreadUtils.currentThreadName());
                                System.out.println("parallel: " + xx);
                                ThreadUtils.sleep(10); // Add a sleep to make sure we have a chance to see
                                // that the even number filter is executing in parallel.
                                System.out.println("parallel thread out: " + ThreadUtils.currentThreadName());
                            })
                    )
                    .subscribe(
                            // onNext function
                            (i) -> {
                                System.out.println("onNext thread entr: " + ThreadUtils.currentThreadName());
                                System.out.println(i);
                                System.out.println("onNext thread exit: " + ThreadUtils.currentThreadName());
                            },
                            // onError function
                            (t) -> {
                                t.printStackTrace();
                            },
                            // onCompleted
                            () -> {
                                System.out.println("onCompleted()");

                                // Since we have completed...we sync on the waitMonitor
                                // and then call notify to wake up the "main" thread.
                                synchronized (waitMonitor) {
                                    waitMonitor.notify();
                                }
                            }
                    );

            // Wait until the onCompleted method wakes us up.
            ThreadUtils.wait(waitMonitor);
        }

        System.exit(0);
    }
}
