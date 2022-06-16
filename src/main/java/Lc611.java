import java.util.Arrays;

public class Lc611 {
    public int triangleNumber(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                res += k - j - 1;
            }
        }
        return res;
    }
}
