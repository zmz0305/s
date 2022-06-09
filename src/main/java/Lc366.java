import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc366 {
//    List<Pair<TreeNode, Integer>> heightInfo = new ArrayList<>();
    Map<Integer, List<Integer>> heightInfoMap = new HashMap<>();
    private int generateHeightInfo(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = generateHeightInfo(root.left);
        int rightHeight = generateHeightInfo(root.right);
        int curHeight = Math.max(leftHeight, rightHeight) + 1;
//        heightInfo.add(new Pair<>(root, curHeight));
        heightInfoMap.putIfAbsent(curHeight, new ArrayList<>());
        heightInfoMap.get(curHeight).add(root.val);
        return curHeight;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        generateHeightInfo(root);
        for (int i = 0; i < heightInfoMap.size(); i++) {
            res.add(heightInfoMap.get(i));
        }
        return res;
    }
}
