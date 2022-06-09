import java.util.ArrayList;
import java.util.List;

public class Lc68 {
    String[] words;
    public List<String> fullJustify(String[] words, int maxWidth) {
        this.words = words;
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (left < words.length) {
            right = findRight(left, maxWidth);
            String curLine = justify(left, right, maxWidth);
            res.add(curLine);
            left = right + 1;
        }
        return res;
    }

    private int findRight(int left, int maxWidth) {
        int right = left;
        int curLen = words[right++].length();
        while (right < words.length && words[right].length() + curLen + 1 <= maxWidth) {
            curLen = words[right++].length() + curLen + 1;
        }
        return right - 1;
    }

    private String justify(int left, int right, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        if (right == words.length - 1) {
            for (int i = left; i <= right; i++) {
                sb.append(words[i]);
                if (i != right) {
                    sb.append(" ");
                }
            }
            while (sb.length() != maxWidth) {
                sb.append(" ");
            }
            return sb.toString();
        }
        int charLen = 0;
        int charCount = right - left + 1;
        for (int i = left; i <= right; i++) {
            charLen += words[i].length();
        }
        int spaceLen = maxWidth - charLen;
        int gapCount = charCount - 1;
        if (gapCount > 0) {
            int spacePerGap = spaceLen / gapCount;
            int spaceOverflow = spaceLen % gapCount;
            sb.append(words[left++]);
            for (int i = 0; i < gapCount; i++) {
                for (int j = 0; j < spacePerGap; j++) {
                    sb.append(" ");
                }
                if (i < spaceOverflow) {
                    sb.append(" ");
                }
                sb.append(words[left++]);
            }
        } else {
            sb.append(words[left]);
            while (sb.length() != maxWidth) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth = 20;
        Lc68 instance = new Lc68();
        System.out.println(instance.fullJustify(words, maxWidth));
    }
}
