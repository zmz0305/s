import java.util.Map;
import java.util.TreeMap;

public class Lc954 {
    public boolean canReorderDoubled(int[] arr) {
        if (arr.length % 2 == 1) return false;

        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int n : arr) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        for (int key : countMap.keySet()) {
            if (countMap.get(key) == 0) continue;
            int want = key < 0 ? key / 2 : key * 2;
            if (!countMap.containsKey(key*2) || countMap.get(key) > countMap.getOrDefault(want, 0)) {
                return false;
            }
            countMap.put(want, countMap.get(want) - countMap.get(key));
        }
        return true;
    }
}
