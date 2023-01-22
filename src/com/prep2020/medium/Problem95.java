package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem95 {
	/**
	 * O(N^2) time and space
	 * @param n
	 * @return
	 */
	public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
	
	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> result = new ArrayList<>();
		if (start > end) {
			result.add(null);
			return result;
		}
		if (start == end) {
			result.add(new TreeNode(start));
			return result;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1), right = generateTrees(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					result.add(root);
				}
			}
		}
		return result;
	}
}
