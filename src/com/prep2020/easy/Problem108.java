package com.prep2020.easy;

import com.prep2020.TreeNode;

public class Problem108 {
	/**
	 * O(N) time and O(logN) for stack
	 * @param nums
	 * @return
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1) return null;
        return helper(nums, 0, nums.length - 1);
    }
	
	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end) return null;
		if (start == end) return new TreeNode(nums[start]);
		int mid = start + (end - start) / 2;
		TreeNode result = new TreeNode(nums[mid]);
		result.left = helper(nums, start, mid - 1);
		result.right = helper(nums, mid + 1, end);
		return result;
	}
}
