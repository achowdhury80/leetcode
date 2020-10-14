package comp.prep2019.less2000;
import java.util.*;

import comp.prep2019.TreeNode;
public class Prob1382 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public TreeNode balanceBST(TreeNode root) {
		if (root == null) return null;
        List<TreeNode> list = new ArrayList<>();
        traverseInOrder(root, list);
        return bulidBalancedTree(list, 0, list.size() - 1);
    }
	
	private void traverseInOrder(TreeNode root, List<TreeNode> list) {
		if (root.left != null) traverseInOrder(root.left, list);
		list.add(root);
		if (root.right != null) traverseInOrder(root.right, list);
	}
	
	private TreeNode bulidBalancedTree(List<TreeNode> list, int start, int end) {
		if (start > end) return null;
		if (start == end) {
			TreeNode root = list.get(start);
			root.left = null;
			root.right = null;
			return root;
		}
		int mid = start + (end - start) / 2;
		TreeNode root = list.get(mid);
		root.left = bulidBalancedTree(list, start, mid - 1);
		root.right = bulidBalancedTree(list, mid + 1, end);
		return root;
	}
}
