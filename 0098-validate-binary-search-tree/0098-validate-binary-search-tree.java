/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    // Method to check if our binary tree is a valid Binary Search Tree (BST)
    public boolean isValidBST(TreeNode root) {
        // If the tree is empty, it's a valid BST by default
        if (root == null) return true;
        // Otherwise, we start our journey to check its validity
        return dfs(root, null, null);
    }

    // Helper method for Depth-First Search (DFS) with range checks
    private boolean dfs(TreeNode root, Integer min, Integer max) {
        // If we reach a null node, it means this path is valid
        if (root == null) return true;

        // Check if the current node's value is within the valid range
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false; // Violates the BST rules
        }

        // Recursively check the left and right subtrees
        // For the left subtree, the current node's value becomes the new max
        // For the right subtree, the current node's value becomes the new min
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}
