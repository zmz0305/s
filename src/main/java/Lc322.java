import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Lc322 {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> cache = new HashMap<>();
        if (amount == 0) {
            return 0;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        int count = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            count++;
            for (int i = 0; i < curSize; i++) {
                int curVal = queue.pollFirst();
                for (int coin : coins) {
                    int newVal = coin + curVal;
                    if (newVal == amount) {
                        return count;
                    }
                    if (newVal < amount) {
                        queue.add(newVal);
                    }
                }
            }
        }
        return -1;
    }
}
