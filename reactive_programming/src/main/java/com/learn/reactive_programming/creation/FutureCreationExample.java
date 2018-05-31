package com.learn.reactive_programming.creation;


import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.FutureTask;


public class FutureCreationExample {

    public static void main(String[] args) {

        Observable<List<Integer>> observableFutureList;

        // Create a FutureTask that returns a List<Integer>
        FutureTask<List<Integer>> future = new FutureTask<>(() -> {
            return DataGenerator.generateFibonacciList();
        });
        
        // Construct an observable...note that this only creates the
        // observable wrapper around the future.  The future still needs 
        // to be executed using it's "run" method, or by scheduling it to 
        // execute.
        observableFutureList = Observable.fromFuture(future);

        // Schedule this future to run on the computation scheduler
        //computation has a thread per processor core.
        Schedulers.computation().scheduleDirect(() -> {
            future.run();   // Call the FutureTask's run method
        });

        // Subscribe to the list...when the list is ready through the 
        // future, iterate and print each element.
        observableFutureList.subscribe((list) -> {
            list.forEach((i) -> {
                System.out.println(i);
            });
        });

        System.exit(0);
    }
}
