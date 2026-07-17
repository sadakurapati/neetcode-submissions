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
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        pathDiameter(root);
        return maxDiameter;
    }
    private int pathDiameter(TreeNode root) {
        if (root == null) return 0;
        int leftMaxPath = pathDiameter(root.left);
        int rightMaxPath = pathDiameter(root.right);
        maxDiameter = Math.max(maxDiameter, leftMaxPath + rightMaxPath);
        return 1 + Math.max(leftMaxPath, rightMaxPath);
    }
}
