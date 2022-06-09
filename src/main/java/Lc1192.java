import java.util.*;

public class Lc1192 {
    List<List<Integer>> connections;
    List<Integer>[] adjList;
    Map<Integer, Integer> rank;
    Map<Pair<Integer, Integer>, Boolean> connDict = new HashMap<>();
    int n;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        this.connections = connections;
        this.n = n;
        buildGraph();
        dfs(0, 0);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Pair<Integer, Integer> res : connDict.keySet()) {
            result.add(new ArrayList<Integer>(Arrays.asList(res.getKey(), res.getValue())));
        }
        return result;
    }

    private int dfs(int curNode, int curRank) {
        if (rank.get(curNode) != null) {
            return rank.get(curNode);
        }
        rank.put(curNode, curRank);
        int minRank = curRank + 1;
        List<Integer> neibs = adjList[curNode];
        for (int neib : neibs) {
            // skip parent
            if (rank.get(neib) == curRank - 1) {
                continue;
            }
            int resRank = dfs(neib, curRank + 1);
            if (resRank < curRank) {
                connDict.remove(new Pair<>(Math.min(curNode, neib), Math.max(curNode, neib)));
            }
            minRank = Math.min(minRank, resRank);
        }
        return minRank;
    }

    private void buildGraph() {
        adjList = new List[n];
        rank = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
            rank.put(i, null);
        }

        for (List<Integer> connection : connections) {
            int from = connection.get(0);
            int to = connection.get(1);
            int sortedfrom = Math.min(from, to);
            int sortedTo = Math.max(from, to);
            connDict.put(new Pair<>(sortedfrom, sortedTo), true);
        }
    }
}
