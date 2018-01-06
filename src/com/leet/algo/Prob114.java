package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob114 {
  public void flatten(TreeNode root) {
    if(root == null || (root.left == null && root.right == null)) return;
    Stack<TreeNode> stack = new Stack<>();
    if(root.right != null)stack.push(root.right);
    if(root.left != null) stack.push(root.left);
    root.left = null;
    while(!stack.isEmpty()){
      TreeNode node = stack.pop();
      root.right = node;
      if(node.right != null) stack.push(node.right);
      node.right = null;
      if(node.left != null) stack.push(node.left);
      node.left = null;
      root = root.right;
    }
  }
}
