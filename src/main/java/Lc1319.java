import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lc1319 {
    class UnionFind {
        public int[] rank;
        public int[] root;
        public UnionFind(int n) {
            rank = new int[n];
            root = new int[n];
            for (int i = 0; i < n; i++) {
                rank[i] = 1;
                root[i] = i;
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootY] > rank[rootX]) {
                    root[rootX] = rootY;
                } else {
                    root[rootX] = rootY;
                    rank[rootY] += 1;
                }
            }
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }
            return root[x] = find(root[x]);
        }
        public void normalize() {
            for (int i = 0; i < root.length; i++) {
                find(i);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] connection : connections) {
            uf.union(connection[0], connection[1]);
        }
        Set<Integer> cluster = Arrays.stream(uf.root).boxed().collect(Collectors.toSet());
        int clusterSize = cluster.size();
        return clusterSize - 1;
    }
}
