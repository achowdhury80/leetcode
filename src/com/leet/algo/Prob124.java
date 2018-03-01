package com.leet.algo;

/**
 * Created by ayanc on 2/27/18.
 */
public class Prob124 {
  private long max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    if (root == null) return 0;
    helper(root);
    return (int)max;
  }
  public long helper(TreeNode root) {
    if (root == null) return Integer.MIN_VALUE;
    long leftPathSum = helper(root.left);
    long rightPathSum = helper(root.right);
    max = Math.max(max, leftPathSum);
    max = Math.max(max, rightPathSum);
    max = Math.max(max, root.val);
    max = Math.max(max, root.val + leftPathSum);
    max = Math.max(max, root.val + rightPathSum);
    max = Math.max(max, root.val + rightPathSum + leftPathSum);
    long bigger = leftPathSum;
    if (rightPathSum > leftPathSum) bigger = rightPathSum;
    if (root.val + bigger > root.val) return root.val + bigger;
    return root.val;
  }

  public static void main(String[] args) {
    Prob124 prob124 = new Prob124();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(prob124.maxPathSum(root));
//    TreeNode root = new TreeNode(-3);
//    System.out.println(prob124.maxPathSum(root));
  }
}
