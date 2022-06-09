import java.util.Random;

public class Lc528 {
    class Solution {
        int[] prefixSum;
        int totalSum;
        public Solution(int[] w) {
            prefixSum = new int[w.length];
            totalSum = 0;
            for (int i = 0; i < w.length; i++) {
                totalSum += prefixSum[i];
                prefixSum[i] = totalSum;
            }
        }

        public int pickIndex() {
//            Random random = new Random();
//            int insertPlace = random.nextInt() * totalSum;
            double insertPlace = Math.random() * totalSum;
            int left = 0;
            int right = prefixSum.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (insertPlace > prefixSum[mid]) {
                    left = mid + 1;
                } else if (insertPlace < prefixSum[mid]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            return right;
        }
    }
}
