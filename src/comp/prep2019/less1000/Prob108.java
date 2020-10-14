package comp.prep2019.less1000;

import comp.prep2019.TreeNode;

public class Prob108 {
	public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
	
	private TreeNode helper(int[] nums, int start, int end) {
		if (start > end) return null;
		if (start == end) return new TreeNode(nums[start]);
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, start, mid - 1);
		node.right = helper(nums, mid + 1, end);
		return node;
	}
}