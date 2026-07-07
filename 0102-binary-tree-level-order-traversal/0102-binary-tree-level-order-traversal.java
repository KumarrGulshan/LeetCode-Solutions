import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Number of elements at the current level
            int levelSize = queue.size();
            List<Integer> currentLevelList = new ArrayList<>();

            // Process all nodes belonging to the current level
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currentLevelList.add(curr.val);

                // Enqueue left child if it exists
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                // Enqueue right child if it exists
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            // Add the populated level list to our final result
            result.add(currentLevelList);
        }

        return result;
    }
}