package com.learn.reactive_programming.examples.event_driven.emailservice;

import java.util.List;

public interface EmailService {

    void sendEmail(List<String> recipientList, String fromEmail, String subject, String text);
    
}
