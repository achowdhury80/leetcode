package com.prep2020.medium;
import java.util.*;
public class Problem429 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				Node node = q.poll();
				list.add(node.val);
				if (node.children != null) {
					for (Node child : node.children) q.offer(child);
				}
			}
			result.add(list);
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
