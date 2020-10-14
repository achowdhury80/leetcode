package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob654 {
	/**
	 * O(N^2) - worst. O(NlogN) average
	 * O(N) space worst
	 * @param nums
	 * @return
	 */
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length < 1) return null;
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

	private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start == end) return new TreeNode(nums[start]);
        int maxIdx = findMaxIndex(nums, start, end);
        TreeNode result = new TreeNode(nums[maxIdx]);
        if (maxIdx != start) result.left = constructMaximumBinaryTree(nums, start, maxIdx - 1);
        if (maxIdx != end) result.right = constructMaximumBinaryTree(nums, maxIdx + 1, end);
        return result;
    }
	
	private int findMaxIndex(int[] nums, int start, int end) {
		int result = start, max = nums[start];
		start++;
		while(start <= end) {
			if (nums[start] > max) {
				result = start;
				max = nums[start];
			}
			start++;
		}
		return result;
	}
}
