package com.leet.algo;
import java.util.*;
public class Prob589 {
	public List<Integer> preorder(Node root) {
		List<Integer> result = new ArrayList<>();
		helper(root, result);
		return result;
    }
	
	private void helper(Node root, List<Integer> list) {
		if (root == null) return;
		list.add(root.val);
		if (root.children != null) for (Node child : root.children) helper(child, list);
		
	}
}
