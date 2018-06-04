package com.learn.reactive_programming.learn.subscribe;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class UsingLambdaVariables {
    public static void main(String[] args) {
        Consumer<String> onNext = i -> System.out.println("RECEIVED: "
                + i);

        Consumer<Throwable> onError = Throwable::printStackTrace;

        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");

        Action onComplete = () -> System.out.println("Done!");

        Consumer<Disposable> onSubscribe = disposable -> {};

        source
                .subscribe(onNext, onError, onComplete, onSubscribe);
    }
}
