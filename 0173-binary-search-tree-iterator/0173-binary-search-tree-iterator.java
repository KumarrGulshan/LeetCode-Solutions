import java.util.Stack;

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
class BSTIterator {
    // Stack to simulate the controlled in-order traversal
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        // Push the root and all its left-most children to set up the first element
        pushAllLeftNodes(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushAllLeftNodes(node.right);
        }
        
        return node.val;
    }
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void pushAllLeftNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

