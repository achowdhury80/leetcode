package com.leet.algo;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob250 {
  public int countUnivalSubtrees(TreeNode root) {
    return helper(root)[0];
  }

  public int[] helper(TreeNode root){
    if (root == null) return new int[]{0, 0};
    if (root.left == null && root.right == null) return new int[]{1, 1};
    int[] leftResult = helper(root.left);
    int[] rightResult = helper(root.right);
    int isUnival = 0;
    if ((leftResult[0] == 0 && rightResult[0] == 0)
        || (leftResult[0] == 0 && rightResult[1] == 1 && root.val == root.right.val)
        || (rightResult[0] == 0 && leftResult[1] == 1 && root.val == root.left.val)
        || (leftResult[1] == 1 && rightResult[1] == 1 && root.val == root.right.val && root.val == root.left.val)) isUnival = 1;
    return new int[]{leftResult[0] + rightResult[0] + isUnival, 0 + isUnival};
  }

  public static void main(String[] args) {
    Prob250 prob250 = new Prob250();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    System.out.println(prob250.countUnivalSubtrees(root));
  }


}
