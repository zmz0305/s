import java.util.LinkedList;

public class Lc239 {
    LinkedList<Integer> list = new LinkedList<>();
    int[] nums;
    public int[] maxSlidingWindow(int[] nums, int k) {
        this.nums = nums;
        int curMaxIdx = 0;
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            cleanup(i, k);
            list.add(i);
            if (nums[i] > nums[curMaxIdx]) {
                curMaxIdx = i;
            }
        }
        res[0] = curMaxIdx;
        for (int i = k; i < nums.length; i++) {
            cleanup(i, k);
            list.add(i);
            res[i - k + 1] = list.peekFirst();
        }
        return res;
    }

    private void cleanup(int i, int k) {
        if (!list.isEmpty() && list.peekFirst() == i - k) {
            list.removeFirst();
        }
        while (!list.isEmpty() && nums[i] > nums[list.peekLast()]) {
            list.removeLast();
        }
    }
}
