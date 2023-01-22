package com.prep2020.medium;
import java.util.*;
public class Problem1522 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public int diameter(Node root) {
        int[] result = new int[] {0};
        findMaxPath(root, result);
        return result[0];
    }
	
	private int findMaxPath(Node root, int[] result) {
		if (root == null) return -1;
		if (root.children == null || root.children.isEmpty()) return 0;
		Queue<Integer> minQ = new PriorityQueue<>();
		for (Node child : root.children) {
			int maxPath = findMaxPath(child, result);
			minQ.offer(maxPath);
			if (minQ.size() > 2) minQ.poll();
		}
		int diameter = 1 + minQ.peek();
		if (minQ.size() > 1) {
			minQ.poll();
			diameter += (1 + minQ.peek());
		}
		result[0] = Math.max(result[0], diameter);
		return 1 + minQ.poll();
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
