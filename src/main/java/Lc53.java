import java.util.Map;

public class Lc53 {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int resMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            resMax = Math.max(resMax, curMax);
        }
        return resMax;
    }
}
