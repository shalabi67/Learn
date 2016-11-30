package com.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mohammad on 11/29/2016.
 */
public class App {

    public static void main( String[] args ) {
        //streamCreation();

        //getVegetarianDishes();
        //getDishTypes();
        getFirstTwoMeatDishes();
    }
    private static void getVegetarianDishes() {
        List<Dish> dishes = Dish.createDishes();
        List<Dish> list = dishes.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    private static void getFirstTwoMeatDishes() {
        List<Dish> dishes = Dish.createDishes();
        List<Dish> list = dishes.stream()
                .filter(d -> d.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    private static void getDishTypes() {
        List<Dish> dishes = Dish.createDishes();
        List<Dish.Type> list = dishes.stream()
                .map(Dish::getType)
                .distinct()
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    public static void streamCreation() {

        //create an empty stream
        Stream<Dish> stream = Stream.empty();
        System.out.println("Stream.empty " + stream.count());


        //create using stream.of method.
        Stream<String> stringStream = Stream.of("first object", "second object");
        stringStream.forEach(System.out::println);


        //creating using an array
        String[] arr = {"arr first object", "arr second object"};
        stringStream = Stream.of(arr);
        stringStream.forEach(System.out::println);


        //create stream using collection.
        List<Dish> dishes = Dish.createDishes();
        Stream<Dish> listStream = dishes.stream();
        listStream.forEach(System.out::println);

        //create an infinite stream.
        // a- get a stream of random numbers
        Stream<Double> doubleStream = Stream.generate(Math::random);
        //doubleStream.forEach(System.out::println);

        //b- use an iterate
        Stream<Integer> integerStream = Stream.iterate(1, i -> i+1);
        integerStream.forEach(System.out::println);

    }
}
