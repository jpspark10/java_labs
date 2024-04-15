package Tasks.SixthTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class StreamUtilsCheck {

    public static void streamUtilsTest() {
        System.out.println("calculateAverage: 1, 2, 3, 4, 5");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double average = StreamUtils.calculateAverage(numbers);
        if (average == 3.0) {
            System.out.println("calculateAverage passed!");
        } else {
            System.out.println("calculateAverage failed!");
        }

        System.out.println("convertToUppercase: \"hello\", \"world\"");
        List<String> strings = Arrays.asList("hello", "world");
        List<String> upperStrings = StreamUtils.convertToUppercase(strings);
        if (upperStrings.equals(Arrays.asList("new HELLO", "new WORLD"))) {
            System.out.println("convertToUppercase passed!");
        } else {
            System.out.println("convertToUppercase failed!");
        }

        System.out.println("getUniqueSquares: 1, 2, 2, 3, 4");
        numbers = Arrays.asList(1, 2, 2, 3, 4);
        List<Integer> squares = StreamUtils.getUniqueSquares(numbers);
        if (squares.equals(Arrays.asList(1, 4, 9))) {
            System.out.println("getUniqueSquares passed!");
        } else {
            System.out.println("getUniqueSquares failed!");
        }

        System.out.println("filterAndSortStrings: \"apple\", \"banana\", \"apricot\", \"cat\"");
        strings = Arrays.asList("apple", "banana", "apricot", "cat");
        List<String> filteredStrings = StreamUtils.filterAndSortStrings(strings, "a");
        if (filteredStrings.equals(Arrays.asList("apricot", "apple"))) {
            System.out.println("filterAndSortStrings passed!");
        } else {
            System.out.println("filterAndSortStrings failed!");
        }

        System.out.println("getLastElementOrThrow: empty");
        List<String> emptyList = Collections.emptyList();
        try {
            StreamUtils.getLastElementOrThrow(emptyList);
            System.out.println("getLastElementOrThrow (empty) failed!");
        } catch (NoSuchElementException e) {
            System.out.println("getLastElementOrThrow (empty) passed!");
        }

        System.out.println("getLastElementOrThrow: \"test\"");
        strings = Arrays.asList("test");
        String lastElement = StreamUtils.getLastElementOrThrow(strings);
        if (lastElement.equals("test")) {
            System.out.println("getLastElementOrThrow passed!");
        } else {
            System.out.println("getLastElementOrThrow failed!");
        }

        System.out.println("sumEvenNumbers: 1, 2, 3, 4, 5, 6");
        int[] evenNumbers = {1, 2, 3, 4, 5, 6};
        int sum = StreamUtils.sumEvenNumbers(evenNumbers);
        if (sum == 12) {
            System.out.println("sumEvenNumbers passed!");
        } else {
            System.out.println("sumEvenNumbers failed!");
        }

        System.out.println("convertToMap: \"apple\", \"banana\", \"cherry\"");
        strings = Arrays.asList("apple", "banana", "cherry");
        Map<String, String> map = StreamUtils.convertToMap(strings);
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("a", "pple");
        expectedMap.put("b", "anana");
        expectedMap.put("c", "herry");
        if (map.equals(expectedMap)) {
            System.out.println("convertToMap passed!");
        } else {
            System.out.println("convertToMap failed!");
        }
    }
}