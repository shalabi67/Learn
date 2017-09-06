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
    }
}
