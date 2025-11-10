package ua.opnu;

import java.util.function.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Filter {
    public static <T> T[] filter(T[] input, Predicate<T> predicate) {
        List<T> resultList = new ArrayList<>();
        for (T element : input) {
            if (predicate.test(element)) {
                resultList.add(element);
            }
        }
        return resultList.toArray(Arrays.copyOf(input, resultList.size()));
    }
}
