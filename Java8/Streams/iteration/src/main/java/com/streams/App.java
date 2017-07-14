package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mohammad on 11/29/2016.
 */
public class App {

    public static void main( String[] args ) {
        //returnCollection();
        //getDishNamesLetterCount();
        //getDishNamesUniqueLetters();
        //getSquare();
        //getPair();
        getDivBy3Pair();

    }

    private static void returnCollection() {
        List<Dish> list = Dish.createDishes();

        //return a list of dish names
        List<String>  names = list.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
        printStream(names.stream());

    }

    //how could you return a list of all the unique characters for a list of words?
    private static void getDishNamesUniqueLetters() {
        List<Dish> dishes = Dish.createDishes();
        List<String> list = dishes.stream()
                .map(d -> d.getName().split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    //Given two lists of numbers, how would you return all pairs of numbers? For example, given a
    //list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
    //simplicity, you can represent a pair as an array with two elements.
    private static void getPair() {
        List<Dish> dishes = Dish.createDishes();
        List<int[]> list = Stream.of(1, 2, 3)
                .flatMap( i ->
                    Stream.of(3,4)
                            .map(c-> new int[]{i, c})

                )
                .collect(Collectors.toList());

        list.stream()
                .map(c -> {
                    Arrays.stream(c).forEach(System.out::print);
                    return c;
                })
                .map(c -> {
                    System.out.println();
                    return c;
                })
                .count();
    }

    //Given two lists of numbers, how would you return all pairs of numbers? For example, given a
    //list [1, 2, 3] and a list [3, 4] you should return [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]. For
    //simplicity, you can represent a pair as an array with two elements.
    //How would you extend the previous example to return only pairs whose sum is divisible by 3?
    //For example, (2, 4) and (3, 3) are valid.
    private static void getDivBy3Pair() {
        List<Dish> dishes = Dish.createDishes();
        List<int[]> list = Stream.of(1, 2, 3)
                .flatMap( i ->
                        Stream.of(3,4)
                                .filter(c -> (i+c)%3 == 0)
                                .map(c-> new int[]{i, c})

                )
                .collect(Collectors.toList());

        list.stream()
                .map(c -> {
                    Arrays.stream(c).forEach(System.out::print);
                    return c;
                })
                .map(c -> {
                    System.out.println();
                    return c;
                })
                .count();
    }

    //Given a list of numbers, how would you return a list of the square of each number? For
    //example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25].
    private static void getSquare() {
        List<Dish> dishes = Dish.createDishes();
        List<Integer> list = Stream.of(1, 2, 3, 4, 5)
                .map( i -> i * i)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    private static void getDishNamesLetterCount() {
        List<Dish> dishes = Dish.createDishes();
        List<Integer> list = dishes.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(Collectors.toList());

        list.forEach(System.out::println);
    }

    private static void printStream(Stream stream) {
        stream.forEach(System.out::println);
    }
}
