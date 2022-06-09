import java.util.LinkedList;

public class Lc20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else {
                if (stack.size() == 0) {
                    return false;
                }
                char last = stack.peekLast();
                if (last == '(' && c != ')' ||
                        last == '{' && c != '}' ||
                        last == '[' && c != ']') {
                    return false;
                } else {
                    stack.pollLast();
                }
            }
        }
        return stack.size() == 0;
    }
}
