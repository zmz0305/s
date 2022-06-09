import java.util.Arrays;

public class Lc616 {
    boolean[] mark;

    public String addBoldTag(String s, String[] words) {
        mark = new boolean[s.length()];
        for (String word : words) {
            KMP(s, word);
        }
        StringBuilder sb = new StringBuilder();
        boolean startBold = false;
        for (int i = 0; i < s.length(); i++) {
            if (mark[i]) {
                if (!startBold) {
                    sb.append("<b>");
                    startBold = true;
                }
                sb.append(s.charAt(i));
            } else {
                if (startBold) {
                    sb.append("</b>");
                    startBold = false;
                }
                sb.append(s.charAt(i));
            }
        }
        if (startBold) {
            sb.append("</b>");
        }
        return sb.toString();
    }

    public void KMP(String s, String p) {
        char[] schars = s.toCharArray();
        char[] pchars = p.toCharArray();
        int[] nextTable = nextTable(p);
        int i = 0, j = 0;
        while (i < schars.length) {
            while (i < schars.length && j < pchars.length) {
                if (schars[i] == pchars[j]) {
                    i++;
                    j++;
                } else {
                    if (j != 0) {
                        j = nextTable[j - 1];
                    } else {
                        i++;
                    }
                }
            }
            if (j == p.length()) {
                for (int go = 0; go < p.length(); go++) {
                    mark[i - 1 - go] = true;
                }
                j = nextTable[j - 1];
            }
        }
    }

    public int[] nextTable(String p) {
        int[] res = new int[p.length()];
        int j = 0;
        res[0] = 0;
        for (int i = 1; i < p.length(); ) {
            if (p.charAt(i) == p.charAt(j)) {
                res[i] = j + 1;
                i++;
                j++;
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

    public static void main(String[] args) {
        String s = "aacecaaa aaacecaa";
        Lc616 instance = new Lc616();
        System.out.println(Arrays.toString(instance.nextTable(s)));
    }
}
