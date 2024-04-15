package FifthTask;
import java.util.*;

import static FifthTask.SwapKeys.swapKeysAndValues;


public class SwapTest {
    public static void swapTest(){
        System.out.println("\n---Fifth task---\n");
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        Map<Integer, Collection<String>> swappedMap = swapKeysAndValues(map);

        System.out.println(swappedMap);
    }
}
