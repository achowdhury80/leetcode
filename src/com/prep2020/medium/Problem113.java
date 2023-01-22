package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem113 {
	/**
	 * O(N) time and O(H) space
	 * @param root
	 * @param targetSum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		helper(result, root, targetSum, new ArrayList<>());
		return result;
    }
	
	private void helper(List<List<Integer>> result, TreeNode root, int target, List<Integer> temp) {
		target -= root.val;
		temp.add(root.val);
		if (root.left == null && root.right == null) {
			if (target == 0) {
				result.add(new ArrayList<>(temp));
			}
		}
		if (root.left != null) helper(result, root.left, target, temp);
		if (root.right != null) helper(result, root.right, target, temp);
		temp.remove(temp.size() - 1);
	}
}
