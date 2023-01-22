package com.prep2020.hard;
import java.util.*;
public class Problem428 {
	// Encodes a tree to a single string.
    public String serialize(Node root) {
        String result = "";
        if (root == null) return result;
        result += root.val + ",";
        if (root.children != null && !root.children.isEmpty()) {
        	result += root.children.size() + ",";
        	for (Node node : root.children) {
        		result += serialize(node);
        	}
        } else {
        	result += "0,";
        }
        return result;
    }
    
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if ("".equals(data)) return null;
        String[] arr = data.substring(0, data.length() - 1).split(",");
        return deSerHelper(arr, new int[] {0});
    }
    
    private Node deSerHelper(String[] arr, int[] start) {
    	Node root = new Node(Integer.parseInt(arr[start[0]]));
    	start[0]++;
    	int size = Integer.parseInt(arr[start[0]]);
    	start[0]++;
    	if (size > 0) {
    		root.children = new ArrayList<>();
    		for (int i = 0; i < size; i++) 
    			root.children.add(deSerHelper(arr, start));
    	}
    	return root;
    }
    
    static class Node {
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
    
    public static void main(String[] args) {
    	Problem428 prob = new Problem428();
    	Node root = new Node(1);
    	Node three = new Node(3);
    	three.children = new ArrayList<>();
    	three.children.add(new Node(5));
    	three.children.add(new Node(6));
    	root.children = new ArrayList<>();
    	root.children.add(three);
    	root.children.add(new Node(2));
    	root.children.add(new Node(4));
    	String data = prob.serialize(root);
    	System.out.println(data);
    	Node newRoot = prob.deserialize(data);
    	System.out.println(newRoot);
    }
}
