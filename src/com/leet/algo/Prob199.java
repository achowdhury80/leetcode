package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/4/18.
 */
public class Prob199 {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) return result;
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    while (!list.isEmpty()){
      List<TreeNode> temp = new ArrayList<>();
      int val = 0;
      for(TreeNode node : list){
        if(node.left != null) {
          temp.add(node.left);
        }
        if(node.right != null) {
          temp.add(node.right);
        }
        val = node.val;
      }
      list = temp;
      result.add(val);
    }
    return result;
  }
}
