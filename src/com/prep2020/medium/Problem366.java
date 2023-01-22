package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem366 {
	/**
	 * O(N)
	 * @param root
	 * @return
	 */
	public List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		findMaxDepth(root, result);
		return result;
    }
	
	private int findMaxDepth(TreeNode root, List<List<Integer>> result) {
		if (root.left == null && root.right == null) {
			if (result.isEmpty()) result.add(new ArrayList<>());
			result.get(0).add(root.val);
			return 0;
		}
		int depth = 0;
		if (root.left != null) depth = findMaxDepth(root.left, result);
		if (root.right != null) depth = Math.max(depth, findMaxDepth(root.right, result));
		depth++;
		if (depth == result.size()) result.add(new ArrayList<>());
		result.get(depth).add(root.val);
		return depth;
	}
}
