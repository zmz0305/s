import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lc301 {
    String s;
    Set<String> res = new HashSet<>();
    int curMaxLen;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        this.curMaxLen = -1;
        backtrack(0, 0, 0, new StringBuilder());
        return new ArrayList<>(res);
    }

    private void backtrack(int index, int openCount, int closeCount, StringBuilder curSb) {
        if (index == s.length()) {
            if (openCount == closeCount) {
                if (curSb.length() > curMaxLen) {
                    res.clear();
                    res.add(curSb.toString());
                    curMaxLen = curSb.length();
                } else if (curSb.length() == curMaxLen){
                    res.add(curSb.toString());
                }
            }
            return;
        }
        char curChar = s.charAt(index);
        if (curChar != '(' && curChar != ')') {
            curSb.append(curChar);
            backtrack(index + 1, openCount, closeCount, curSb);
            curSb.deleteCharAt(curSb.length() - 1);
        } else {
            // the case when not add into result
            backtrack(index + 1, openCount, closeCount, curSb);

            curSb.append(curChar);
            // the case when it's open '('
            if (curChar == '(') {
                backtrack(index + 1, openCount + 1, closeCount, curSb);
            }
            // the case when it's close ')'
            else {
                if (openCount > closeCount) {
                    backtrack(index + 1, openCount, closeCount + 1, curSb);
                }
            }
            curSb.deleteCharAt(curSb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String input = "()())()";
        Lc301 instance = new Lc301();
        System.out.println(instance.removeInvalidParentheses(input));
    }
}
