package com.prep2020.medium;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem1530 {
	public int countPairs(TreeNode root, int distance) {
        int[] result = new int[] {0};
        solve(root, distance, result);
        return result[0];
    }
	
	private List<Integer> solve(TreeNode root, int distance, int[] result) {
		List<Integer> list = new ArrayList<>();
		if (root == null) return list;
		if (root.left == null && root.right == null) {
			list.add(1);
			return list;
		}
		List<Integer> left = solve(root.left, distance, result), right = solve(root.right, distance, result);
		for (int l : left) {
			for (int r : right) {
				if (l + r <= distance) result[0]++; 
			}
		}
		List<Integer> ret = new ArrayList<>();
		for (int l : left) if (l + 1 < distance) ret.add(l + 1);
		for (int r : right) if (r + 1 < distance) ret.add(r + 1);
		return ret;
	}
}
