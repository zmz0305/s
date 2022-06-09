import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Lc150 {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();
    String[] tokens;
    // Ensure this only gets done once for ALL test cases.
    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }
    public int evalRPN(String[] tokens) {
        this.tokens = tokens;
        int curPos = 0;
        int len = tokens.length;
        while (len > 1) {
            while (!OPERATIONS.containsKey(tokens[curPos])) {
                curPos++;
            }
            String opStr = tokens[curPos];
            BiFunction<Integer, Integer, Integer> op = OPERATIONS.get(opStr);
            int res = op.apply(Integer.parseInt(tokens[curPos - 2]), Integer.parseInt(tokens[curPos - 1]));
            tokens[curPos] = String.valueOf(res);
            moveUp(curPos, len);
            curPos--;
            len -= 2;
        }
        return Integer.parseInt(tokens[0]);
    }

    private void moveUp(int curPos, int len) {
        for (int i = curPos - 2; i < len - 2; i++) {
            tokens[i] = tokens[i + 2];
        }
    }
}
