//https://leetcode.com/problems/n-ary-tree-preorder-traversal/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List <Integer> preOrderNodes;
    public List<Integer> preorder(Node root) {
        preOrderNodes = new ArrayList();
        if(root != null)
            recursivePreOrder(root);
        
        return preOrderNodes;
    }
    
    public void recursivePreOrder(Node node)
    {
        if(node != null)
            preOrderNodes.add(node.val);
        for(int i=0; i<node.children.size(); i++)
            if(node.children.get(i) != null)
                recursivePreOrder(node.children.get(i));
    }
}
