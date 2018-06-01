package com.learn.reactive_programming.examples.event_driven.userservice;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

public interface UserService {

    void addUser(String username, String emailAddress);

    void subscribeToUserEvents(Observer<UserEvent> subscriber);
    void subscribeToUserEvents(Consumer<UserEvent> onNext);
}
