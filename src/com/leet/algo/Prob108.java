package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    if(nums == null || nums.length == 0) return null;
    return sortedArrayToBST(nums, 0, nums.length - 1);
  }

  public TreeNode sortedArrayToBST(int[] nums, int lower, int upper) {
    if(lower == upper) return new TreeNode(nums[lower]);
    int mid = (lower + upper) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    if(mid > lower) root.left = sortedArrayToBST(nums, lower, mid - 1);
    if(mid < upper) root.right = sortedArrayToBST(nums, mid + 1, upper);
    return root;
  }
}
