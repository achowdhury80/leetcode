package com.prep2020.medium;

import java.util.*;

import com.prep2020.TreeNode;

public class Problem1261 {
	private Set<Integer> set;
	public Problem1261(TreeNode root) {
		set = new HashSet<>();
        helper(root, new int[] {0});
    }
	
	private void helper(TreeNode root, int[] val) {
		root.val = val[0];
		set.add(root.val);
		if (root.left != null) helper(root.left, new int[] {val[0] * 2 + 1});
		if (root.right != null) helper(root.right, new int[] {val[0] * 2 + 2});
	}
    
    public boolean find(int target) {
        return set.contains(target);
    }
}
