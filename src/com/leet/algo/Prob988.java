package com.leet.algo;

public class Prob988 {
	public String smallestFromLeaf(TreeNode root) {
        String[] result = new String[] {""};
        dfs(root, "", result);
        return result[0];
    }
	
	private void dfs(TreeNode node, String path, String[] result) {
		path = "" + (char)(node.val + 97) + path;
		if (node.left == null && node.right == null) {
			if ("".equals(result[0]) || path.compareTo(result[0]) < 0) 
				result[0] = path;
		} else {
			if (node.left != null) dfs(node.left, path, result);
			if (node.right != null) dfs(node.right, path, result);
		}
	}
	
	
}
