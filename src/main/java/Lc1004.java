public class Lc1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0) {
                int curLeft = nums[left];
                if (curLeft == 0) {
                    k++;
                }
                left++;
            }
            right++;
        }
        return right - left;
    }
}
