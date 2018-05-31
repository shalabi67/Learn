package com.streams.challenges.challenge1;

import java.util.function.BiPredicate;

/*
Your eventual goal is to make a method called betterString that takes two Strings and a lambda that says whether the
first of the two is “better”. The method should return that better String; i.e., if the function given by the lambda
returns true, the betterString method should return the first String, otherwise betterString should
return the second String. Here are two examples of how your code should work when it is finished
(the first lambda example returns whichever of string1 and string2 is longer, and the second lambda
example always returns string1).
• String string1 = ...;
• String string2 = ...;
• String longer = StringUtils.betterString(string1, string2, (s1, s2) -> s1.length() > s2.length());
• String first = StringUtils.betterString(string1, string2, (s1, s2) -> true);
 */
public class StringUtil {
    public static String isBetter(String first, String second, BiPredicate<String, String> predicate) {
        if( predicate.test(first, second))
            return first;
        return second;
    }
}
