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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        // Flag to track the direction of traversal
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            // Using LinkedList so we can efficiently add to the front (addFirst)
            LinkedList<Integer> currentLevelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();

                // Insert based on current level direction
                if (leftToRight) {
                    currentLevelList.add(curr.val); // Adds to the end
                } else {
                    currentLevelList.addFirst(curr.val); // Adds to the front
                }

                // Standard BFS child insertion
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }

            // Append the processed level list to the final result
            result.add(currentLevelList);
            // Flip the direction for the next level
            leftToRight = !leftToRight;
        }

        return result;
    }
}