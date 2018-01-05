package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ayanc on 1/4/18.
 */
public class Prob145 {
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) return result;
    Stack<Info> stack = new Stack<>();
    stack.push(new Info(root));
    while(!stack.isEmpty()){
      Info info = stack.pop();
      if(info.visited) result.add(info.root.val);
      else {
        TreeNode node = info.root;
        if(node.right == null && node.left == null) result.add(node.val);
        else {
          info.visited = true;
          stack.push(info);
          if(node.right != null) stack.push(new Info(node.right));
          if(node.left != null) stack.push(new Info(node.left));
        }
      }
    }
    return result;
  }
  class Info{
    TreeNode root;
    boolean visited;

    Info(TreeNode root){
      this.root = root;
    }
  }

  public static void main(String[] args){
    Prob145 prob145 = new Prob145();
    TreeNode root = new TreeNode(1);
    System.out.println(prob145.postorderTraversal(root));
  }
}
