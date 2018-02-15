package com.leet.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by ayanc on 2/13/18.
 */
public class Prob314 {
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
    Queue<Object[]> q = new LinkedList<>();
    q.add(new Object[]{root, 0});
    while (!q.isEmpty()) {
      Object[] objArr = q.poll();
      TreeNode node = (TreeNode) objArr[0];
      int degree = (Integer) objArr[1];
      if (!treeMap.containsKey(objArr[1])) treeMap.put(degree, new ArrayList<>());
      treeMap.get(degree).add(node.val);
      if (node.left != null) q.offer(new Object[]{node.left, degree - 1});
      if (node.right != null) q.offer(new Object[]{node.right, degree + 1});
    }
    for (int key : treeMap.keySet()) {
      result.add(treeMap.get(key));
    }
    return result;
  }
}
