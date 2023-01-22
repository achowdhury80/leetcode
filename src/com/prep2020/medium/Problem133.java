package com.prep2020.medium;
import java.util.*;
public class Problem133 {
	/**
	 * O(N)
	 * @param node
	 * @return
	 */
	public Node cloneGraph(Node node) {
		if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return cloneNode(node, map);
    }
	
	private Node cloneNode(Node source,  Map<Node, Node> map) {
		if (map.containsKey(source)) return map.get(source);
		Node copy = new Node(source.val);
		map.put(source, copy);
		for (Node child : source.neighbors) {
			copy.neighbors.add(cloneNode(child, map));
		}
		return copy;
	}
	
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
}
