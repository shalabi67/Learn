package com.learn.reactive_programming.comosition;

import com.learn.reactive_programming.util.ThreadUtils;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.io.Console;

/*
we will fetch a list of users from a factious "UserService". The UserService will return a list of users that we will
wrap in an Observable. Next, we will want to eliminate all the administrative users from the list. This is something
you can do in parallel, so we will add a parallel operation and instruct RxJava to use the computational scheduler to
pull it off. We will add the filter operation within the parallel operations wrapper. Next, we will sort the users
based on their security level; lowest to highest. And finally, we will emit a chunk of JSON that will contain the
details for each of the returned users.
 */
public class CompositionExample {

    public static void main(String[] args) {
        UserService userService = new UserService();

        // Create and sync on an object that we will use to make sure we don't
        // hit the System.exit(0) call before our threads have had a chance
        // to complete.
        Object waitMonitor = new Object();
        synchronized (waitMonitor) {

            System.out.println("Solution Two");

            // Write out a little snippet to make the json look nice...just as an example
            System.out.println("{ \"userList\" : [ ");
            solutionTwo(waitMonitor, userService);

            ThreadUtils.wait(waitMonitor);
            System.out.println("] }");
        }

        waitMonitor = new Object();
        synchronized (waitMonitor) {
            System.out.println("Solution One");
            System.out.println( "{ \"userList\" : [ " );
            // Call the user service and fetch a list of users.
            solutionOne(waitMonitor, userService);

            // Wait until the onCompleted method wakes us up.
            ThreadUtils.wait(waitMonitor);
            
            // Close the json
            System.out.println( "] }" );
        }
        System.exit(0);
    }

    private static void solutionTwo(Object waitMonitor, UserService userService) {
        Flowable.fromIterable(userService.fetchUserList())
				.parallel()
				.runOn(Schedulers.computation())
				.filter((user) -> {
					System.out.println("Thread: " + Thread.currentThread().getName());
					return user.getSecurityStatus() != UserSecurityStatus.ADMINISTRATOR;
				})
				.sequential()
				// Sort the remaining users by security status.
				.toSortedList((user1, user2) -> {
					return user1.getSecurityStatus().compareTo(user2.getSecurityStatus());
				})
				// Make the observable run on the io scheduler since the userservice
				// might have to go over the wire (it doesn't in this example)
				.subscribeOn(Schedulers.io())
                .doFinally(() -> {
                    // Since we have completed...we sync on the waitMonitor
                    // and then call notify to wake up the "main" thread.
                    synchronized (waitMonitor) {
                        waitMonitor.notify();
                    }
                })
				.subscribe(
						// onNext function - receives a sorted list of users
						// due to the "toSortedList" operation
						(userList) -> {
							userList.forEach((user) -> {
								System.out.println( user.toJSON() );
							});
						}
				);
    }

    private static void solutionOne(Object waitMonitor, UserService userService) {
        Observable.fromIterable(userService.fetchUserList())
				// Go through the events asynchronously and eliminate administrators.
				.flatMap((userObservable) ->
						Observable
						.just(userObservable)
						.subscribeOn(Schedulers.io())
						.filter((user) -> {
							System.out.println("Thread: " + Thread.currentThread().getName());
							return user.getSecurityStatus() != UserSecurityStatus.ADMINISTRATOR;
						})
				)
				// Sort the remaining users by security status.
				.toSortedList((user1, user2) -> {
					return user1.getSecurityStatus().compareTo(user2.getSecurityStatus());
				})
				// Make the observable run on the io scheduler since the userservice
				// might have to go over the wire (it doesn't in this example)
				.subscribeOn(Schedulers.io())
				.doFinally(() -> {
					// Since we have completed...we sync on the waitMonitor
					// and then call notify to wake up the "main" thread.
					synchronized (waitMonitor) {
						waitMonitor.notify();
					}
				})
				.subscribe(
						// onNext function - receives a sorted list of users
						// due to the "toSortedList" operation
						(userList) -> {
							userList.forEach((user) -> {
								System.out.println( user.toJSON() );
							});
						}
				);
    }
}
