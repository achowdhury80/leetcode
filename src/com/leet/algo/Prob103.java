package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ayanc on 1/2/18.
 */
public class Prob103 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) return result;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    boolean leftOrdered = true;
    while(!stack.isEmpty()){
      List<Integer> list = new ArrayList<>();
      Stack<TreeNode> tempStack = new Stack<>();
      while(!stack.isEmpty()){
        TreeNode node = stack.pop();
        list.add(node.val);
        if(leftOrdered){
          if(node.left != null) tempStack.push(node.left);
          if(node.right != null) tempStack.push(node.right);
        } else {
          if(node.right != null) tempStack.push(node.right);
          if(node.left != null) tempStack.push(node.left);
        }
      }
      result.add(list);
      leftOrdered ^= true;
      stack = tempStack;
    }
    return result;
  }
}
