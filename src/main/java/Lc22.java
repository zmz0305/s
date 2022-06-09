import java.util.ArrayList;
import java.util.List;

public class Lc22 {
    int n;
    List<String> res;
    public List<String> generateParenthesis(int n) {
        this.res = new ArrayList<>();
        this.n = n;
        helper(0, 0, new StringBuilder());
        return res;
    }

    private void helper(int open, int close, StringBuilder sb) {
        if (close == n) {
            res.add(sb.toString());
            return;
        }
        if (open == 0) {
            sb.append("(");
            helper(open + 1, close, sb);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if (open + close < n) {
                sb.append("(");
                helper(open + 1, close, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(")");
            helper(open - 1, close + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Lc22 instance = new Lc22();
        System.out.println(instance.generateParenthesis(n));
    }
}
