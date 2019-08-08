package com.leet.algo;
import java.util.*;
public class Prob428 {
	// Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) return null;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(root.val);
        if (root.children != null && !root.children.isEmpty()) {
	        for (Node child : root.children) {
	        	sb.append(serialize(child));
	        }
        }
        sb.append(")");
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data == null) return null;
        data = data.substring(1, data.length() - 1);
        int idx= data.indexOf("(");
        if (idx == -1) return new Node(Integer.parseInt(data), new ArrayList<>());
        Node root = new Node(Integer.parseInt(data.substring(0, idx)), new ArrayList<>());
        int count = 1;
        for (int i = idx + 2; i < data.length(); i++) {
        	if (data.charAt(i) == ')') {
        		count--;
        		if (count == 0) {
        			root.children.add(deserialize(data.substring(idx, i + 1)));
        			idx = i + 1;
        		}
        	} else if (data.charAt(i) == '(') count++;
        }
        return root;
    }
}
