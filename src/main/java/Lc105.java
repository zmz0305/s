import java.util.HashMap;
import java.util.Map;

public class Lc105 {
    Map<Integer, Integer> indexMap;
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int left, int right) {
        if (left < right) {
            return null;
        }
        int curVal = preorder[preIndex++];
        TreeNode curNode = new TreeNode(curVal);
        curNode.left =  helper(preorder, left, indexMap.get(curVal) - 1);
        curNode.right = helper(preorder, indexMap.get(curVal) + 1, right);
        return curNode;
    }
}
