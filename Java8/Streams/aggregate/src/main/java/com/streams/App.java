package com.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

/**
 * Created by mohammad on 11/29/2016.
 */
public class App {

    public static void main( String[] args ) {
        sumOfCalories();
        minimumValue();
        get2011TransactionsSorted();

        traderCities();
        tradersFromCambridge();
        traderNames();
        anyTradersInMilan();
        traderLivingInCambridge();
    }
    private static void sumOfCalories() {
        List<Dish> list = Dish.createDishes();
        long sum = list.stream()
                    .map(Dish::getCalories)
                    .reduce(0, (a,b) -> a + b);
        System.out.println("Calories sum = " + sum);
    }

    private static void minimumValue() {
        Integer[] arr = {1,2,3,48,9,4,4,70,30};
        Optional<Integer> min = Stream.of(arr)
                    .reduce(Integer::min);
        System.out.println("minimum value  = " + min.get());
    }

    //Find all transactions in the year 2011 and sort them by value (small to high).
    private static  void get2011TransactionsSorted() {
        List<Transaction> transactions = Transaction.create().stream()
                .filter(t->t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());

        transactions.forEach(System.out::println);
    }

    //What are all the unique cities where the traders work?
    private static void traderCities() {
        List<String> transactions = Transaction.create().stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        transactions.forEach(System.out::println);
    }

    //Find all traders from Cambridge and sort them by name.
    private static void tradersFromCambridge() {
        List<Trader> transactions = Transaction.create().stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .collect(Collectors.toList());

        transactions.forEach(System.out::println);
    }

    //Return a string of all traders’ names sorted alphabetically.
    private static void traderNames() {
        String names = Transaction.create().stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(","));

        System.out.println("traders  = " +names);
    }


    //Are any traders based in Milan?
    private static void anyTradersInMilan() {
        if(Transaction.create().stream()
                .anyMatch(t-> t.getTrader().getCity().equals("Milan"))
                ) {
            System.out.println("traders in Milan");
        }
    }


    //Print all transactions’ values from the traders living in Cambridge.
    private static void traderLivingInCambridge() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Print all transactions’ values from the traders living in Cambridge.");
        List<Transaction> transactions = Transaction.create().stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .collect(Collectors.toList());

        transactions.forEach(System.out::println);
    }

    //What’s the highest value of all the transactions?


    //Find the transaction with the smallest value.

}
