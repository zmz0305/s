
public class Lc329 {
    int[][] memo;
    int[][] matrix;
    int[][] dirs = Utils.fourWayDirs;
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        this.memo = new int[rows][cols];
        this.matrix = matrix;
        int res = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                res = Math.max(res, dfs(row, col));
            }
        }
        return res;
    }

    private int dfs(int row, int col) {
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        int len = 0;
        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (valid(newRow, newCol) && matrix[newRow][newCol] > matrix[row][col]) {
                len = Math.max(dfs(newRow, newCol) + 1, len);
            }
            memo[row][col] = len;
        }
        return len;
    }

    private boolean valid(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }
}
