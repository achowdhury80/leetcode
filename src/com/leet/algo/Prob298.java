package com.leet.algo;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob298 {
  public int longestConsecutive(TreeNode root) {
    int[] maxVal = new int[1];
    helper(root, maxVal);
    return maxVal[0];
  }

  private int helper(TreeNode root, int[] maxVal) {
    if (root == null) return 0;
    int left = helper(root.left, maxVal);
    int right = helper(root.right, maxVal);
    int incr = 1;
    if (root.left != null) {
      if (root.left.val == root.val + 1) incr += left;
    }
    if (root.right != null) {
      if (root.right.val == root.val + 1) incr = Math.max(incr, 1 + right);
    }
    maxVal[0] = Math.max(maxVal[0], incr);
    return incr;
  }

  public static void main(String[] args) {
    Prob298 prob298 = new Prob298();
    TreeNode root = null;

    root = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    TreeNode two = new TreeNode(2);
    two.left = new TreeNode(1);
    three.left = two;
    root.right = three;

    System.out.println(prob298.longestConsecutive(root));

    root = new TreeNode(1);
    three = new TreeNode(3);
    two = new TreeNode(2);
    two.left = new TreeNode(1);
    three.right = new TreeNode(4);
    root.right = three;
    three.right.right = new TreeNode(5);

    System.out.println(prob298.longestConsecutive(root));
  }
}
