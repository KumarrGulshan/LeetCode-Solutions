class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both are null
        if (p == null && q == null)
            return true;

        // One is null
        if (p == null || q == null)
            return false;

        // Values differ
        if (p.val != q.val)
            return false;

        // Compare left and right subtrees
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}