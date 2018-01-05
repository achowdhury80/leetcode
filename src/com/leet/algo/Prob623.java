package com.leet.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ayanc on 1/4/18.
 */
public class Prob623 {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if(root == null) return root;
    if(d == 1){
      TreeNode node = new TreeNode(v);
      node.left = root;
      return node;
    }
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    for(int i = 2; i < d; i++){
      List<TreeNode> temp = new ArrayList<>();
      for(TreeNode node : list){
        if(node.left != null) temp.add(node.left);
        if(node.right != null) temp.add(node.right);
      }
      list = temp;
    }
    for(TreeNode node : list){
      TreeNode left = new TreeNode(v);
      left.left = node.left;
      TreeNode right = new TreeNode(v);
      right.right = node.right;
      node.left = left;
      node.right = right;
    }
    return root;
  }
}
