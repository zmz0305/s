import java.util.Arrays;
import java.util.PriorityQueue;

public class Lc253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> rooms = new PriorityQueue<>((a, b) -> a - b);
        rooms.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (rooms.peek() <= intervals[i][0]) {
                rooms.poll();
            }
            rooms.add(intervals[i][1]);
        }
        return rooms.size();
    }
}
