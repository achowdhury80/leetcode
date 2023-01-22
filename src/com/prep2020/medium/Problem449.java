package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem449 {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder result = new StringBuilder();
        result.append("," + root.val);
        result.append(serialize(root.left));
        result.append(serialize(root.right));
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if ("".equals(data)) return null;
    	String[] arr = data.substring(1).split(",");
    	TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
    	Deque<TreeNode> dq = new ArrayDeque<>();
    	dq.offerLast(root);
    	for (int i = 1; i < arr.length; i++) {
    		int val = Integer.valueOf(arr[i]);
    		TreeNode node = new TreeNode(val), parent = null;
    		while(!dq.isEmpty() && dq.peekLast().val < val) parent = dq.pollLast();
    		if (parent != null) parent.right = node;
    		else dq.peekLast().left = node;
    		dq.offerLast(node);
    	}
    	return root;
    }
}
