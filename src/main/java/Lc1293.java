import java.util.LinkedList;

public class Lc1293 {
    class StepState {
        int row;
        int col;
        int remain;
        int stepCount;

        public StepState(int row, int col, int remain, int stepCount) {
            this.row = row;
            this.col = col;
            this.remain = remain;
            this.stepCount = stepCount;
        }
    }

    boolean[][] visited;
    int[][] grid;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        this.visited = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        LinkedList<StepState> queue = new LinkedList<>();
        if (grid.length + grid[0].length - 2 <= k) {
            return grid.length + grid[0].length - 2;
        }
        StepState start = new StepState(0, 0, k, 0);
        queue.addLast(start);
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Utils.print2DBoolean(visited);
            System.out.println();
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                StepState curState = queue.pollFirst();
                if (curState.row == grid.length - 1 && curState.col == grid[0].length - 1) {
                    return curState.stepCount;
                }
                for (int[] dir : dirs) {
                    int newRow = curState.row + dir[0];
                    int newCol = curState.col + dir[1];
                    int newStepCount = curState.stepCount + 1;
                    int newRemain = curState.remain;
                    if (!valid(newRow, newCol)) {
                        continue;
                    }
                    if (grid[newRow][newCol] == 1) {
                        newRemain--;
                    }
                    if (newRemain >= 0) {
                        visited[newRow][newCol] = true;
                        queue.addLast(new StepState(newRow, newCol, newRemain, newStepCount));
                    }
                }
            }
        }
        return -1;
    }

    private boolean valid(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 1, 1, 1, 1, 1, 1, 1},
                        {0, 1, 0, 1, 1, 1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0, 0, 1, 0},
                        {0, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0}
                };
        int k = 1;
        Lc1293 instance = new Lc1293();
        System.out.println(instance.shortestPath(grid, k));
    }
}
