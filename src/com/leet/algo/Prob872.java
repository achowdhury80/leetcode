package com.leet.algo;
import java.util.*;
public class Prob872 {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		dfs(root1, list1);
		dfs(root2, list2);
		if (list1.size() == list2.size()) {
			for (int i = 0; i < list1.size(); i++) {
				if(list1.get(i) != list2.get(i)) return false;
			}
			return true;
		}
		return false;
    }
	
	private void dfs(TreeNode root, List<Integer> list) {
		if (root == null) return;
		if (root.left == null && root.right == null) {
			list.add(root.val);
			return;
		}
		dfs(root.left, list);
		dfs(root.right, list);
	}
}
