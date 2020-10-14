package comp.prep2019.less1000;

import java.util.ArrayDeque;
import java.util.Deque;

import comp.prep2019.TreeNode;

public class Prob99 {
	public void recoverTree(TreeNode root) {
		TreeNode x = null, y = null, predecessor = null, pred = null;
		while(root != null) {
			if (root.left != null) {
				predecessor = root.left;
				while(predecessor.right != null && predecessor.right != root) 
					predecessor = predecessor.right;
				if (predecessor.right == null) {
					predecessor.right = root;
					root = root.left;
				} else {
					if (pred != null && root.val < pred.val) {
						y = root;
						if (x == null) x = pred;
						else break;
					}
					pred = root;
					predecessor.right = null;
					root = root.right;
				}
			} else {
				if (pred != null && root.val < pred.val) {
					y = root;
					if (x == null) x = pred;
					else break;
				}
				pred = root;
				root = root.right;
			}
		}
		swap(x, y);
	}
	
	private void swap(TreeNode a, TreeNode b) {
		int temp = a.val;
		a.val = b.val;
		b.val = temp;
	}
}
