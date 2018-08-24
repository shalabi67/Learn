package com.learn.reactive_programming.examples.dataaccess.server.dto;

public class CustomerZipAccumulator {

    private Customer customer;

    public void addAddress(Address a) {
        customer.addAddress(a);
    }

    public void addOwnedProduct(OwnedProduct p) {
        customer.addOwnedProduct(p);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Customer collapseCustomerEvents(Object[] events) {

        for (Object event : events) {

            CustomerRelatedData nextData = (CustomerRelatedData) event;
            if (nextData instanceof Customer) {
                customer = (Customer) nextData;
            }
            if (nextData instanceof Address) {
                customer.addAddress((Address) nextData);
            } else if (nextData instanceof OwnedProduct) {
                customer.addOwnedProduct((OwnedProduct) nextData);
            }
        }

        return customer;
    }
}
