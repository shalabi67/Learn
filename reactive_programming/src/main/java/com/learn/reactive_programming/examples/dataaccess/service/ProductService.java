package com.learn.reactive_programming.examples.dataaccess.service;


import java.sql.SQLException;

import com.learn.reactive_programming.examples.dataaccess.server.TestDatabaseProcedures;
import com.learn.reactive_programming.examples.dataaccess.server.dto.OwnedProduct;
import io.reactivex.Observable;

public class ProductService {

    private final TestDatabaseProcedures procedures = new TestDatabaseProcedures();

    public Observable<OwnedProduct> fetchOwnedProducts(long customerId) {
        try {
            return procedures.toSelectOwnedProductObservable(customerId);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }
}
