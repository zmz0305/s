import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean rightToLeft = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> curLevel = new LinkedList<>();
            int curLen = queue.size();
            for (int i = 0; i < curLen; i++) {
                TreeNode curNode = queue.pollFirst();
                if (rightToLeft) {
                    curLevel.addLast(curNode.val);
                } else {
                    curLevel.addFirst(curNode.val);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            rightToLeft = !rightToLeft;
            res.add(curLevel);
        }
        return res;
    }
}
