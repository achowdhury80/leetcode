package com.leet.algo;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob549 {
  public int longestConsecutive(TreeNode root) {
    int[] maxVal = new int[1];
    longestConsecutive(root, maxVal);
    return maxVal[0];
  }

  private int[] longestConsecutive(TreeNode root, int[] maxVal) {
    if (root == null) return new int[]{0, 0};
    int incr = 1, decr = 1;
    int[] l = longestConsecutive(root.left, maxVal);
    int[] r = longestConsecutive(root.right, maxVal);
    if (root.left != null) {
      if (root.left.val == root.val + 1) incr = l[0] + 1;
      else if (root.left.val + 1 == root.val) decr = l[1] + 1;
    }
    if (root.right != null) {
      if (root.right.val == root.val + 1) incr = Math.max(incr, r[0] + 1);
      else if (root.right.val + 1 == root.val) decr = Math.max(decr, r[1] + 1);
    }
    maxVal[0] = Math.max(maxVal[0], incr + decr - 1);
    return new int[]{incr, decr};
  }

  public static void main(String[] args) {
    Prob549 prob549 = new Prob549();
    TreeNode root = null;
    root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println(prob549.longestConsecutive(root));

    root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    System.out.println(prob549.longestConsecutive(root));

    root = new TreeNode(1);
    System.out.println(prob549.longestConsecutive(root));


    root = new TreeNode(1);
    TreeNode two = new TreeNode(2);
    TreeNode three = new TreeNode(3);
    three.left = new TreeNode(4);
    two.left = three;
    root.left = two;
    System.out.println(prob549.longestConsecutive(root));
  }
}
