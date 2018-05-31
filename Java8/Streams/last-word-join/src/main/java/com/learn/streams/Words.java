package com.learn.streams;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;

public class Words {
    public static String joinLastWords(String[] list) {
        return Arrays.stream(list)
                .filter(str -> !str.isEmpty())
                .map(lastWord)
                .reduce((a,b) ->a + " & " + b)
                .orElse("");
    }
    public static String joinLastWords_OnlyFromFirstThreeStrings(String[] list) {
        return Arrays.stream(list)
                .limit(3)
                .filter(str -> !str.isEmpty())
                .map(lastWord)
                .reduce((a,b) ->a + " & " + b)
                .orElse("");
    }
    public static String joinLastWords_OnlyFromFirstThreeNonEmptyStrings(String[] list) {
        return Arrays.stream(list)
                .filter(str -> !str.isEmpty())
                .limit(3)
                .map(lastWord)
                .reduce((a,b) ->a + " & " + b)
                .orElse("");
    }
    public static String joinLastWordsWithLoging(String[] list) {
        return Arrays.stream(list)
                .peek(s -> System.out.println("before filtering " + s))
                .filter(str -> !str.isEmpty())
                .peek(s -> System.out.println("before mapping " + s))
                .map(lastWord)
                .peek(s -> System.out.println("before reduce " + s))
                .reduce((a,b) ->a + " & " + b)
                .orElse("");
    }
    /*public static String joinLastWordsSolution2(String[] list) {
        return Arrays.stream(list)
                .filter(str -> !str.isEmpty())
                .map(lastWord)
                .collect(Collector);
    }*/
    private static BinaryOperator<String> last =
            (other, last) -> last;
    private static Function<String,String> lastWord = (String phrase) ->
            Arrays.asList(phrase.split(" ")).stream().
                    reduce(last).
                    orElse("");
}
