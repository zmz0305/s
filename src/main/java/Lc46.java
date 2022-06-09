import java.util.ArrayList;
import java.util.List;

public class Lc46 {
    int n;
    List<List<Integer>> res;
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums.length;
        this.res = new ArrayList<>();
        this.nums = nums;
        helper(new ArrayList<>());
        return res;
    }

    private void helper(List<Integer> curRes) {
        if (curRes.size() == n) {
            res.add(new ArrayList<>(curRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!curRes.contains(nums[i])) {
                curRes.add(nums[i]);
                helper(curRes);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
