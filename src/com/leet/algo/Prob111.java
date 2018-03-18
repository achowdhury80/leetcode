package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 3/16/18.
 */
public class Prob111 {
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int result = 0;
    while (!q.isEmpty()) {
      result++;
      int size = q.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = q.poll();
        if (node.left == null && node.right == null) return result;
        if (node.left != null) q.offer(node.left);
        if (node.right != null) q.offer(node.right);
      }
    }
    return result;
  }
}
