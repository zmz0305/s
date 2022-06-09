import java.util.Arrays;

public class Lc214 {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] kmpTable = new int[s.length()*2];
        String reversed = new StringBuilder(s).reverse().toString();
        String kmpStr = s + reversed;
        int j = 0;
        for (int i = 1; i < kmpStr.length();) {
            if (kmpStr.charAt(i) == kmpStr.charAt(j)) {
                kmpTable[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = kmpTable[j - 1];
                } else {
                    kmpTable[i] = 0;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(kmpTable));
        return reversed.substring(0, s.length() - kmpTable[kmpStr.length() - 1]) + s;
    }

    public static void main(String[] args) {
        Lc214 instance = new Lc214();
        String s = "aacecaaa";
        System.out.println(instance.shortestPalindrome(s));
    }
}
