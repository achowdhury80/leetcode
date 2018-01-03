package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 1/2/18.
 */
public class Prob173 {
  private Stack<TreeNode> stack;
  public Prob173(TreeNode root) {
    if(root == null) return;
    stack = new Stack<>();
    stack.push(root);
    while(stack.peek().left != null) stack.push(stack.peek().left);
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return stack != null && !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.pop();
    int val = node.val;
    if(node.right != null){
      stack.push(node.right);
      while(stack.peek().left != null) stack.push(stack.peek().left);
    }
    return val;
  }
}
