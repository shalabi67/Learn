package com.learn.reactive_programming.subject;

import com.learn.reactive_programming.util.DataGenerator;
import com.learn.reactive_programming.util.ThreadUtils;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class PublishSubjectExample {

    public static void main(String[] args) {

        Object signal = new Object();
        synchronized (signal) {
            
            // PublishSubjects are good for multicasting events to subscribers.
            // The subscribers will see only the events that happen AFTER they
            // subscribe.
            // Create an PublishSubject using its factory method
            PublishSubject<String> subject = PublishSubject.create();

            // We want to subscribe to this subject
            subject.subscribe(
                    (letter) -> {
                        System.out.println("Subscriber 1: " + letter);
                        
                        ThreadUtils.sleep(500);
                        if( letter.equals( "Eta" ) ) {
                            synchronized(signal) {
                                signal.notify();
                            }
                        }
                    }
            );

            // Next we create an observable out of the greek alphabet...
            // For each letter, we will publish an event to the PublishSubject
            Observable.fromIterable(DataGenerator.generateGreekAlphabet())
                    .subscribeOn(Schedulers.computation())
                    .subscribe(
                            (letter) -> {
                                // ...for each letter, we will emit an event to the subject
                                subject.onNext(letter);
                            },
                            (t) -> {
                                subject.onError(t);
                            },
                            // ...once complete...we tell the subject
                            () -> {
                                System.out.println("Subscriber 1: onCompleted");
                                subject.onComplete();
                                synchronized( signal ) {
                                    signal.notify();
                                }
                            });

            ThreadUtils.wait(signal);

            subject.subscribe(
                    (letter) -> {
                        System.out.println("Subscriber 2: " + letter);
                    },
                    (t) -> {
                        subject.onError(t);
                    },
                    () -> {
                        System.out.println("Subscriber 2: onCompleted");
                    }
            );
            
            ThreadUtils.wait(signal);
        }
        System.exit(0);
    }
}
