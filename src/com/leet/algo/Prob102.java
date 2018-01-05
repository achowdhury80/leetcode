package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/4/18.
 */
public class Prob102 {
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if(root == null) return result;
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    while (!list.isEmpty()){
      List<TreeNode> temp = new ArrayList<>();
      List<Integer> vals = new ArrayList<>();
      for(TreeNode node : list){
        vals.add(node.val);
        if(node.left != null) temp.add(node.left);
        if(node.right != null) temp.add(node.right);
      }
      list = temp;
      result.add(vals);
    }
    return result;
  }
}
