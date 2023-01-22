package com.prep2020.hard;

import com.prep2020.TreeNode;

public class Problem1028 {
	/**
	 * O(N) time and O(N) space (worst case)
	 * @param S
	 * @return
	 */
	public TreeNode recoverFromPreorder(String S) {
        if (S == null || "".equals(S)) return null;
        return helper(S, new int[] {0}, 0);
    }
	
	private TreeNode helper(String s, int[] start, int depth) {
		if (start[0] >= s.length()) return null;
		for(int i = 0; i < depth; i++) {
			if (start[0] + i == s.length() || s.charAt(start[0] + i) != '-') return null;
		}
		int temp = start[0] + depth;
		int val = 0;
		char c;
		while(temp < s.length() && (c = s.charAt(temp)) != '-') {
			val = val * 10 + (c - '0');
			temp++;
		}
		TreeNode root = new TreeNode(val);
		start[0] = temp;
		root.left = helper(s, start, depth + 1);
		root.right = helper(s, start, depth + 1);
		return root;
	}
	
	public static void main(String[] args) {
		Problem1028 problem = new Problem1028();
		System.out.println(problem.recoverFromPreorder("1-2--3--4-5--6--7"));
	}
}
