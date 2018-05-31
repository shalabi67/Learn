package com.streams.challenges.challenge1;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
     Make an array containing a few Strings. Sort it by
• length (i.e., shortest to longest)
(Hint: this exact solution was shown in the lecture)
• reverse length (i.e., longest to shortest)
(Hint: minor variation of the first bullet)
• alphabetically by the first character only
(Hint: charAt(0) returns the numeric code for the first character)
• Strings that contain “e” first, everything else second. For now, put the code directly in the lambda.
(Hint: remember that the body of a lambda is allowed to have curly braces and a return statement.
See the first two lambda examples in the notes.)
• Redo the previous problem, but use a static helper method so that your lambda looks like this:
Arrays.sort(words, (s1,s2) -> Utils.yourMethod(s1,s2))
     */
public class Application {
    private static String[] data ={"Make an array containing a few Strings",
            "a",
            "remember that the body of a lambda is allowed to have curly braces and a return statement." +
                    "See the first two lambda examples in the notes.",
            "Redo the previous problem, but use a static helper method so that your lambda looks like this:",
            "(s1,s2) -> Utils.yourMethod(s1,s2))",
            "bcd",
            "asd",
            "qwr",
            ""
    };

    public static void main(String[] args) {
        //length (i.e., shortest to longest)
        //Arrays.sort(data, Comparator.comparingInt(String::length));

        //reverse length (i.e., longest to shortest)
        //System.out.println("reverse length (i.e., longest to shortest)");
        //Arrays.sort(data,(a1, a2) -> a2.length() - a1.length());

        //alphabetically by the first character only
        //System.out.println("alphabetically by the first character only");
        //Arrays.sort(data,(a1, a2) -> getFirstChar(a1) - getFirstChar(a2));

        //Strings that contain “e” first, everything else second. For now, put the code directly in the lambda.
        /*
        System.out.println("Strings that contain “e” first, everything else second. For now, put the code directly in the lambda. ");
        Arrays.sort(data,(a1, a2) ->{
            if(a1.contains("e") && a2.contains("e"))
                return 0;
            else if(a1.contains("e"))
                return -1;
            else if (a2.contains("e"))
                return 1;
            return 0;
        });
        */

        //Arrays.stream(data).forEach(System.out::println);

        //Better String
        System.out.println("Better String");
        String right="should see me";
        String wrong="should not see me";
        System.out.println(StringUtil.isBetter(right, wrong, (a1, a2)->true));
        System.out.println(StringUtil.isBetter(wrong, right, (a1, a2)->false));




    }
    public static int getFirstChar(String str) {
        if(str!=null && str.length()>0)
            return str.charAt(0);
        return 0;
    }
}
