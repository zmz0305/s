import java.util.Map;

public class Lc410 {
    int[] nums;
    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        int sum = 0;
        int max = 0;
        for (int n : nums) {
            max = Math.max(n, max);
            sum += n;
        }
        int left = max;
        int right = sum;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (minCut(mid) > m) {
                left = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }
        return res;
    }

    private int minCut(int maxSum) {
        int cutCount = 0;
        int curSum = 0;
        for (int n : nums) {
            curSum += n;
            if (curSum > maxSum) {
                cutCount += 1;
                curSum = n;
            }
        }
        return cutCount;
    }
}
