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
    private int globalMaxSum;

    public int maxPathSum(TreeNode root) {
        globalMaxSum = Integer.MIN_VALUE;
        maxGain(root);
        return globalMaxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));
        int currentPathSum = node.val + leftGain + rightGain;
        globalMaxSum = Math.max(globalMaxSum, currentPathSum);
        return node.val + Math.max(leftGain, rightGain);
    }
}