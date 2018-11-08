package com.learn.reactive_programming.examples.dataaccess.service;

import com.learn.reactive_programming.examples.dataaccess.server.TestDatabaseProcedures;
import com.learn.reactive_programming.examples.dataaccess.server.dto.Address;
import com.learn.reactive_programming.examples.dataaccess.server.dto.Customer;
import java.sql.SQLException;

import com.learn.reactive_programming.examples.dataaccess.server.dto.CustomerRelatedData;
import com.learn.reactive_programming.examples.dataaccess.server.dto.CustomerZipAccumulator;
import com.learn.reactive_programming.examples.dataaccess.server.dto.OwnedProduct;
import io.reactivex.Observable;

public class CustomerService {

    // Create the other services that we will need.
    private final TestDatabaseProcedures procedures = new TestDatabaseProcedures();
    private final AddressService addressService = new AddressService();
    private final ProductService productService = new ProductService();

    public CustomerService() {

    }

    public Observable<Customer> fetchCustomer(long customerId) {
        try {
            return procedures.toSelectCustomersObservable(customerId);
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    public Observable<Customer> fetchCustomerWithAddressesAndOwnedProducts(long customerId) {
        Observable<Customer> selectedCustomerObservable = fetchCustomer(customerId);
        Observable<Address> selectedAddressesObservable = addressService.fetchCustomerAddresses(customerId);
        Observable<OwnedProduct> selectedProductsObservable = productService.fetchOwnedProducts(customerId);

        // Combine the three stream of events
        Observable<CustomerRelatedData> dataStream = Observable.concat(
                selectedCustomerObservable, 
                selectedAddressesObservable, 
                selectedProductsObservable);

        // Wrap the concat'ed dataStream in another observable.  This makes it an 
        // Observable< Observable< CustomerRelatedData> > which is the shape we need
        // for the zip function that follows.
        Observable<Observable<CustomerRelatedData>> wrappedDataStream = Observable.just(dataStream);
                
        // Create an accumulation object so that we can use "zip" to collapse items into a single unified Customer instance.
        CustomerZipAccumulator accum = new CustomerZipAccumulator();
        
        // Collapse the customer related data (Customer and Addresses) into a single customer with combined data.
        Observable<Customer> finalObservable = Observable
                .zip(wrappedDataStream, accum::collapseCustomerEvents)
                .takeLast(1);

        return finalObservable;
    }

}
