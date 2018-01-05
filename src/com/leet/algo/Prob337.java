package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/4/18.
 */
public class Prob337 {
  public int rob(TreeNode root) {
    if(root == null) return 0;
    int[] sums = robx(root);
    return Math.max(sums[0], sums[1]);
  }

  private int[] robx(TreeNode root){
    if(root == null) return new int[2];
    int[] left = robx(root.left);
    int[] right = robx(root.right);
    return new int[]{root.val + left[1] + right[1], Math.max(left[0], left[1]) + Math.max(right[0], right[1])};
  }

  public static void main(String[] args){
    Prob337 prob337 = new Prob337();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    System.out.println(prob337.rob(root));
  }
}
