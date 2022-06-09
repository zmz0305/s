public class Lc2096 {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sbStart = new StringBuilder();
        StringBuilder sbEnd = new StringBuilder();
        find(root, startValue, sbStart);
        find(root, destValue, sbEnd);
        sbEnd = sbEnd.reverse();
        sbStart = sbStart.reverse();
        int commonIndex = 0;
        int max = Math.min(sbStart.length(), sbEnd.length());
        while (commonIndex < max) {
            if (sbStart.charAt(commonIndex) == sbEnd.charAt(commonIndex)) {
                commonIndex++;
            }
        }
        return "U".repeat(sbStart.length() - commonIndex) + sbEnd.substring(commonIndex);
    }

    private boolean find(TreeNode root, int val, StringBuilder sb) {
        if (val == root.val) {
            return true;
        }
        if (root.left != null && find(root.left, val, sb)) {
            sb.append("L");
        } else if (root.right != null && find(root.right, val, sb)) {
            sb.append("R");
        }
        return sb.length() > 0;
    }
}
