import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.BiFunction;

public class Lc150_2 {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();
    String[] tokens;
    // Ensure this only gets done once for ALL test cases.
    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }
    LinkedList<Integer> stack = new LinkedList<>();
    public int evalRPN(String[] tokens) {
        this.tokens = tokens;
        int curPos = 0;
        int len = tokens.length;
        while (curPos < len) {
            while (!OPERATIONS.containsKey(tokens[curPos])) {
                stack.addLast(Integer.parseInt(tokens[curPos]));
                curPos++;
            }
            BiFunction<Integer, Integer, Integer> op = OPERATIONS.get(tokens[curPos]);
            int v2 = stack.pollLast();
            int v1 = stack.pollLast();
            int val = op.apply(v1, v2);
            stack.addLast(val);
            curPos++;
        }
        return stack.pollFirst();
    }

}
