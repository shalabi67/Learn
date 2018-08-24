package com.learn.reactive_programming.examples.dataaccess.service;


import java.sql.SQLException;

import com.learn.reactive_programming.examples.dataaccess.server.TestDatabaseProcedures;
import com.learn.reactive_programming.examples.dataaccess.server.dto.Address;
import io.reactivex.Observable;

public class AddressService {

    private final TestDatabaseProcedures procedures = new TestDatabaseProcedures();

    public Observable<Address> fetchCustomerAddresses(long customerId) {
        try {
            return procedures.toSelectAddressObservable(customerId);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
