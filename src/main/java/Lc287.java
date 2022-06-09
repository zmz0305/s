
public class Lc287 {
    public int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int duplicate = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int smaller = 0;
            for (int n : nums) {
                if (n <= mid) {
                    smaller++;
                }
            }
            if (smaller >= mid) {
                right = mid - 1;
                duplicate = mid;
            } else {
                left = mid + 1;
            }
        }
        return duplicate;
    }
}
