package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 11/14/17.
 */
public class Prob515 {
  public List<Integer> largestValues(TreeNode root) {
    if(root == null) return new ArrayList<>();
    return largestValues(Arrays.asList(new TreeNode[]{root}));
  }

  public List<Integer> largestValues(List<TreeNode> list) {
    int max = Integer.MIN_VALUE;
    List<TreeNode> newList = new ArrayList<>();
    for(TreeNode treeNode: list){
      if(treeNode.left != null) newList.add(treeNode.left);
      if(treeNode.right != null) newList.add(treeNode.right);
      if(treeNode.val > max) max = treeNode.val;
    }
    List<Integer> result = new ArrayList<>();
    result.add(max);
    if(newList.size() > 0) result.addAll(largestValues(newList));
    return result;
  }
}
