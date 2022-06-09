import java.util.*;

public class Lc310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n <= 2) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                res.add(i);
            }
            return res;
        }
        List<Set<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new HashSet<>());
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        for (int i = 0; i < adjList.size(); i++) {
            if (adjList.get(i).size() == 1) {
                queue.add(i);
            }
        }
        int remain = n;
        while (remain > 2) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int curFrom = queue.pollFirst();
                remain--;
                for (int curTo : adjList.get(curFrom)) {
                    adjList.get(curTo).remove(curFrom);
                    if (adjList.get(curTo).size() == 1) {
                        queue.addLast(curTo);
                    }
                }
            }
        }
        return queue;
    }
}
