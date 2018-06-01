package com.learn.reactive_programming.examples.event_driven.userservice;

public class CreateUserEvent extends UserEvent {

    public CreateUserEvent(String username, String emailAddress) {
        super(username, emailAddress);
    }
    
}
