package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 11/14/17.
 */
public class Prob513 {
  public int findBottomLeftValue(TreeNode root) {
    List<TreeNode> list = new ArrayList<>();
    list.add(root);
    return findBottomLeftValue(list);
  }


  public int findBottomLeftValue(List<TreeNode> list){
    List<TreeNode> nextList = new ArrayList<>();
    for(TreeNode node: list){
      if(node.left != null) nextList.add(node.left);
      if(node.right != null) nextList.add(node.right);
    }
    if(nextList.size() == 0){
      return list.get(0).val;
    }
    return findBottomLeftValue(nextList);
  }
}
