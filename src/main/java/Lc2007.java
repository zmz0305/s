import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Lc2007 {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) return new int[0];
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int n : changed) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        int[] res = new int[changed.length / 2];
        int i = 0;
        for (int key : countMap.keySet()) {
            if (countMap.get(key) > countMap.get(key * 2)) {
                return new int[0];
            }
            for (int count = 0; count < countMap.get(key); count++) {
                res[i++] = key;
                countMap.put(key * 2, countMap.get(key*2) - 1);
            }
        }
        return res;
    }
}
