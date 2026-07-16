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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> levelElements = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode el = q.poll();
                levelElements.add(el.val);
                if (el.left != null) q.offer(el.left);
                if (el.right != null) q.offer(el.right);
            }
            ans.add(levelElements);
        }
        return ans;
    }
}
