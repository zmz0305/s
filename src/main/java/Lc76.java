import java.util.HashMap;
import java.util.Map;

public class Lc76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.putIfAbsent(c, 0);
            targetMap.put(c, targetMap.get(c) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int l = 0, r = 0;
        int match = 0;
        int target = targetMap.size();
        int[] res = new int[]{-1, 0, 0};
        while(r < s.length()) {
            char curChar = s.charAt(r);
            windowMap.putIfAbsent(curChar, 0);
            windowMap.put(curChar, windowMap.get(curChar) + 1);
            if (targetMap.containsKey(curChar) && windowMap.get(curChar) == targetMap.get(curChar)) {
                match++;
            }
            while (match == target && l <= r) {
                char leftChar = s.charAt(l);
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar) <= targetMap.get(leftChar)) {
                    match--;
                }
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                if (res[0] == -1 || res[0] > r - l + 1) {
                    res[0] = r - l + 1;
                    res[1] = l;
                    res[2] = r;
                }
                l++;
            }
            r++;
        }
        if (res[0] == -1) return "";
        return s.substring(res[1], res[2] + 1);
    }

    public static void main(String[] args) {
        String s = "aa";
        String t = "aa";
        Lc76 c = new Lc76();
        String res = c.minWindow(s, t);
        System.out.println(res);
    }
}
