package com.leet.algo;
import java.util.*;
public class Prob1110 {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) set.add(i);
        List<TreeNode> result = new ArrayList<>();
        helper(root, set, true, result);
        return result;
    }
	
	private TreeNode helper(TreeNode root, Set<Integer> set, boolean isRoot, List<TreeNode> result) {
		if (root == null) return null;
		boolean deleted = set.contains(root.val);
		if (isRoot && !deleted) result.add(root);
		root.left = helper(root.left, set, deleted, result);
		root.right = helper(root.right, set, deleted, result);
		return deleted ? null : root;
	}
}
