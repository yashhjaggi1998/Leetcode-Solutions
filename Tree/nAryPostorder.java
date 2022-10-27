//https://leetcode.com/problems/n-ary-tree-postorder-traversal/
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
    List <Integer> postOrderNodes;
    public List<Integer> postorder(Node root) {
        postOrderNodes = new ArrayList();
        if(root != null)
            recursivePostOrder(root);
            
        return postOrderNodes;
    }
    
    public void recursivePostOrder(Node node)
    {
        for(int i=0; i<node.children.size(); i++)
        {
            recursivePostOrder(node.children.get(i));
        }
        postOrderNodes.add(node.val);
    }
}
