package com.learn.reactive_programming.learn.disposable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class DisposableUsingObserver {
    public static void main(String[] args) {
        /**
         * in this example we will print 5 times
         */
        Observable<Long> source =
                Observable.interval(100, TimeUnit.MILLISECONDS);

        source.subscribe(myObserver);
        //capture Disposable
        //Disposable disposable = source.subscribeWith(myObserver);
        sleep(3000);

    }
    private static Observer<Long> myObserver = new Observer<Long>() {
            private Disposable disposable;
            private int count = 0;
            @Override
            public void onSubscribe(Disposable disposable) {
                this.disposable = disposable;
            }
            @Override
            public void onNext(Long value) {
                System.out.println(value);
                count++;
                if(count == 5) {
                    disposable.dispose();
                }
            }
            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }
            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
    };
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
