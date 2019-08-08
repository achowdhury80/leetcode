package com.leet.algo;
import java.util.*;
public class Prob590 {
	public List<Integer> postorder(Node root) {
		List<Integer> result = new ArrayList<>();
		postorder(root, result);
		return result;
    }
	
	private void postorder(Node root, List<Integer> list) {
		if (root == null) return;
		if (root.children != null) for (Node child : root.children) postorder(child, list);
		list.add(root.val);
	}
}
