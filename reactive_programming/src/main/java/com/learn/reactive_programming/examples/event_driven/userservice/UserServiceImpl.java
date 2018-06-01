package com.learn.reactive_programming.examples.event_driven.userservice;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;

public class UserServiceImpl implements UserService {

    private final PublishSubject<UserEvent> userEventSubject;

    public UserServiceImpl() {
        // Create a PublishSubject in order to publish events.
        userEventSubject = PublishSubject.create();
    }

    @Override
    public void addUser(String username, String emailAddress) {

        // Do something interesting that would add a user...
        System.out.println("UserServiceImpl: addUser - " + username + ", " + emailAddress);

        // Instantiate a CreateUserEvent
        UserEvent addUserEvent = new CreateUserEvent(username, emailAddress);

        // Publish the event to the userEventSubject
        userEventSubject.onNext(addUserEvent);

        // All done...all we did in this service is worry about creating a user.
    }

    @Override
    public void subscribeToUserEvents(Observer<UserEvent> subscriber) {
        userEventSubject.subscribe(subscriber);
    }

    @Override
    public void subscribeToUserEvents(Consumer<UserEvent> onNext) {
        userEventSubject.subscribe(onNext);
    }
}
