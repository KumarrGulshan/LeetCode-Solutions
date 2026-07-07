class Solution {
    private Integer prev = null;

    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }

    private boolean inOrder(TreeNode node) {
        if (node == null) {
            return true;
        }

        // 1. Check left subtree
        if (!inOrder(node.left)) return false;

        // 2. Check current node value against previous element
        if (prev != null && node.val <= prev) {
            return false;
        }
        prev = node.val; // Update the previous pointer

        // 3. Check right subtree
        return inOrder(node.right);
    }
}