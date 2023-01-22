package com.prep2020.easy;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem257 {
	/**
	 * O(N) time and o(H) space
	 * @param root
	 * @return
	 */
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, "");
        return result;
    }
	
	private void helper(TreeNode root, List<String> result, String path) {
		path += "->" + root.val;
		if (root.left == null && root.right == null) {
			result.add(path.substring(2));
			return;
		}
		if (root.left != null) helper(root.left, result, path);
		if (root.right != null) helper(root.right, result, path);
	}

}
