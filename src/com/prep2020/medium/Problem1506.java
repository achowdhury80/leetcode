package com.prep2020.medium;
import java.util.*;
public class Problem1506 {
	/**
	 * O(N) time and space where n is the total number of nodes
	 * @param tree
	 * @return
	 */
	public Node findRoot(List<Node> tree) {
        Map<Node, Boolean> isNotRoot = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        for (Node node : tree) {
        	q.offer(node);
        	isNotRoot.put(node, false);
        }
        while(!q.isEmpty()) {
        	Node node = q.poll();
        	if (node.children != null) {
        		for (Node child : node.children) {
        			if (!isNotRoot.containsKey(child)) q.offer(child);
        			isNotRoot.put(child, true);
        		}
        	}
        }
        for (Map.Entry<Node, Boolean> entry : isNotRoot.entrySet()) {
        	if (!entry.getValue()) return entry.getKey();
        }
        return null;
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
