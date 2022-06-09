public class Lc1092 {
    int[][] dp;
    public String shortestCommonSupersequence(String str1, String str2) {
        this.dp = new int[str1.length() + 1][str2.length() + 1];
        int rows = str1.length();
        int cols = str2.length();
        for (int row = 0; row <= rows; row++) {
            for (int col = 0; col <= cols; col++) {
                if (row == 0) {
                    dp[row][col] = col;
                } else if (col == 0) {
                    dp[row][col] = row;
                } else if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = 1 + Math.min(dp[row][col - 1], dp[row - 1][col]);
                }
            }
        }
        int minLen = dp[rows][cols];
        char[] resChars = new char[minLen];
        int row = rows;
        int col = cols;
        while (row > 0 && col > 0) {
            if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                resChars[--minLen] = str1.charAt(row - 1);
                row--;
                col--;
            } else if (dp[row][col - 1] < dp[row - 1][col]) {
                resChars[--minLen] = str2.charAt(col - 1);
                col--;
            } else {
                resChars[--minLen] = str1.charAt(row - 1);
                row--;
            }
        }
        while (row > 0) {
            resChars[--minLen] = str1.charAt(row - 1);
            row--;
        }
        while (col > 0) {
            resChars[--minLen] = str2.charAt(col - 1);
            col--;
        }
        return new String(resChars);
    }
}
