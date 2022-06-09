import java.util.Arrays;

public class Lc252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] prevInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (prevInterval[1] > intervals[i][0]) {
                return false;
            }
            prevInterval = intervals[i];
        }
        return true;
    }
}
