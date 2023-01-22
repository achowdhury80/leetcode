package com.prep2020.easy;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem872 {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		if (root1 == root2) return true;
		if (root1 == null || root2 == null) return false;
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        findLeaves(root1, list1);
        findLeaves(root2, list2);
        return list1.equals(list2);
    }
	
	private void findLeaves(TreeNode root, List<Integer> list) {
		if (root.left == null && root.right == null) list.add(root.val);
		if (root.left != null) findLeaves(root.left, list);
		if (root.right != null) findLeaves(root.right, list);
	}
}
