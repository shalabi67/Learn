package com.learn.reactive_programming.learn.flowables;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class CreatingFlowableExample1 {
    public static void main(String[] args) {
        Flowable<Integer> source = Flowable.create(emitter -> {
            for (int i=0; i<=100000000; i++) {
                if (emitter.isCancelled())
                    return;
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER);


        source.observeOn(Schedulers.computation())
                .subscribe( a -> {
                    sleep(100);
                    System.out.println(Thread.currentThread().getName() + " :: " + a);
                });
        sleep(100000);
    }
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
