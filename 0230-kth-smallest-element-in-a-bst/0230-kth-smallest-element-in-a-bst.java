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
    private int count = 0;
    private int result = -1;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return result;
    }

    private void inOrder(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        // 1. Traverse left subtree
        inOrder(node.left, k);

        // 2. Process current node
        count++;
        if (count == k) {
            result = node.val;
            return; // Early exit condition met
        }

        // 3. Traverse right subtree
        inOrder(node.right, k);
    }
}