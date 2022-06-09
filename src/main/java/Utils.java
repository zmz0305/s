public class Utils {
    public static int[][] fourWayDirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static void print2DInt(int[][] grid) {
        for (int[] row : grid) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void print2DBoolean(boolean[][] grid) {
        for (boolean[] row : grid) {
            for (boolean col : row) {
                if (col) {
                    System.out.print("T ");
                } else {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }
}
