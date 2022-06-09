import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lc1868 {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        int i1 = 0, i2 = 0;
        List<int[]> tempRes = new ArrayList<>();
        while (i1 < encoded1.length && i2 < encoded2.length) {
            int len1 = encoded1[i1][1];
            int len2 = encoded2[i2][1];
            int curIter = Math.min(len1, len2);
            int curProd = encoded1[i1][0] * encoded2[i2][0];
            tempRes.add(new int[]{curProd, curIter});
            if (len1 > len2) {
                encoded1[i1][1] -= curIter;
                i2++;
            } else if (len1 < len2) {
                encoded2[i2][1] -= curIter;
                i1++;
            } else {
                i1++;
                i2++;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int[] cur = tempRes.get(0);
        for (int i = 1; i < tempRes.size(); i++) {
            if (cur[0] == tempRes.get(i)[0]) {
                cur[1] += tempRes.get(i)[1];
            } else {
                res.add(Arrays.stream(cur).boxed().collect(Collectors.toList()));
                cur = tempRes.get(i);
            }
        }
        res.add(Arrays.stream(cur).boxed().collect(Collectors.toList()));
        return res;
    }
}
