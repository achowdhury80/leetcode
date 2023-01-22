package com.prep2020.easy;
import java.util.*;
public class Problem590 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public List<Integer> postorder(Node root) {
        Deque<Node> dq = new ArrayDeque<>();
        Set<Node> explored = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        dq.offerLast(root);
        while(!dq.isEmpty()) {
        	Node node = dq.peekLast();
        	if (explored.contains(node)) {
        		dq.pollLast();
        		result.add(node.val);
        	} else {
        		if (node.children != null) {
        			for (int i = node.children.size() - 1; i > -1; i--) {
        				dq.offerLast(node.children.get(i));
        			}
        		}
        		explored.add(node);
        	}
        }
        return result;
    }
	
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
	}
}
