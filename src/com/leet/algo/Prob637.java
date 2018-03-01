package com.leet.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ayanc on 2/23/18.
 */
public class Prob637 {
  public List<Double> averageOfLevels(TreeNode root){
    List<Double> result = new ArrayList<>();
    if (root == null) return result;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
      double sum = 0;
      int count = 0;
      Queue<TreeNode> temp = new LinkedList<>();
      while (!q.isEmpty()) {
        TreeNode node = q.poll();
        count++;
        sum += node.val;
        if (node.left != null) temp.offer(node.left);
        if (node.right != null) temp.offer(node.right);
      }
      q = temp;
      result.add(sum / count);
    }
    return result;
  }
}
