//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

class Solution {
    private boolean pExists;
    private boolean qExists;
    TreeNode lca;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) 
    {
        lca = root;
        commonAncestor(root, p, q);
        return lca;   
    }
    
    public void commonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {   
        lca = root;
        if(p.val == root.val || q.val == root.val)
            return;
        
        pExists = false; qExists = false;
        dfs(root.left, p.val, q.val); //run dfs on left subtree
        
        if(pExists && qExists)
            commonAncestor(root.left, p, q);
        
        else if(!pExists && !qExists) //lca has to be in the right subtree
            commonAncestor(root.right, p, q);
    }
    
    //Depth-First Search function
    public void dfs(TreeNode node, int p, int q){
        if (node == null)
            return;
        if(pExists && qExists)
            return;
        if(node.left != null)
            dfs(node.left, p, q);
        
        if(node != null)
        {
            if(node.val == p)
                pExists = true;
            if(node.val == q)
                qExists = true;
        }
        
        if(node.right != null)
            dfs(node.right, p, q);
        
    }
}
