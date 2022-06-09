import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> stack = new LinkedList();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pollLast();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
