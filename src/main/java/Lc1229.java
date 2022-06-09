import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lc1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(slots2, Comparator.comparingInt(a -> a[0]));
        int p1 = 0, p2 = 0;
        while (p1 < slots1.length && p2 < slots2.length) {
            int left = Math.max(slots1[p1][0], slots2[p2][0]);
            int right = Math.min(slots1[p1][1], slots2[p2][1]);
            if (right - left >= duration) {
                return Arrays.asList(left, left + duration);
            }
            // move forward the one that ends earlier
            if (slots1[p1][1] > slots2[p2][1]) {
                p2++;
            } else {
                p1++;
            }
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {

    }
}
