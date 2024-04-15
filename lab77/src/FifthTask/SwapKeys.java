package FifthTask;

import java.util.*;

public class SwapKeys {
    public static <K, V> Map<V, Collection<K>> swapKeysAndValues(Map<K, V> map) {
        Map<V, Collection<K>> swappedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            Collection<K> keys = swappedMap.getOrDefault(value, new ArrayList<>());
            keys.add(entry.getKey());
            swappedMap.put(value, keys);
        }
        return swappedMap;
    }
}
