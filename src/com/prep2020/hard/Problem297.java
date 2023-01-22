package com.prep2020.hard;

import comp.prep2019.TreeNode;

public class Problem297 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serHelper(root, sb);
        return sb.substring(0, sb.length() - 1);
    }
    
    private StringBuilder serHelper(TreeNode root, StringBuilder sb) {
    	if (root == null) sb.append("$,");
    	else {
    		sb.append(root.val + ",");
    		serHelper(root.left, sb);
    		serHelper(root.right, sb);
    	}
    	return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deSerHelper(arr, new int[] {0});
    }
    
    private TreeNode deSerHelper(String[] arr, int[] start) {
    	if (arr[start[0]].equals("$")) {
    		start[0]++;
    		return null;
    	}
    	TreeNode root = new TreeNode(Integer.valueOf(arr[start[0]]));
    	start[0]++;
    	root.left = deSerHelper(arr, start);
    	root.right = deSerHelper(arr, start);
    	return root;
    	
    }
    
    public static void main(String[] args) {
    	Problem297 problem = new Problem297();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.right.left = new TreeNode(4);
    	root.right.right = new TreeNode(5);
    	String st = problem.serialize(root);
    	System.out.println(st);
    	TreeNode out = problem.deserialize(st);
    	System.out.println(out);
    	
    }
}
