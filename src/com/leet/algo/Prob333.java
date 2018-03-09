package com.leet.algo;

import java.util.Objects;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob333 {

  public int largestBSTSubtree(TreeNode root) {
    if (root == null) return 0;
    int[] result = new int[1];
    isBst(root, result);
    return result[0];
  }

  private int[] isBst(TreeNode root, int[] result) {
    if (root.left == null && root.right == null) {
      result[0] = Math.max(result[0], 1);
      return new int[]{1, root.val, root.val};
    }
    int[] left = null;
    if (root.left != null) {
      left = isBst(root.left, result);
    }
    int[] right = null;
    if (root.right != null) {
      right = isBst(root.right, result);
    }
    int[] r = new int[]{1, root.val, root.val};
    if (root.left != null){
      if(left == null || left[2] >= root.val) return null;
      else {
        r[1] = left[1];
        r[0] += left[0];
      }
    }
    if (root.right != null){
      if(right == null || right[1] <= root.val) return null;
      else {
        r[2] = right[2];
        r[0] += right[0];
      }
    }
    result[0] = Math.max(result[0], r[0]);
    return r;
  }

  /*public int largestBSTSubtree(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null && root.right == null) return 1;
    return (Integer)helper(root)[1];
  }

  public Object[] helper(TreeNode root){
    if (root == null) return new Object[]{null, 0, 0, 0};
    if (root.left == null && root.right == null) return new Object[]{root, 1, root.val, root.val};
    Object[] leftLargest = helper(root.left);
    Object[] rightLargest = helper(root.right);
    if (root.left == null) {
      if (rightLargest[0] == root.right && root.val < root.right.val && (Integer)rightLargest[2] > root.val)
        return new Object[]{root, (Integer)rightLargest[1] + 1, root.val, rightLargest[3]};
      else return rightLargest;
    }
    if (root.right == null) {
      if (leftLargest[0] == root.left && root.val > root.left.val && (Integer) leftLargest[3] < root.val)
        return new Object[]{root, (Integer)leftLargest[1] + 1, leftLargest[2], root.val};
      else return leftLargest;
    }
    if (leftLargest[0] == root.left && rightLargest[0] == root.right && root.val < root.right.val
        && root.val > root.left.val && (Integer)rightLargest[2] > root.val && (Integer) leftLargest[3] < root.val)
      return new Object[]{root, (Integer)leftLargest[1] + (Integer)rightLargest[1] + 1, leftLargest[2], rightLargest[3]};
    return (Integer)leftLargest[1] > (Integer)rightLargest[1] ? leftLargest : rightLargest;
  }*/

  public static void main(String[] args) {
    Prob333 prob333 = new Prob333();
    TreeNode root = null;

    root = new TreeNode(10);
    TreeNode five = new TreeNode(5);
    five.left = new TreeNode(1);
    five.right = new TreeNode(8);
    root.left = five;
    TreeNode fifteen = new TreeNode(15);
    fifteen.right = new TreeNode(7);
    root.right = fifteen;
    System.out.println(prob333.largestBSTSubtree(root));

    root = new TreeNode(3);
    TreeNode four = new TreeNode(4);
    four.left = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = four;
    System.out.println(prob333.largestBSTSubtree(root));
  }
}
