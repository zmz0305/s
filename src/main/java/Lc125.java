import java.util.Locale;

public class Lc125 {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                sb.append(c);
            }
        }
        String processed = sb.toString().toLowerCase(Locale.ROOT);
        System.out.println(processed);
        int i = 0, j = processed.length() - 1;
        while (i < j) {
            if (processed.charAt(i) != processed.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
