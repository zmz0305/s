import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Lc159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> record = new HashMap<>();
        int res = 0;
        while (right < s.length()) {
            record.put(s.charAt(right), right++);
            if (record.size() == 3) {
                int leftMost = Collections.min(record.values());
                record.remove(s.charAt(leftMost));
                left = leftMost + 1;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
