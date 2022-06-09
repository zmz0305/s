import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc241 {
    Map<String, List<Integer>> cache = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char curChar = expression.charAt(i);
            if (curChar == '+' || curChar == '-' || curChar == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1, expression.length());
                List<Integer> leftRes = cache.getOrDefault(left, diffWaysToCompute(left));
                List<Integer> rightRes = cache.getOrDefault(right, diffWaysToCompute(right));
                for (Integer l : leftRes) {
                    for (Integer r : rightRes) {
                        int curRes = 0;
                        switch (curChar){
                            case '+':
                                curRes = l + r;
                                break;
                            case '-':
                                curRes = l - r;
                                break;
                            case '*':
                                curRes = l * r;
                                break;
                        }
                        res.add(curRes);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(expression));
        }
        cache.put(expression, res);
        return res;
    }
}
