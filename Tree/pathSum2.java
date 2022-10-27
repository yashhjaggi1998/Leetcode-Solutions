//https://leetcode.com/problems/path-sum-ii/
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
    List <List<Integer>> allPaths;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        allPaths = new <List<Integer>> ArrayList();
        if(root != null)
        {
            List <Integer> l = new ArrayList();
            checkSum(root, 0, targetSum, l);
        }
            
        return allPaths;
    }
    
    public void checkSum(TreeNode node, int currentSum, int targetSum, List<Integer> list)
    {
        currentSum += node.val;
        list.add(node.val);

        //trivial case 
        if(node.left == null && node.right == null && currentSum == targetSum)
        {
            List <Integer> temp = new <Integer> ArrayList();
            temp.addAll(list);
            allPaths.add(temp);
        }
        if(node.left != null)
            checkSum(node.left, currentSum, targetSum, list);
    
        if(node.right != null)
            checkSum(node.right, currentSum, targetSum, list);
    
        list.remove( list.size()-1 );
    }
}
