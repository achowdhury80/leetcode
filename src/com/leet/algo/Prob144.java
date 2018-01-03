package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ayanc on 1/2/18.
 */
public class Prob144 {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) return result;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while(!stack.empty()){
      TreeNode node = stack.pop();
      result.add(node.val);
      if(node.right != null) stack.push(node.right);
      if(node.left != null) stack.push(node.left);
    }
    return result;
  }
}
