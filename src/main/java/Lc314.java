import java.util.*;

public class Lc314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Map<Integer, List<Integer>> colMap = new HashMap<>();
        queue.addLast(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                Pair<TreeNode, Integer> curNodeInfo = queue.pollFirst();
                TreeNode curNode = curNodeInfo.getKey();
                int curCol = curNodeInfo.getValue();
                colMap.putIfAbsent(curCol, new ArrayList<>());
                colMap.get(curCol).add(curNode.val);
                if (curNode.left != null) {
                    queue.addLast(new Pair<>(curNode.left, curCol - 1));
                }
                if (curNode.right != null) {
                    queue.addLast(new Pair<>(curNode.right, curCol + 1));
                }
            }
        }
        List<Integer> sortedCol = new ArrayList<>(colMap.keySet());
        Collections.sort(sortedCol);
        for (int col : sortedCol) {
            res.add(colMap.get(col));
        }
        return res;
    }
}
