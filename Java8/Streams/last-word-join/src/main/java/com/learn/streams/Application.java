package com.learn.streams;

public class Application {
    public static void main(String[] args) {
        String[] food = new String[]{
                "Crunchy carrots",
                "Golden-hued bananas",
                "",
                "Bright orange pumpkins",
                "Little trees of broccoli",
                "meat"
        };

        System.out.println(Words.joinLastWords(food));

        //notice here two words will return since the empty strings got counted.
        System.out.println(Words.joinLastWords_OnlyFromFirstThreeStrings(food));

        //notice here that three words will return.
        System.out.println(Words.joinLastWords_OnlyFromFirstThreeNonEmptyStrings(food));

        //System.out.println(Words.joinLastWordsWithLoging(food));
    }
}
