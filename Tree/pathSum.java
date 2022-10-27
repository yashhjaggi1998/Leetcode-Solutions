//https://leetcode.com/problems/path-sum/
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        
        return checkSum(root, 0, targetSum);        
    }
    
    public boolean checkSum(TreeNode node, int curSum, int tarSum)
    {
        curSum += node.val;
        if(curSum == tarSum && node.left == null && node.right == null)
            return true;
        if(node.left != null)
            if( checkSum(node.left, curSum, tarSum) )
                return true;
        if(node.right != null)
            if( checkSum(node.right, curSum, tarSum) )
                return true;
        return false;
    }
}
