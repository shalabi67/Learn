package com.learn.streams;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Words {
    public static String joinLastWords(String[] list) {
        return Arrays.stream(list)
                .filter(str -> !str.isEmpty())
                .map(lastWord)
                .reduce((a,b) ->a + " & " + b)
                .orElse("");
    }
    private static BinaryOperator<String> last =
            (other, last) -> last;
    private static Function<String,String> lastWord = (String phrase) ->
            Arrays.asList(phrase.split(" ")).stream().
                    reduce(last).
                    orElse("");
}
