public class Lc1216 {
    Integer[][] memo;
    public boolean isValidPalindrome(String s, int k) {
        memo = new Integer[s.length()][s.length()];
        return check(s, 0, s.length() - 1) <= k;
    }

    private int check(String s, int i, int j) {
        if (i == j) return 0;
        if (i + 1 == j) return s.charAt(i) == s.charAt(j) ? 0 : 1;
        if (memo[i][j] != null) return memo[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = check(s, i + 1, j - 1);
        } else {
            memo[i][j] = Math.min(check(s, i + 1, j), check(s, i, j - 1)) + 1;
        }
        return memo[i][j];
    }
}
