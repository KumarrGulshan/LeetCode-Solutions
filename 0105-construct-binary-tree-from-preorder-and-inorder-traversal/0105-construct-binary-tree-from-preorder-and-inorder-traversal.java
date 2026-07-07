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
    // Global variable to keep track of our current element in preorder traversal
    private int preorderIndex;
    // Map to quickly find the index of a value in the inorder array
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        
        // Build the hashmap for O(1) inorder lookups
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // Base case: if there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // Select the preorderIndex element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of this root node in the inorder array
        int inorderRootIndex = inorderIndexMap.get(rootValue);

        // Recursively build the left and right subtrees
        // Elements to the left of inorderRootIndex form the left subtree
        root.left = arrayToTree(preorder, left, inorderRootIndex - 1);
        
        // Elements to the right of inorderRootIndex form the right subtree
        root.right = arrayToTree(preorder, inorderRootIndex + 1, right);

        return root;
    }
}