public class Lc1937 {
    public long maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        long[] left = new long[points[0].length];
        long[] right = new long[points[0].length];
        long[] prev = new long[points[0].length];
        for (int col = 0; col < points[0].length; col++) {
            prev[col] = points[0][col];
        }
        for (int row = 1; row < points.length; row++) {
            left[0] = prev[0];
            for (int col = 1; col < points[0].length; col++) {
                left[col] = Math.max(prev[col], left[col - 1] - 1);
            }
            right[points[0].length - 1] = prev[points[0].length - 1];
            for (int col = points[0].length - 2; col >= 0; col--) {
                right[col] = Math.max(prev[col], right[col + 1] - 1);
            }
            long[] cur = new long[points[0].length];
            for (int col = 0; col < points[0].length; col++) {
                cur[col] = Math.max(left[col], right[col]) + points[row][col];
            }
            prev = cur;
        }
        long res = 0;
        for (int col = 0; col < points[0].length; col++) {
            res = Math.max(res, prev[col]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{1,5},{3,2},{4,2}};
        Lc1937 instance = new Lc1937();
        System.out.println(instance.maxPoints(points));
    }
}
