import java.util.HashSet;
import java.util.Set;

public class Lc489 {
    Set<Pair<Integer, Integer>> visited = new HashSet<>();
    int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void cleanRoom(Robot robot) {
        dfs(robot, 0, 0, 0);
    }

    private void dfs(Robot robot, int row, int col, int d) {
        Pair<Integer, Integer> pos = new Pair<>(row, col);
        visited.add(pos);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int newD = (d + i) % 4;
            int newRow = row + dirs[newD][0];
            int newCol = col + dirs[newD][1];
            Pair<Integer, Integer> newPos = new Pair<>(newRow, newCol);
            if (!visited.contains(newPos) && robot.move()) {
                dfs(robot, newRow, newCol, newD);
                goback(robot);
            }
            robot.turnRight();
        }
    }

    private void goback(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
