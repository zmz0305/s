import java.util.Arrays;

public class Lc28 {
    public int strStr(String haystack, String needle) {
        return KMP(haystack, needle);
    }

    private int KMP(String s, String p) {
        int[] kmpTable = buildKMP(p);
        System.out.println(Arrays.toString(kmpTable));
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = kmpTable[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (j == p.length()) {
            return i - j;
        }
        return -1;
    }

    private int[] buildKMP(String p) {
        int[] res = new int[p.length()];
        int j = 0;
        res[0] = 0;
        for (int i = 1; i < p.length();) {
            if (p.charAt(i) == p.charAt(j)) {
                res[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = res[j - 1];
                } else {
                    res[i] = 0;
                    i++;
                }
            }
        }
        return res;
    }
}
