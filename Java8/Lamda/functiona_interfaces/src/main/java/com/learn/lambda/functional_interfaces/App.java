package com.learn.lambda.functional_interfaces;


import com.learn.lambda.functional_interfaces.chaining_and_with_predicate.ChainingExample;
import com.learn.lambda.functional_interfaces.consumers.ConsumerExample;
import com.learn.lambda.functional_interfaces.functions.FunctionExample;
import com.learn.lambda.functional_interfaces.predicate.PredicateExample;
import com.learn.lambda.functional_interfaces.suppliers.SupplierExample;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        ConsumerExample.demo();
        SupplierExample.demo();
        FunctionExample.demo();
        PredicateExample.demo();
        ChainingExample.demo();
    }
}
