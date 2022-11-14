//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//Reasoning: assign left subtree as right child and then iterate this left subtree and add a pointer from rightmost lower node to previous right subtree from current node being explored.
class Solution {
    TreeNode prevNode;
    
    public void flatten(TreeNode root) {
        dfs(root); 
    }
    
    public void dfs(TreeNode node)
    {
        if(node == null)
            return;
        
        TreeNode right = node.right;
        
        
        if(node.left != null)
        {
            node.right = node.left;
            TreeNode temp = node.right;
            while(temp.right != null)
                temp = temp.right;
            temp.right = right;
        }
        node.left = null;
        dfs(node.right);
    
    }
}
