package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob545 {
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		List<Integer> leftBoundary = new ArrayList<>();
		List<Integer> rightBoundary = new ArrayList<>();
		List<Integer> leaves = new ArrayList<>();
		if (root.left != null) findLeftBoundary(root.left, leftBoundary);
		if (root.right != null) findRightBoundary(root.right, rightBoundary);
		findLeaves(root, leaves);
		if (root.left != null || root.right != null) result.add(root.val);
		result.addAll(leftBoundary);
		result.addAll(leaves);
		result.addAll(rightBoundary);
		return result;
    }
	
	private void findLeaves(TreeNode root, List<Integer> leaves) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			leaves.add(root.val);
			return;
		}
		findLeaves(root.left, leaves);
		findLeaves(root.right, leaves);
	}
	
	private void findLeftBoundary(TreeNode root, List<Integer> leftBoundary) {
		if (root.left == null && root.right == null) return;
		leftBoundary.add(root.val);
		if (root.left != null) findLeftBoundary(root.left, leftBoundary);
		else findLeftBoundary(root.right, leftBoundary);
	}
	
	private void findRightBoundary(TreeNode root, List<Integer> rightBoundary) {
		if (root.left == null && root.right == null) return;
		rightBoundary.add(0, root.val);
		if (root.right != null) findRightBoundary(root.right, rightBoundary);
		else findRightBoundary(root.left, rightBoundary);
	}
}
