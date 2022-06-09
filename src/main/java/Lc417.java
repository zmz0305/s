import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc417 {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    int[][] heights;
    boolean[][] o1;
    boolean[][] o2;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        o1 = new boolean[heights.length][heights[0].length];
        o2 = new boolean[heights.length][heights[0].length];
        LinkedList<int[]> o1Queue = new LinkedList<>();
        LinkedList<int[]> o2Queue = new LinkedList<>();
        for (int i = 0; i < heights.length; i++) {
            o1Queue.addLast(new int[]{i, 0});
            o1[i][0] = true;
            o2Queue.addLast(new int[]{i, heights[0].length - 1});
            o2[i][heights[0].length - 1] = true;
        }
        for (int i = 0; i < heights[0].length; i++) {
            o1Queue.addLast(new int[]{0, i});
            o1[0][i] = true;
            o2Queue.addLast(new int[]{heights.length - 1, i});
            o2[heights.length - 1][i] = true;
        }
        bfs(o1Queue, o1);
        bfs(o2Queue, o2);
        List<List<Integer>> res = new ArrayList<>();
        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[0].length; col++) {
                if (o1[row][col] && o1[row][col] == o2[row][col]) {
                    List<Integer> coord = new ArrayList<>();
                    coord.add(row);
                    coord.add(col);
                    res.add(coord);
                }
            }
        }
        return res;
    }

    private void bfs(LinkedList<int[]> queue, boolean[][] visited) {
        while(!queue.isEmpty()) {
            int[] curCoord = queue.pollFirst();
            int curRow = curCoord[0];
            int curCol = curCoord[1];
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0];
                int newCol = curCol + dir[1];
                if (!valid(newRow, newCol, visited)) {
                    continue;
                }
                if (heights[newRow][newCol] < heights[curRow][curCol]) {
                    continue;
                }
                queue.add(new int[]{newRow, newCol});
                visited[newRow][newCol] = true;
            }
        }
    }
    
    private boolean valid(int row, int col, boolean[][] visited) {
        return row >= 0 && row < heights.length &&
                col >= 0 && col < heights[0].length &&
                !visited[row][col];
    }
}
