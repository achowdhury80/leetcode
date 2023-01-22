package com.prep2020.medium;

import com.prep2020.TreeNode;

public class Problem654 {
	/**
	 * Time complexity : O(n^2)O(n 
2
 ). The function construct is called nn times. At each level of the recursive tree, we traverse over all the nn elements to find the maximum element. In the average case, there will be a \log nlogn levels leading to a complexity of O\big(n\log n\big)O(nlogn). In the worst case, the depth of the recursive tree can grow upto nn, which happens in the case of a sorted numsnums array, giving a complexity of O(n^2)O(n 
2
 ).

Space complexity : O(n)O(n). The size of the setset can grow upto nn in the worst case. In the average case, the size will be \log nlogn for nn elements in numsnums, giving an average case complexity of O(\log n)O(logn)
	 * @param nums
	 * @return
	 */
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
	
	private TreeNode helper(int[] nums, int start, int end) {
        int maxValIndex = findMaxValIndex(nums, start, end);
        TreeNode root = new TreeNode(nums[maxValIndex]);
        if (maxValIndex > start) root.left = helper(nums, start, maxValIndex - 1);
        if (maxValIndex < end) root.right = helper(nums, maxValIndex + 1, end);
        return root;
    }
	
	private int findMaxValIndex(int[] arr, int start, int end) {
		int result = start;
		for (int i = start + 1; i <= end; i++) {
			if (arr[i] > arr[result]) result = i;
		}
		return result;
	}
}
