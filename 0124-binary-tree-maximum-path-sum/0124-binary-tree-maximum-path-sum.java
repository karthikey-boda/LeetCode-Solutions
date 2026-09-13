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
    public int ans = 0;

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        sum(root);
        return ans;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        
        int left = Math.max(0, sum(root.left));
        int right = Math.max(0, sum(root.right));

        ans = Math.max(ans, left + right + root.val);
        
        return root.val + Math.max(left, right);
    }
}