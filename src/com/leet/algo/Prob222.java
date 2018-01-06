package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob222 {
  public int countNodes(TreeNode root) {
    int h = height(root);
    return h == - 1 ? 0 :
        height(root.right) == h - 1 ? (1 << h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
  }

  private int height(TreeNode root){
    return root == null ? - 1 : 1 + height(root.left);
  }
}
