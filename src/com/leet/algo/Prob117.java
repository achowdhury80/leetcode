package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 1/7/18.
 */
public class Prob117 {
  public void connect(TreeLinkNode root) {
    if (root == null) return;
    Stack<TreeLinkNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      Stack<TreeLinkNode> temp = new Stack<>();
      TreeLinkNode last = null;
      while (!stack.isEmpty()) {
        TreeLinkNode node = stack.pop();
        node.next = last;
        last = node;
        if (node.right != null) temp.push(node.right);
        if (node.left != null) temp.push(node.left);
      }
      while (!temp.isEmpty()) stack.push(temp.pop());
    }
  }

  class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
    }
  }
}
