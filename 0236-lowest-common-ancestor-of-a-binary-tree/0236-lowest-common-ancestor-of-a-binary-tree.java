/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: if we hit null or find either target node, return it
        if (root == null || root == p || root == q) {
            return root;
        }

        // Look for p and q in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both subtrees returned a non-null value, the current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null side (if any)
        return left != null ? left : right;
    }
}