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
    record BalancedAndHeight(boolean isBalanced, int height){}
    public boolean isBalanced(TreeNode root) {
        return isBalancedAndHeight(root).isBalanced;
    }
    public BalancedAndHeight isBalancedAndHeight(TreeNode node) {
        // Base case
        if (node == null) {
            return new BalancedAndHeight(true, 0);
        }
        BalancedAndHeight left = isBalancedAndHeight(node.left);
        BalancedAndHeight right = isBalancedAndHeight(node.right);
        int childHeightDiff = Math.abs(left.height - right.height);
        // Validate
        boolean isThisNodeBalanced = left.isBalanced && right.isBalanced && childHeightDiff <= 1;
        int height = Math.max(left.height, right.height);
        return new BalancedAndHeight(isThisNodeBalanced, height + 1);
    }
}
