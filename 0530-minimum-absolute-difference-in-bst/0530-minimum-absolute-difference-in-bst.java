/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // Global variables to track the minimum difference and the previous node value
    private int minDifference = Integer.MAX_VALUE;
    private Integer prev = null; // Using Integer object wrapper to easily handle the first node

    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDifference;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // 1. Traverse the left subtree
        inOrderTraversal(node.left);

        // 2. Process the current node
        if (prev != null) {
            // Since it's a BST, node.val is guaranteed to be >= prev
            minDifference = Math.min(minDifference, node.val - prev);
        }
        // Update prev to the current node's value
        prev = node.val;

        // 3. Traverse the right subtree
        inOrderTraversal(node.right);
    }
}