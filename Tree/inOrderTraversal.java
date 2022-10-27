//https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution {
    List <Integer> inOrderNodes;
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        if(root == null)
            return new <Integer> ArrayList();
            
        inOrderNodes = new <Integer> ArrayList();
        recursiveTraversal(root);
        
        return inOrderNodes;
    }
    
    public void recursiveTraversal(TreeNode node)
    {
        if(node.left != null)
            recursiveTraversal(node.left);
        
        if(node != null)
            inOrderNodes.add(node.val);    
        
        if(node.right != null)
            recursiveTraversal(node.right);
    }
}
