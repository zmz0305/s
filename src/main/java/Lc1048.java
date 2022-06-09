import java.util.*;

public class Lc1048 {
    Map<String, Integer> memo = new HashMap<>();
    String[] words;
    Set<String> allWords = new HashSet();
    public int longestStrChain(String[] words) {
        this.words = words;
        Collections.addAll(allWords, words);
        int res = 0;
        for (String word : words) {
            res = Math.max(res, dfs(word));
        }
        return res;
    }

    private int dfs(String curWord) {
        if (memo.containsKey(curWord)) {
            return memo.get(curWord);
        }
        StringBuilder sb = new StringBuilder(curWord);
        int curMaxLen = 1;
        for (int i = 0; i < curWord.length(); i++) {
            int curLen = 1;
            String next = sb.deleteCharAt(i).toString();
            if (allWords.contains(next)) {
                curLen = 1 + dfs(next);
            }
            sb.insert(i, curWord.charAt(i));
            curMaxLen = Math.max(curLen, curMaxLen);
        }
        memo.putIfAbsent(curWord, 0);
        memo.put(curWord, curMaxLen);
        return curMaxLen;
    }
}
