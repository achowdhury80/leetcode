package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob104 {
  public int maxDepth(TreeNode root) {
    if(root == null) return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int depth = 0;
    while (!q.isEmpty()) {
      depth++;
      Queue<TreeNode> temp = new LinkedList();
      while(!q.isEmpty()) {
        TreeNode node = q.poll();
        if (node.left != null) temp.offer(node.left);
        if (node.right != null) temp.offer(node.right);
      }
      q = temp;
    }
    return depth;
  }
}
