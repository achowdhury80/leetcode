package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1110 {
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> result = new ArrayList<>();
		if (root == null) return result;
		boolean[] arr = new boolean[1001];
		for (int i : to_delete) arr[i] = true;
		dfs(root, arr);
		if (root != null && root.val != 0) result.add(root);
		helper(root, result);
		return result;
    }
	
	private void dfs(TreeNode root, boolean[] arr) {
		if (root == null) return;
		if (arr[root.val]) root.val = 0;
		dfs(root.left, arr);
		dfs(root.right, arr);
	}
	
	private TreeNode helper(TreeNode root, List<TreeNode> result) {
		if (root == null) return null;
		if (root.val == 0) {
			if (root.left != null && root.left.val != 0) result.add(root.left);
			helper(root.left, result);
			if (root.right != null && root.right.val != 0) result.add(root.right);
			helper(root.right, result);
			return null;
		} else {
			root.left = helper(root.left, result);
			root.right = helper(root.right, result);
			return root;
		}
	}
}
