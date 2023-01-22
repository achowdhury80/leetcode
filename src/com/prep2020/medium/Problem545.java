package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem545 {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root.left != null || root.right != null) result.add(root.val);
		if (root.left != null) addLeftBoundary(root.left, result);
		addLeaves(root, result);
		if (root.right != null) {
			List<Integer> rightBoundary = new ArrayList<>();
			addRightBoundary(root.right, rightBoundary);
			result.addAll(rightBoundary);
		}
		return result;
    }
	
	private void addLeftBoundary(TreeNode root, List<Integer> result) {
		if (root.left == null && root.right == null) return;
		result.add(root.val);
		if (root.left != null) addLeftBoundary(root.left, result);
		else addLeftBoundary(root.right, result);
	}
	
	private void addLeaves(TreeNode root, List<Integer> result) {
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return;
		}
		if (root.left != null) addLeaves(root.left, result);
		if (root.right != null) addLeaves(root.right, result);
	}
	
	private void addRightBoundary(TreeNode root, List<Integer> rightBoundary) {
		if (root.left == null && root.right == null) return;
		rightBoundary.add(0, root.val);
		if (root.right != null) addRightBoundary(root.right, rightBoundary);
		else addRightBoundary(root.left, rightBoundary);
	}
}
