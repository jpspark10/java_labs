package Tasks.FirstTask;

import java.util.function.Predicate;

public class StringUtils {
    public static Predicate<String> isNotNull() {
        return (str) -> str != null;
    }

    public static Predicate<String> isNotEmpty() {
        return (str) -> !str.isEmpty();
    }

    public static Predicate<String> isNotNullAndNotEmpty() {
        return isNotNull().and(isNotEmpty());
    }
}
