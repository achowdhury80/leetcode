package com.prep2020.medium;
import java.util.*;
public class Problem1490 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public Node cloneTree(Node root) {
		if (root == null) return root;
        return helper(root, new HashMap<>());
    }
	
	private Node helper(Node root, Map<Node, Node> clonedMap) {
		if (clonedMap.containsKey(root)) return clonedMap.get(root);
		Node cloned = new Node(root.val);
		if (root.children != null) {
			cloned.children = new ArrayList<>();
			for (Node child : root.children) {
				cloned.children.add(helper(child, clonedMap));
			}
		}
		clonedMap.put(root, cloned);
		return cloned;
	}
	
	class Node {
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
