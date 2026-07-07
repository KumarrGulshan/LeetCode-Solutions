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
    public int sumNumbers(TreeNode root) {
        // Start the DFS traversal with an initial path sum of 0
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        // Base case: if the node is null, it contributes 0 to the total sum
        if (node == null) {
            return 0;
        }

        // Update the current path number
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the completed path number
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Otherwise, recursively sum up the paths from left and right subtrees
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);

        return leftSum + rightSum;
    }
}