package com.learn.reactive_programming.learn.subscribe;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class UsingObservable {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");

        source
                .subscribe(observer);
    }

    private static Observer<String> observer = new Observer<String>() {
        @Override
        public void onSubscribe(Disposable d) {

        }

        @Override
        public void onNext(String s) {
            System.out.println("From Observer: " + s);
        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onComplete() {
            System.out.println("Event completed");
        }
    };
}
