package com.learn.lambda.functional_interfaces.chaining_and_with_predicate;

/**
 * Created by mohammad on 7/14/2017.
 */
public interface Predicate<T> {
    boolean check(T p1);

    default Predicate<T> and(Predicate<T> p1) {
        return (a) -> check(a) && p1.check(a);
    }

    default Predicate<T> or(Predicate<T> predicate) {
        return (a) -> check(a) || predicate.check(a);
        /*
        return (a) -> {
            boolean result = check(a);
            if(!result) {
                return predicate.check(a);
            }
            return true;
        };*/
    }
}
