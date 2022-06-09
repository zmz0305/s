import java.util.ArrayList;
import java.util.List;

public class Lc254 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        backtrack(n, new ArrayList<>(), 2);
        return res;
    }

    private void backtrack(int remain, List<Integer> curRes, int start) {
        if (remain <= 1) {
            if (curRes.size() > 1) {
                res.add(new ArrayList<>(curRes));
            }
        }
        for (int i = start; i <= remain; i++) {
            if (remain % i == 0) {
                curRes.add(i);
                backtrack(remain / i, curRes, i);
                curRes.remove(curRes.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int input = 12;
        Lc254 instance = new Lc254();
        System.out.println(instance.getFactors(input));
    }
}
