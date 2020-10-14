package comp.prep2019.less2000;

import java.util.*;

public class Prob1490 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public Node cloneTree(Node root) {
		if (root == null) return null;
        Node newNode = new Node(root.val);
        if (root.children != null && !root.children.isEmpty()) {
        	for (Node child : root.children) newNode.children.add(cloneTree(child));
        }
        return newNode;
    }

static class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}
}
