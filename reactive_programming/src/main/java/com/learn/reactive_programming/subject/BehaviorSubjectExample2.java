package com.learn.reactive_programming.subject;

import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectExample2 {

    public static void main(String[] args) {
        // Create an BehaviorSubject using its factory method
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("Start State");

        // We want to subscribe to this subject
        subject.subscribe(
                (letter) -> {
                    System.out.println(letter);
                }
        );
        subject.subscribe(
                (letter) -> {
                    System.out.println("Second Subscriber: " + letter);
                });


        // Next we create an observable out of the greek alphabet...
        Observable.fromIterable(DataGenerator.generateGreekAlphabet())
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
                            System.out.println( "onCompleted" );
                            subject.onComplete();
                        });

        // Note that we see every event on both subscribers.  Subjects are 
        // an easy way to "multicast" events to multiple subscribers.
        // A Subject is both an Observable and a Subscriber at the same time.
        
        System.exit(0);
    }
}
