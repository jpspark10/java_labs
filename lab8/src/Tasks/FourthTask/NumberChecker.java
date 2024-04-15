package Tasks.FourthTask;

import java.util.function.Function;

public class NumberChecker {

    private static final Function<Integer, String> checkNumberType = (number) -> {
        if (number > 0) {
            return "Положительное число";
        } else if (number < 0) {
            return "Отрицательное число";
        } else {
            return "Ноль";
        }
    };

    public static String checkNumber(int number) {
        return checkNumberType.apply(number);
    }
}