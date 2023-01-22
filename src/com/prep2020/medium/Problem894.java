package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem894 {
	/**
	 * O(2^N)
	 * @param N
	 * @return
	 */
	public List<TreeNode> allPossibleFBT(int N) {
		List<TreeNode>[] dp = new List[N + 1];
		dp[1] = new ArrayList<>();
		dp[1].add(new TreeNode(0));
		for (int i = 3; i <= N; i += 2) {
			dp[i] = new ArrayList<>();
			for (int j = 1; j < i; j += 2) {
				List<TreeNode> lefts = dp[j], rights = dp[i - j - 1];
				if (rights == null) continue;
				for (TreeNode left : lefts) {
					for (TreeNode right : rights) {
						TreeNode root = new TreeNode(0);
						root.left = left;
						root.right = right;
						dp[i].add(root);
					}
				}
			}
		}
		return dp[N] == null ? new ArrayList<>() : dp[N];
    }
}
