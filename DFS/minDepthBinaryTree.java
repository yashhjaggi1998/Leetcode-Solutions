//https://leetcode.com/problems/minimum-depth-of-binary-tree/

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
 *      x      this.right = right;
 *     }
 * }
 */

//leaf node = left == null && roght == null
class Solution {
    int minValue;
    
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        minValue = Integer.MAX_VALUE;
        dfs(root, 1);
        return minValue;
    }
    
    public void dfs(TreeNode node, int level)
    {
        if(node.left == null && node.right == null)
        {
            minValue = Math.min(minValue, level);
            return;
        }
        if(node.left != null)
            dfs(node.left, level+1);
        if(node.right != null)
            dfs(node.right, level+1);
    }
}
