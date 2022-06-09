import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lc347 {
    Map<Integer, Integer> count = new HashMap<>();
    int[] unique;
    public int[] topKFrequent(int[] nums, int k) {
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        unique = new int[count.size()];
        int i = 0;
        for (int n : count.keySet()) {
            unique[i++] = n;
        }
        quickSelect(0, unique.length - 1, unique.length - k);
        return Arrays.copyOfRange(unique, unique.length - k, unique.length);
    }

    private int partition(int left, int right, int pivot) {
        int pivotVal = count.get(unique[pivot]);
        swap(pivot, right);
        int storeIdx = left;
        for (int i = left; i < right; i++) {
            if (count.get(unique[i]) < pivotVal) {
                swap(storeIdx, i);
                storeIdx++;
            }
        }
        swap(storeIdx, right);
        return storeIdx;
    }

    private void swap(int a, int b) {
        int temp = unique[a];
        unique[a] = unique[b];
        unique[b] = temp;
    }

    private void quickSelect(int left, int right, int kth) {
        if (left == right) {
            return;
        }
        int pivot = left + (right - left) / 2;
        pivot = partition(left, right, pivot);
        if (pivot == kth) {
            return;
        } else if (pivot < kth) {
            quickSelect(pivot + 1, right, kth);
        } else if (pivot > kth) {
            quickSelect(left, pivot - 1, kth);
        }
    }

}
