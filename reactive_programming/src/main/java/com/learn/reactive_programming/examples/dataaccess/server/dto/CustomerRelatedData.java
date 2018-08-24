package com.learn.reactive_programming.examples.dataaccess.server.dto;

public class CustomerRelatedData {

    private long customerId;

    public CustomerRelatedData() {
    }

    public CustomerRelatedData(long customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }
}
