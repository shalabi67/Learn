package com.learn.reactive_programming.learn.multicasting_replaying_caching;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

import static com.learn.reactive_programming.learn.combining_observables.AmbiguousExample.sleep;

public class RefCountExample {
    /**
     * The refCount() operator on ConnectableObservable is similar to autoConnect(1), which fires after getting one subscription.
     * But there is one important difference; when it has no Observers anymore, it will dispose of itself and
     * start over when a new one comes in. It does not persist the subscription to the source when it has no more Observers,
     * and when another Observer follows, it will essentially "start over".
     */
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        .refCount();
        /**
         * Look at this example: we have Observable.interval() emitting every second, and it is
         multicast with refCount(). Observer 1 takes five emissions, and Observer 2 takes
         two emissions. We stagger their subscriptions with our sleep() function to put three second
         gaps between them. Because these two subscriptions are finite due to the take()
         operators, they should be terminated by the time Observer 3 comes in, and there should
         no longer be any previous Observers. Note how Observer 3 has started over with a fresh
         set of intervals starting at 0! Let's take a look at the following code snippet
         */

        //Observer 1
        seconds
                .take(5)
                .subscribe(l -> System.out.println("Observer 1: " +
                        l));
        sleep(3000);

        //Observer 2
        seconds
                .take(2)
                .subscribe(l -> System.out.println("Observer 2: " +
                        l));
        sleep(3000);

        //there should be no more Observers at this point
        //Observer 3
        seconds.subscribe(l -> System.out.println("Observer 3: " + l));
        sleep(3000);
    }

}
