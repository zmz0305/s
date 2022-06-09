import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Lc752 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        if (!deads.contains("0000")) {
            queue.addLast("0000");
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String curStr = queue.pollFirst();
                if (curStr.equals(target)) {
                    return count;
                }
                char[] chars = curStr.toCharArray();
                for (int j = 0; j < 4; j++) {
                    int newUp = ((chars[j] - '0') + 1 ) % 10;
                    String newUpStr = curStr.substring(0, j) + "" + newUp + curStr.substring(j+1);
                    if (!visited.contains(newUpStr) && !deads.contains(newUpStr)) {
                        queue.addLast(newUpStr);
                        visited.add(newUpStr);
                    }
                    int newDown = ((chars[j] - '0') - 1 + 10) % 10;
                    String newDownStr = curStr.substring(0, j) + "" + newDown + curStr.substring(j+1);
                    if (!visited.contains(newDownStr) && !deads.contains(newDownStr)) {
                        queue.addLast(newDownStr);
                        visited.add(newDownStr);
                    }
                }
            }
            count++;
        }
        return -1;
    }

}
