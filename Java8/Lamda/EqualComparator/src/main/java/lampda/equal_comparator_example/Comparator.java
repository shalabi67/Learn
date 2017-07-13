package lampda.equal_comparator_example;

import java.util.function.Function;

/**
 * Created by mshalabi on 13.07.17.
 */
public interface Comparator<T> {
    boolean areEqual(T p1, T p2);

    default Comparator<T> and(Function<T, Object> function ) {
        return (p1, p2) -> {
            boolean result = areEqual(p1, p2);
            if(result)
                return comparing(function).areEqual(p1, p2);
            return false;
        };
    }

    default Comparator<T> or(Function<T, Object> function ) {
        return (p1, p2) -> {
            boolean result = areEqual(p1, p2);
            if(!result)
                return comparing(function).areEqual(p1, p2);
            return true;
        };
    }


    public static <T> Comparator<T> comparing(Function<T, Object> function) {
        return (p1, p2) -> function.apply(p1).equals(function.apply(p2));
    }


}
