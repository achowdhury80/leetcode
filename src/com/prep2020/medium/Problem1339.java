package com.prep2020.medium;

import java.util.HashMap;
import java.util.Map;

import com.prep2020.TreeNode;
public class Problem1339 {
	public int maxProduct(TreeNode root) {
		Map<TreeNode, Integer> map = new HashMap<>();
		findSum(root, map);
		int sum = map.get(root);
		int[] closestButSmallerThanHalf = new int[] {sum};
		findCeilValue(root, sum / 2, closestButSmallerThanHalf, map);
		return (int)((closestButSmallerThanHalf[0] * (sum + 0l - closestButSmallerThanHalf[0])) % (1e9 + 7));
    }
	
	private int findSum(TreeNode root, Map<TreeNode, Integer> map) {
		if (root == null) return 0;
		int left = findSum(root.left, map);
		int right = findSum(root.right, map);
		int sum = left + root.val + right;
		map.put(root, sum);
		return sum;
	}
	
	private void findCeilValue(TreeNode root, int mid, int[] closest, Map<TreeNode, Integer> map) {
		if(root == null) return;
		int sum = map.get(root);
		if (sum == mid) {
			closest[0] = mid;
		} else {
			if (Math.abs(mid - closest[0]) > Math.abs(mid - sum)) {
				closest[0] = sum;
			}
			if (sum > mid) {
				findCeilValue(root.left, mid, closest, map);
				findCeilValue(root.right, mid, closest, map);
			}
		}
	}
}
