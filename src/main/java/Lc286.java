import java.util.LinkedList;

public class Lc286 {
    int[][] rooms;
    int GATE = 0;
    int WALL = -1;
    int EMPTY = Integer.MAX_VALUE;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public void wallsAndGates(int[][] rooms) {
        this.rooms = rooms;
        LinkedList<int[]> queue = new LinkedList<>();
        for (int row = 0; row < rooms.length; row++) {
            for (int col = 0; col < rooms[0].length; col++) {
                if (rooms[row][col] == GATE) {
                    queue.addLast(new int[]{row, col});
                }
            }
        }
        int dist = 0;
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int[] curCoord = queue.pollFirst();
                int curRow = curCoord[0];
                int curCol = curCoord[1];
                for (int[] dir : dirs) {
                    int newRow = curRow + dir[0];
                    int newCol = curCol + dir[1];
                    if (valid(newRow, newCol)) {
                        queue.addLast(new int[]{newRow, newCol});
                        rooms[newRow][newCol] = dist;
                    }
                }
            }
            dist++;
        }
    }

    private boolean valid(int row, int col) {
        return row >= 0 && row < rooms.length &&
                col >= 0 && col < rooms[0].length &&
                rooms[row][col] != WALL && rooms[row][col] == EMPTY;
    }
}
