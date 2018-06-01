package com.learn.reactive_programming.subject;

import com.learn.reactive_programming.util.DataGenerator;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class BehaviorSubjectExample {

    public static void main(String[] args) {
        // Create an BehaviorSubject using its factory method
        BehaviorSubject<String> subject = BehaviorSubject.createDefault("Start State");

        // We want to subscribe to this subject
        subject.subscribe(
                (letter) -> {
                    System.out.println(letter);
                }
        );

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

        // Note that we see every event including the start (default) event.
        // BehaviorState is useful for ensuring that a subject always has 
        // a state.
        
        // A second subscriber will see the current event, plus any subsequent
        // events.  In this case, since the subject has reached the completed
        // state, then that is the state that the second subscriber sees.
        subject.subscribe(
                (letter) -> {
                    System.out.println("Second Subscriber: " + letter);
                },
                (t) -> {
                    subject.onError(t);
                },
                () -> {
                    System.out.println( "Second Subscriber: onCompleted" );
                });

        System.exit(0);
    }
}
