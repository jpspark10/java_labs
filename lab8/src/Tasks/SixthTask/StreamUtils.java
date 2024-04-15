package Tasks.SixthTask;

import java.util.*;
import java.util.stream.Collectors;

public class StreamUtils {

    public static double calculateAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0.0);
    }

    public static List<String> convertToUppercase(List<String> strings) {
        return strings.stream()
                .map(str -> "new " + str.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<Integer> getUniqueSquares(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .map(x -> x * x)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(Collection<String> strings, String startLetter) {
        return strings.stream()
                .filter(str -> str.startsWith(startLetter))
                .sorted()
                .collect(Collectors.toList());
    }

    public static <T> T getLastElementOrThrow(Collection<T> collection) {
        return collection.stream()
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Collection is empty"));
    }

    public static int sumEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(x -> x % 2 == 0)
                .sum();
    }

    public static Map<String, String> convertToMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(str -> str.substring(0, 1), str -> str.substring(1)));
    }
}
