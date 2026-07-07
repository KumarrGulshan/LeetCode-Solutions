import java.util.HashMap;
import java.util.Map;

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
    // Global variable to track our current element moving backward in postorder
    private int postorderIndex;
    // Map to quickly locate the index of a value in the inorder array
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start from the last element of the postorder array
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();

        // Build the hashmap for O(1) inorder lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        // Base case: if there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // Pick the postorderIndex element as the root and decrement it
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of this root node in the inorder array
        int inorderRootIndex = inorderIndexMap.get(rootValue);

        // CRITICAL STEP: Build the RIGHT subtree first because we are 
        // reading the postorder array from right to left [Left, Right, Root]
        root.right = arrayToTree(postorder, inorderRootIndex + 1, right);
        
        // Build the LEFT subtree next
        root.left = arrayToTree(postorder, left, inorderRootIndex - 1);

        return root;
    }
}