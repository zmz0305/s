import java.util.LinkedHashMap;
import java.util.Map;

public class Lc340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> counter = new LinkedHashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char curChar = s.charAt(right++);
            if (counter.containsKey(curChar)) {
                counter.remove(curChar);
            }
            counter.put(curChar, right + 1);

            if (counter.size() > k) {
                Map.Entry<Character, Integer> removeEntry = counter.entrySet().iterator().next();
                left = removeEntry.getValue() + 1;
                counter.remove(removeEntry.getKey());
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
