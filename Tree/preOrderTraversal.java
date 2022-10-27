//https://leetcode.com/problems/binary-tree-preorder-traversal/

class Solution {
    List<Integer> preOrderNodes;
    public List<Integer> preorderTraversal(TreeNode root) {
        
        preOrderNodes = new ArrayList();
        if(root != null)
            recursivePreOrder(root); 
        
        return preOrderNodes;
    }
    
    public void recursivePreOrder(TreeNode node)
    {
        //Trivial Case
        if(node != null) 
            preOrderNodes.add(node.val);
        if(node.left != null)
            recursivePreOrder(node.left);
        if(node.right != null)
            recursivePreOrder(node.right);
    }
}
