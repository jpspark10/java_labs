package Tasks.SecondTask;

import java.util.function.Predicate;

public class StringChecker {

    public static boolean checkString(String str) {
        Predicate<String> startsWithJNEndsWithA =
                (s) -> s.startsWith("J") || s.startsWith("N") ||s.startsWith("j") || s.startsWith("n") && (s.endsWith("A") || s.endsWith("a"));
        return startsWithJNEndsWithA.test(str);
    }


}