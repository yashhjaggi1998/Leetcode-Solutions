//https://leetcode.com/problems/binary-tree-postorder-traversal/

class Solution {
    List <Integer> postOrderNodes;
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrderNodes = new ArrayList();
        if(root != null)
            recursivePostOrder(root);
        
        return postOrderNodes;   
    }
    
    public void recursivePostOrder(TreeNode node)
    {
        if(node.left != null)
            recursivePostOrder(node.left);
        if(node.right != null)
            recursivePostOrder(node.right);
        postOrderNodes.add(node.val);
    }
}
