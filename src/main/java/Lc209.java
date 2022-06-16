public class Lc209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum = sum + nums[right];
            while (sum >= target) {
                sum = sum - nums[left];
                res = Math.min(res, right - left + 1);
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
