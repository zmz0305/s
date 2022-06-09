import java.util.*;

public class Lc1249 {
    public String minRemoveToMakeValid(String s) {
        LinkedList<Integer> stack = new LinkedList<>();
        Set<Integer> indexesToRemove = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.addLast(i);
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) {
                    indexesToRemove.add(i);
                } else {
                    stack.pollLast();
                }
            }
        }
        for (int removeIndex : stack) {
            indexesToRemove.add(removeIndex);
        }
        StringBuilder resBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                resBuilder.append(s.charAt(i));
            }
        }
        return resBuilder.toString();
    }
}
