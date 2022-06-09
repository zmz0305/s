public class Lc1644 {
    boolean pfound = false;
    boolean qfound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = dfs(root, p, q);
        if (pfound && qfound) {
            return res;
        }
        return null;

    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode right = dfs(root.right, p, q);
        TreeNode left = dfs(root.left, p, q);
        if (root.val == p.val) {
            pfound = true;
            return root;
        }
        if (root.val == q.val) {
            qfound = true;
            return root;
        }
        if (right != null && left != null) {
            return root;
        }
        if (right != null) {
            return right;
        }
        return left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        Lc1644 instance = new Lc1644();
        System.out.println(instance.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
    }
}
